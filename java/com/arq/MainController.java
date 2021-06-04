package com.arq;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.model.FuncionarioService;
import com.model.ProjetoService;
import com.model.CursoService;


@Controller
@ComponentScan("com.model")
public class MainController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("/equipe")
	public String equipe(Model model) {
		FuncionarioService fdao = context.getBean(FuncionarioService.class);
		List<Map<String, Object>> funcionarios = fdao.getFuncionarios();
		model.addAttribute("funcionario", funcionarios);
		return "equipe";
	}
	
	@GetMapping("/cursos")
	public String cursos(Model model) {
		CursoService cdao = context.getBean(CursoService.class);
		List<Map<String, Object>> cursos = cdao.getCursos();
		model.addAttribute("curso", cursos);
		return "cursos";
	}
	
	@GetMapping("/projetos")
	public String projetos(Model model) {
		ProjetoService pdao = context.getBean(ProjetoService.class);
		List<Map<String,Object>> projetos = pdao.getProjetos();
		model.addAttribute("projeto",projetos);
		return "projetos";
	}
	

	@GetMapping("/admin")
	public String admin(Model model) {
		FuncionarioService fdao = context.getBean(FuncionarioService.class);
		List<Map<String,Object>> funcionarios = fdao.getFuncionarios();
		model.addAttribute("funcionario", funcionarios);

		CursoService cdao = context.getBean(CursoService.class);
		List<Map<String,Object>> cursos = cdao.getCursos();
		model.addAttribute("curso", cursos);

		ProjetoService pdao = context.getBean(ProjetoService.class);
		List<Map<String,Object>> projetos = pdao.getProjetos();
		model.addAttribute("projeto", projetos);

		return "admin";
	}
}
