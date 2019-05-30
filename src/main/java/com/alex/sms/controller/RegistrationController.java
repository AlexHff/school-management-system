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

import com.alex.sms.exception.RegistrationNotFoundException;
import com.alex.sms.model.Registration;
import com.alex.sms.repository.ClassRepository;
import com.alex.sms.repository.RegistrationRepository;
import com.alex.sms.repository.StudentRepository;

@Controller
@RequestMapping(path="/registration")
public class RegistrationController {
	@Autowired
	private RegistrationRepository registrationRepository;

	@Autowired
	private ClassRepository classRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping("/dashboard")
    public String registrationIndex(Model model) {
        model.addAttribute("registration", new Registration());
        model.addAttribute("registrations", registrationRepository.findAll());
        model.addAttribute("students", studentRepository.findAll());
        model.addAttribute("classes", classRepository.findAll());
        return "registration/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody Registration getRegistration (@PathVariable(value = "id") Integer id)
			throws RegistrationNotFoundException {
		Registration s = registrationRepository.findById(id)
				.orElseThrow(() -> new RegistrationNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Registration> getAllRegistrations() {
		return registrationRepository.findAll();
	}

    @PostMapping("/create")
    public String createRegistration(@ModelAttribute Registration s) {
		registrationRepository.save(s);
    	System.out.println(s.getC() + " " + s.getStudent());
        return "redirect:dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormRegistration(@PathVariable(value = "id") Integer id,
			Model model) throws RegistrationNotFoundException {
    	model.addAttribute("registration", this.getRegistration(id));
        model.addAttribute("students", studentRepository.findAll());
		return "registration/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateRegistration(@ModelAttribute Registration s) {
		registrationRepository.save(s);
		return "redirect:/registration/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteRegistration(@ModelAttribute Registration s) {
		registrationRepository.delete(s);
        return "redirect:dashboard";
    }
}
