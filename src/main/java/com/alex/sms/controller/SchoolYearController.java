package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.SchoolYearNotFoundException;
import com.alex.sms.model.SchoolYear;
import com.alex.sms.repository.SchoolYearRepository;

@Controller
@RequestMapping(path = "school_year")
public class SchoolYearController {
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	@GetMapping("/dashboard")
    public String schoolYearIndex(Model model) {
        model.addAttribute("schoolYear", new SchoolYear());
        model.addAttribute("schoolYears", schoolYearRepository.findAll());
        return "school_year/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody SchoolYear getSchoolYear (@PathVariable(value = "id") Integer id)
			throws SchoolYearNotFoundException {
		SchoolYear s = schoolYearRepository.findById(id)
				.orElseThrow(() -> new SchoolYearNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<SchoolYear> getAllSchoolYears() {
		return schoolYearRepository.findAll();
	}

    @PostMapping("/create")
    public String createSchoolYear(@ModelAttribute SchoolYear s) {
		schoolYearRepository.save(s);
        return "redirect:dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteSchoolYear(@ModelAttribute SchoolYear s) {
		schoolYearRepository.delete(s);
        return "redirect:dashboard";
    }
}
