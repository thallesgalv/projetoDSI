package com.aula;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class MainController {
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/jogadores")
	public String jogadores() {
		return "jogadores";
	}
	
	@GetMapping("/times")
	public String times() {
		return "times";
	}
	
	@GetMapping("/estadios")
	public String estadios() {
		return "estadios";
	}
	
	@GetMapping("/classificacao")
	public String classificacao() {
		return "classificacao";
	}
	
	@GetMapping("/monteseudreamteam")
	public String monteseudreamteam() {
		return "monteseudreamteam";
	}
}
