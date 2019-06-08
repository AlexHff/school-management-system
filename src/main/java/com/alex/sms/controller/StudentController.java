package com.alex.sms.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.ClassNotFoundException;
import com.alex.sms.exception.StudentNotFoundException;
import com.alex.sms.model.Grade;
import com.alex.sms.model.Registration;
import com.alex.sms.model.ReportCard;
import com.alex.sms.model.ReportCardDetail;
import com.alex.sms.model.Student;
import com.alex.sms.repository.GradeRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.ReportCardDetailRepository;
import com.alex.sms.repository.ReportCardRepository;
import com.alex.sms.repository.StudentRepository;

@Controller
@RequestMapping(path="/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private ReportCardRepository reportCardRepository;

	@Autowired
	private ReportCardDetailRepository reportCardDetailRepository;

	@Autowired
	private GradeRepository gradeRepository;
	
	@GetMapping("/dashboard")
    public String studentIndex(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentRepository.findAll());
        return "student/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public String getStudent (@PathVariable(value = "id") Integer id, Model model)
			throws StudentNotFoundException {
		Student s = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException());
        model.addAttribute("student", s);
		if(s != null) {
			Registration r = registrationRepository.findByStudentId(s.getId());
			if(r != null) {
				ReportCard p = reportCardRepository.findByRegistrationId(r.getId());
		        model.addAttribute("registration", r);
				if(p != null) {
					Iterable<ReportCardDetail> q = reportCardDetailRepository.findByReportCardId(p.getId());
			        model.addAttribute("reportCard", p);
					if(q != null) {
						List<ReportCardDetail> list = (List<ReportCardDetail>) q;
						List<Grade> grades = new ArrayList<Grade>();
						List<Double> means = new ArrayList<Double>();
						int j, sum;
						double mean;
						for(int i = 0; i < list.size(); ++i) {
							List<Grade> g = (List<Grade>) gradeRepository.findByReportCardDetailId(list.get(i).getId());
							j = 0;
							sum = 0;
							mean = 0;
							for(int k = 0; k < g.size(); ++k) {
								grades.add(g.get(k));
								sum += g.get(k).getValue();
								j = k + 1;
							}
							if(j != 0)
								mean = (double) sum / j;
							else
								mean = 0;
							means.add(mean);
						}
						/** **/
						for(int i = 0; i < grades.size(); ++i)
							System.out.println(grades.get(i).getReportCardDetail().getTeaching().getSubject()
									.getName() + " " + grades.get(i).getValue() + " " + grades.get(i)
									.getAppreciation());
				        System.out.println(means);
						/** **/
				        model.addAttribute("reportCardDetails", q);
				        model.addAttribute("grades", grades);
					}
				}
			}
		}
		return "student/view";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping(path="/search")
	public String searchStudent (@RequestParam(value = "search", required = false) String q, Model model)
			throws ClassNotFoundException {
		System.out.println(q);
		Iterable<Student> students = studentRepository.findByNameOrForenameContaining(q, q);
        model.addAttribute("students", students);
		return "student/result";
	}

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student s) {
		studentRepository.save(s);
        return "redirect:dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormStudent(@PathVariable(value = "id") Integer id,
			Model model) throws StudentNotFoundException {
    	Student s = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException());
    	model.addAttribute("student", s);
		return "student/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateStudent(@ModelAttribute Student s) {
		studentRepository.save(s);
		return "redirect:/student/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteStudent(@ModelAttribute Student s) {
		studentRepository.delete(s);
        return "redirect:dashboard";
    }
}
