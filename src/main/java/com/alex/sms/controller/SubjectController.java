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

import com.alex.sms.exception.SubjectNotFoundException;
import com.alex.sms.model.Subject;
import com.alex.sms.repository.SubjectRepository;

@Controller
@RequestMapping(path="/subject")
public class SubjectController {
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping("/dashboard")
    public String subjectIndex(Model model) {
        model.addAttribute("subject", new Subject());
        model.addAttribute("subjects", subjectRepository.findAll());
        return "subject/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody Subject getSubject (@PathVariable(value = "id") Integer id)
			throws SubjectNotFoundException {
		Subject s = subjectRepository.findById(id)
				.orElseThrow(() -> new SubjectNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Subject> getAllSubjects() {
		return subjectRepository.findAll();
	}

    @PostMapping("/create")
    public String createSubject(@ModelAttribute Subject s) {
		subjectRepository.save(s);
        return "redirect:dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormSubject(@PathVariable(value = "id") Integer id,
			Model model) throws SubjectNotFoundException {
    	model.addAttribute("subject", this.getSubject(id));
		return "subject/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateSubject(@ModelAttribute Subject s) {
		subjectRepository.save(s);
		return "redirect:/subject/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteSubject(@ModelAttribute Subject s) {
		subjectRepository.delete(s);
        return "redirect:dashboard";
    }
}
