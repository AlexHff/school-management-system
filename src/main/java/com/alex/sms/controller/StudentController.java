package com.alex.sms.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.StudentNotFoundException;
import com.alex.sms.model.Student;
import com.alex.sms.repository.StudentRepository;

@Controller
@RequestMapping(path="/student")
public class StudentController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/dashboard")
    public String studentIndex(Model model) {
        model.addAttribute("student", new Student());
        model.addAttribute("students", studentRepository.findAll());
        return "student/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody Student getStudent (@PathVariable(value = "id") Integer id)
			throws StudentNotFoundException {
		Student s = studentRepository.findById(id)
				.orElseThrow(() -> new StudentNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Student> getAllStudents() {
		return studentRepository.findAll();
	}

    @PostMapping("/create")
    public String createStudent(@ModelAttribute Student s) {
		studentRepository.save(s);
        return "redirect:dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormStudent(@PathVariable(value = "id") Integer id,
			Model model) throws StudentNotFoundException {
    	model.addAttribute("student", this.getStudent(id));
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
