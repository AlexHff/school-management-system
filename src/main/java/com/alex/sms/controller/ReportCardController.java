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

import com.alex.sms.exception.ReportCardNotFoundException;
import com.alex.sms.model.ReportCard;
import com.alex.sms.repository.QuarterRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.ReportCardRepository;

@Controller
@RequestMapping(path="/report_card")
public class ReportCardController {
	@Autowired
	private ReportCardRepository reportCardRepository;
	
	@Autowired
	private RegistrationRepository registrationRepository;
	
	@Autowired
	private QuarterRepository quarterRepository;
	
	@GetMapping("/dashboard")
    public String reportCardIndex(Model model) {
        model.addAttribute("reportCard", new ReportCard());
        model.addAttribute("reportCards", reportCardRepository.findAll());
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("quarters", quarterRepository.findAll());
        return "report_card/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody ReportCard getReportCard (@PathVariable(value = "id") Integer id)
			throws ReportCardNotFoundException {
		ReportCard s = reportCardRepository.findById(id)
				.orElseThrow(() -> new ReportCardNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<ReportCard> getAllReportCards() {
		return reportCardRepository.findAll();
	}

    @PostMapping("/create")
    public String createReportCard(@ModelAttribute ReportCard s) {
		reportCardRepository.save(s);
        return "redirect:/report_card/dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormReportCard(@PathVariable(value = "id") Integer id,
			Model model) throws ReportCardNotFoundException {
    	model.addAttribute("reportCard", this.getReportCard(id));
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("quarters", quarterRepository.findAll());
		return "report_card/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateReportCard(@ModelAttribute ReportCard s) {
		reportCardRepository.save(s);
		return "redirect:/report_card/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteReportCard(@ModelAttribute ReportCard s) {
		reportCardRepository.delete(s);
        return "redirect:/report_card/dashboard";
    }
}
