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

import com.alex.sms.exception.GradeNotFoundException;
import com.alex.sms.model.Grade;
import com.alex.sms.repository.ReportCardDetailRepository;
import com.alex.sms.repository.GradeRepository;

@Controller
@RequestMapping(path="/grade")
public class GradeController {
	@Autowired
	private GradeRepository gradeRepository;
	
	@Autowired
	private ReportCardDetailRepository reportCardDetailRepository;
	
	@GetMapping("/dashboard")
    public String gradeIndex(Model model) {
        model.addAttribute("grade", new Grade());
        model.addAttribute("grades", gradeRepository.findAll());
        model.addAttribute("reportCardDetails", reportCardDetailRepository.findAll());
        return "grade/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody Grade getGrade (@PathVariable(value = "id") Integer id)
			throws GradeNotFoundException {
		Grade s = gradeRepository.findById(id)
				.orElseThrow(() -> new GradeNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Grade> getAllGrades() {
		return gradeRepository.findAll();
	}

    @PostMapping("/create")
    public String createGrade(@ModelAttribute Grade s) {
		gradeRepository.save(s);
        return "redirect:/grade/dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormGrade(@PathVariable(value = "id") Integer id,
			Model model) throws GradeNotFoundException {
    	model.addAttribute("grade", this.getGrade(id));
        model.addAttribute("reportCardDetails", reportCardDetailRepository.findAll());
		return "grade/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateGrade(@ModelAttribute Grade s) {
		gradeRepository.save(s);
		return "redirect:/grade/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteGrade(@ModelAttribute Grade s) {
		gradeRepository.delete(s);
        return "redirect:/grade/dashboard";
    }
}
