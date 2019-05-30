package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.SchoolYearNotFoundException;
import com.alex.sms.model.Quarter;
import com.alex.sms.model.SchoolYear;
import com.alex.sms.repository.QuarterRepository;
import com.alex.sms.repository.SchoolYearRepository;

@Controller
@RequestMapping(path="/quarter")
public class QuarterController {
	@Autowired
	private QuarterRepository quarterRepository;
	
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	@GetMapping(path="/dashboard")
	public String quarterIndex(Model model) {
		model.addAttribute("quarter", new Quarter());
		model.addAttribute("quarters", quarterRepository.findAll());
		return "quarter/dashboard";
	}
	
	@PostMapping(path="/create")
	public String createQuarter (@ModelAttribute Quarter q) {
		try {
			schoolYearRepository.findById(q.getSchoolYear().getId())
					.orElseThrow(() -> new SchoolYearNotFoundException());
		} catch (SchoolYearNotFoundException e) {
			SchoolYear schoolYear = new SchoolYear(q.getSchoolYear().getId());
			schoolYearRepository.save(schoolYear);
		}
		quarterRepository.save(q);
		return "redirect:dashboard";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Quarter> getAllQuarters() {
		return quarterRepository.findAll();
	}
	
	@DeleteMapping("/delete")
    public String deleteQuarter(@ModelAttribute Quarter q) {
		quarterRepository.delete(q);
        return "redirect:dashboard";
    }
}
