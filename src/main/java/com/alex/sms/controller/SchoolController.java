package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.SchoolNotFoundException;
import com.alex.sms.model.School;
import com.alex.sms.repository.SchoolRepository;

@Controller
@RequestMapping(path="/school")
public class SchoolController {
	@Autowired
	private SchoolRepository schoolRepository;
	
	@GetMapping("/dashboard")
    public String schoolIndex(Model model) {
        model.addAttribute("school", new School());
        model.addAttribute("schools", schoolRepository.findAll());
        return "school/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody School getSchool (@PathVariable(value = "id") Integer id)
			throws SchoolNotFoundException {
		School s = schoolRepository.findById(id)
				.orElseThrow(() -> new SchoolNotFoundException(id));
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<School> getAllSchools() {
		return schoolRepository.findAll();
	}

    @PostMapping("/create")
    public String createSchool(@ModelAttribute School s) {
		schoolRepository.save(s);
        return "redirect:dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormSchool(@PathVariable(value = "id") Integer id,
			Model model) throws SchoolNotFoundException {
    	model.addAttribute("school", this.getSchool(id));
		return "school/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateSchool(@ModelAttribute School s) {
		schoolRepository.save(s);
		return "redirect:/school/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteSchool(@ModelAttribute School s) {
		schoolRepository.delete(s);
        return "redirect:dashboard";
    }
}
