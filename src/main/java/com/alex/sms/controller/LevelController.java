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

import com.alex.sms.exception.LevelNotFoundException;
import com.alex.sms.model.Level;
import com.alex.sms.repository.LevelRepository;

@Controller
@RequestMapping(path="/level")
public class LevelController {
	@Autowired
	private LevelRepository levelRepository;
	
	@GetMapping("/dashboard")
    public String levelIndex(Model model) {
        model.addAttribute("level", new Level());
        model.addAttribute("levels", levelRepository.findAll());
        return "level/dashboard";
    }
	
	@GetMapping(path="/{id}")
	public @ResponseBody Level getLevel (@PathVariable(value = "id") Integer id)
			throws LevelNotFoundException {
		Level s = levelRepository.findById(id)
				.orElseThrow(() -> new LevelNotFoundException());
		return s;
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Level> getAllLevels() {
		return levelRepository.findAll();
	}

    @PostMapping("/create")
    public String createLevel(@ModelAttribute Level s) {
		levelRepository.save(s);
		// TODO Remove after test //
		try {
			Level level = new Level();
			level = this.getLevel(s.getId());
			System.out.println(level.getId());
		} catch (LevelNotFoundException e) {
			e.printStackTrace();
		}
		////
        return "redirect:dashboard";
    }
    
    @GetMapping(path="/{id}/edit")
	public String viewUpdateFormLevel(@PathVariable(value = "id") Integer id,
			Model model) throws LevelNotFoundException {
    	model.addAttribute("level", this.getLevel(id));
		return "level/edit";
	}
	
	@PutMapping("/{id}/update")
    public String updateLevel(@ModelAttribute Level s) {
		levelRepository.save(s);
		return "redirect:/level/dashboard";
    }
	
	@DeleteMapping("/delete")
    public String deleteLevel(@ModelAttribute Level s) {
		levelRepository.delete(s);
        return "redirect:dashboard";
    }
}
