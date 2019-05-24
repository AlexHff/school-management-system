package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.School;
import model.SchoolRepository;

@Controller
@RequestMapping(path="/school")
public class SchoolController {
	@Autowired
	private SchoolRepository schoolRepository;
	
	@GetMapping(path="/add")
	public @ResponseBody String addNewSchool (@RequestParam String name) {
		School s = new School();
		s.setName(name);
		schoolRepository.save(s);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<School> getAllSchools() {
		return schoolRepository.findAll();
	}
}
