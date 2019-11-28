package com.cadtimes.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.cadtimes.model.Time;
import com.cadtimes.repository.TimeRepository;

@Controller
public class TimeController {
	@Autowired
	TimeRepository times;
	
	@GetMapping("/")
	 public ModelAndView Listar() {
	  	   ModelAndView modelAndView = new ModelAndView("index");
	  	   modelAndView.addObject("TimeRepository", times.findAll());
	  	   modelAndView.addObject(new Time());
	  	   return modelAndView;
	     }
	
	@GetMapping("/time")
    public String salvar(@Valid Time time,  BindingResult result,
    		RedirectAttributes attributes) {
    	if(result.hasErrors()) {
    		return "redirect:/";
    	}
    	
   	  times.save(time);	
   	  attributes.addFlashAttribute("mensagem", "Time cadastrado com êxito!");	
   	 return "redirect:/";
    }
	
	@GetMapping("/et")
    public String sms(@Valid Time time, BindingResult result,
   		 RedirectAttributes attributes) {
   	 if(result.hasErrors()) {
     		return "redirect:/";
     	}
        attributes.addFlashAttribute("message", "Time atualizado com sucesso!");
   	 times.save(time);
   	 return "redirect:/";
    }
         
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
   	times.deleteById(id);
   	return "redirect:/";
    }
    
    @GetMapping("/editarTimes/{id}")
    public String editarTimes(@PathVariable("id") Long id,  Model model) {
    	model.addAttribute("dados", times.findById(id));
    	return "editarTimes";
     }
}
