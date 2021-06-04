package com.arq;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.model.Projeto;
import com.model.ProjetoService;

@Controller
@ComponentScan("com.model")
public class ProjetoController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/projeto")
	public String formProjeto(Model model) {
		model.addAttribute("projeto",new Projeto());
		return "projeto";
	}
	
	@PostMapping("/sucessoprojeto")
	public String postProjeto(@ModelAttribute Projeto proj, Model model) {
		ProjetoService ps = context.getBean(ProjetoService.class);
		ps.inserirProjeto(proj);
		return "sucessoprojeto";
	}
	
	@GetMapping("/editarprojeto/{cdProjeto}")
    public String atualizaProjeto(@PathVariable("cdProjeto") int cdProjeto, Model model){
		ProjetoService pdao = context.getBean(ProjetoService.class);
		Map<String,Object> old = pdao.getProjeto(cdProjeto);
		
		Projeto proj = new Projeto((int)old.get("cdFuncionario"),(String)old.get("nmProjeto"),(String)old.get("dsProjeto"));
		model.addAttribute("old",proj);
		model.addAttribute("cdProjeto",cdProjeto);
		return "editarprojeto";
	}
	
	@PostMapping("/editarprojeto/{cdProjeto}")
	public String update(@PathVariable("cdProjeto") int cdProjeto,@ModelAttribute Projeto proj, Model model) {
		ProjetoService pdao = context.getBean(ProjetoService.class);
		pdao.updateProjeto(cdProjeto, proj);
		return "redirect:/admin";
	}
	
	@PostMapping("/excludeprojeto/{cdProjeto}")
	public String delete(@PathVariable("cdProjeto") int id,Model model) {
		ProjetoService pdao = context.getBean(ProjetoService.class);
		pdao.deleteProjeto(id);
		return "redirect:/admin";
	}
}
