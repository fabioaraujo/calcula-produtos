package br.com.fabioaraujo.calcula.produto.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	@GetMapping("/")
	public ModelAndView welcome() {
		return new ModelAndView("index.html");
	}

}