package com.alex.sms.views;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alex.sms.repository.ClassRepository;
import com.alex.sms.repository.SchoolRepository;
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
	private ClassRepository classRepository;

	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping("/")
	public String index(Model model) {
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("teachers", teacherRepository.findAll());
        model.addAttribute("schools", schoolRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        model.addAttribute("subjects", subjectRepository.findAll());
		return "index";
	}
	
	@GetMapping("*")
	public String error404() {
		return "error/404";
	}
	
	@GetMapping("/test")
	public String dist() {
		return "dist/html/index";
	}
}
