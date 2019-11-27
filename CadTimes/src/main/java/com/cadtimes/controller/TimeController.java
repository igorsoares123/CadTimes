package com.cadtimes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.cadtimes.model.Time;
import com.cadtimes.repository.TimeRepository;

@Controller
public class TimeController {
	@Autowired
	TimeRepository times;
	
	@GetMapping("/")
        public String cadastro(){
        	return "index";
        }
	
	
	@GetMapping("/salvar")
	public String Salvar(Time time) {
		times.save(time);
		return "redirect:/listar";
	}
}
