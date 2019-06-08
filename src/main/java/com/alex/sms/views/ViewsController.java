package com.alex.sms.views;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.alex.sms.model.SchoolYear;
import com.alex.sms.repository.ClassRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.SchoolRepository;
import com.alex.sms.repository.SchoolYearRepository;
import com.alex.sms.repository.StudentRepository;
import com.alex.sms.repository.SubjectRepository;
import com.alex.sms.repository.TeacherRepository;

@Controller
@RequestMapping
public class ViewsController {
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private SchoolRepository schoolRepository;
	
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	@Autowired
	private ClassRepository classRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private RegistrationRepository registrationRepository;
	
	@GetMapping("/")
	public String index(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
        model.addAttribute("registrations", registrationRepository.findFirst5ByOrderByTimestampDesc());
        model.addAttribute("schoolYears", schoolYearRepository.findFirst5ByOrderByIdDesc());
        Iterable<SchoolYear> years = schoolYearRepository.findFirst5ByOrderByIdDesc();
        List<SchoolYear> list = (List<SchoolYear>) years;
        for(int i = 0; i < list.size(); ++i) {
        	String attributeName = "class" + i;
        	Iterable<com.alex.sms.model.Class> attributeValue = classRepository
        			.findBySchoolYearId(list.get(i).getId());
        	model.addAttribute(attributeName, attributeValue);
        }
		return "index";
	}
	
	@ResponseStatus(value=HttpStatus.NOT_FOUND)
	public String error404() {
		return "error/404";
	}
}
