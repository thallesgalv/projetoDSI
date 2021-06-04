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

import com.model.Curso;
import com.model.CursoService;

@Controller
@ComponentScan("com.model")
public class CursoController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/curso")
	public String formCurso(Model model) {
		model.addAttribute("curso",new Curso());
		return "curso";
	}
	
	@PostMapping("/sucessocurso")
	public String postCurso(@ModelAttribute Curso cur, Model model) {
		CursoService ps = context.getBean(CursoService.class);
		ps.inserirCurso(cur);
		return "sucessocurso";
	}
	
	@GetMapping("/editarcurso/{cdCurso}")
    public String atualizaCurso(@PathVariable("cdCurso") int cdCurso, Model model){
		CursoService cdao = context.getBean(CursoService.class);
		Map<String,Object> old = cdao.getCurso(cdCurso);
		
		Curso cur = new Curso((int)old.get("cdFuncionario"),(String)old.get("nmCurso"),(String)old.get("dsCurso"));
		model.addAttribute("old",cur);
		model.addAttribute("cdCurso",cdCurso);
		return "editarcurso";
	}
	
	@PostMapping("/editarcurso/{cdCurso}")
	public String update(@PathVariable("cdCurso") int cdCurso,@ModelAttribute Curso cur, Model model) {
		CursoService cdao = context.getBean(CursoService.class);
		cdao.updateCurso(cdCurso, cur);
		return "redirect:/admin";
	}
	
	@PostMapping("/excludecurso/{cdCurso}")
	public String delete(@PathVariable("cdCurso") int id,Model model) {
		CursoService cdao = context.getBean(CursoService.class);
		cdao.deleteCurso(id);
		return "redirect:/admin";
	}
}
