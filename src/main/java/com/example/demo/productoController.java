package com.example.demo;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class productoController {
	
	@GetMapping("/formulario")
	public String formulario(producto prod) {
		
		
		return "formulario";
	}
	
	@PostMapping("/producto")
	public ModelAndView postdata(@Valid @ModelAttribute producto prod,BindingResult result) {
		ModelAndView mav = new ModelAndView();
		
		
		if(result.hasErrors()) {
			mav.setViewName("formulario");
		}else {
			String msg = "El producto " + prod.getNombre() + "se ha ingresado con exito";
			mav.setViewName("ok");
			mav.addObject("msg",msg );
		}
		
		return mav;
	}
	

}
