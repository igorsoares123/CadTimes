package com.projeto.campeonato.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.projeto.campeonato.model.Time;
import com.projeto.campeonato.repository.TimeRepository;

@Controller
public class CampeonatoController {
	
	@Autowired
	private TimeRepository times;

	@GetMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("Cadastro");
		modelAndView.addObject("Time", times.findAll());
		modelAndView.addObject(new Time());
		return modelAndView;
		
	}
	
	@PostMapping("/times")
	public String salvar(Time time) {
		times.save(time);
		return "redirect:/";
	}
	
	
}
