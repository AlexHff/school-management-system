package com.alex.sms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alex.sms.exception.SchoolNotFoundException;
import com.alex.sms.model.School;
import com.alex.sms.repository.SchoolRepository;

@Controller
@RequestMapping(path="/school")
public class SchoolController {
	@Autowired
	private SchoolRepository schoolRepository;
	
	@GetMapping("")
    public String school() {
        return "school";
    }
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<School> getAllSchools() {
		return schoolRepository.findAll();
	}
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewSchool (@RequestParam String name) {
		School s = new School();
		s.setName(name);
		schoolRepository.save(s);
		return "Saved";
	}
	
	@GetMapping(path="/{id}")
	public @ResponseBody School getSchool (@PathVariable(value = "id") Integer id)
			throws SchoolNotFoundException {
		School s = schoolRepository.findById(id)
				.orElseThrow(() -> new SchoolNotFoundException(id));
		return s;
	}
	
	@PutMapping("/{id}")
    public String updateSchool(@PathVariable(value = "id") Integer id,
    		@RequestParam String name) throws SchoolNotFoundException {
		School s = schoolRepository.findById(id)
				.orElseThrow(() -> new SchoolNotFoundException(id));
		s.setName(name);
		schoolRepository.save(s);
		return "Updated";
    }
	
	@DeleteMapping(path="/{id}")
	public @ResponseBody String deleteSchool (@PathVariable(value = "id") Integer id)
			throws SchoolNotFoundException {
		School s = schoolRepository.findById(id)
				.orElseThrow(() -> new SchoolNotFoundException(id));
		schoolRepository.delete(s);
		return "Deleted";
	}
}
