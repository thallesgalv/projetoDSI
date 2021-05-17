package com.aula;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Jogador;
import com.model.JogadorService;

@Controller
@ComponentScan("com.model")
public class JogadorController {
	
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String principal() {
		return "principal";
	}
	
	@GetMapping("/jogador")
	public String formJogador(Model model) {
		model.addAttribute("jogador",new Jogador());
		return "formjogador";
	}
	
	@PostMapping("/jogador")
	public String postJogador(@ModelAttribute Jogador jog,
			                  Model model) {
		JogadorService cs = context.getBean(JogadorService.class);
		cs.inserirJogador(jog);
		return "sucesso";
	}
	
}
