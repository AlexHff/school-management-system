package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.SchoolYearNotFoundException;
import com.alex.sms.model.SchoolYear;
import com.alex.sms.repository.SchoolYearRepository;

@Controller
@RequestMapping(path = "school_year")
public class SchoolYearController {
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	
	@GetMapping(path="/create")
	public @ResponseBody String createSchoolYear (@RequestParam Integer id) {
	SchoolYear s = new SchoolYear(id);
	schoolYearRepository.save(s);
	return "Saved";
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
}
