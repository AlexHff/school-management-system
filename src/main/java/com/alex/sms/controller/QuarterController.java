package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
	
	@GetMapping(path="/create")
	public @ResponseBody String createQuarter (@RequestParam Integer number,
			@RequestParam Integer schoolYearId)
			throws SchoolYearNotFoundException {
		SchoolYear schoolYear = new SchoolYear();
		schoolYear.setId(schoolYearId);
		schoolYearRepository.save(schoolYear);
		
		Quarter q = new Quarter();
		q.setNumber(number);
		q.setSchoolYear(schoolYear);
		quarterRepository.save(q);
		
		return "Saved";
	}

	@GetMapping(path="/all")
	public @ResponseBody Iterable<Quarter> getAllUsers() {
		return quarterRepository.findAll();
	}
}
