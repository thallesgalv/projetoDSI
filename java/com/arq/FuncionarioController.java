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

import com.model.Funcionario;
import com.model.FuncionarioService;

@Controller
@ComponentScan("com.model")
public class FuncionarioController {
	@Autowired
	private ApplicationContext context;
	
	@GetMapping("/funcionario")
	public String formFuncionario(Model model) {
		model.addAttribute("funcionario",new Funcionario());
		return "funcionario";
	}
	
	@PostMapping("/sucessofuncionario")
	public String postFuncionario(@ModelAttribute Funcionario func, Model model) {
		FuncionarioService fs = context.getBean(FuncionarioService.class);
		fs.inserirFuncionario(func);
		return "sucessofuncionario";
	}
	
	@GetMapping("/editarfuncionario/{cdFuncionario}")
    public String atualizaFuncionario(@PathVariable("cdFuncionario") int cdFuncionario, Model model){
		FuncionarioService fdao = context.getBean(FuncionarioService.class);
		Map<String,Object> old = fdao.getFuncionario(cdFuncionario);
		
		Funcionario func = new Funcionario((String)old.get("nmFuncionario"),(String)old.get("nmCargo"),(String)old.get("ftFuncionario"));
		model.addAttribute("old",func);
		model.addAttribute("cdFuncionario",cdFuncionario);
		return "editarfuncionario";
    }
	
	@PostMapping("/editarfuncionario/{cdFuncionario}")
	public String update(@PathVariable("cdFuncionario") int cdFuncionario,@ModelAttribute Funcionario func, Model model) {
		FuncionarioService fdao = context.getBean(FuncionarioService.class);
		fdao.updateFuncionario(cdFuncionario, func);
		return "redirect:/admin";
	}
	
	@PostMapping("/excludefuncionario/{cdFuncionario}")
	public String delete(@PathVariable("cdFuncionario") int id,Model model) {
		FuncionarioService fdao = context.getBean(FuncionarioService.class);
		fdao.deleteFuncionario(id);
		return "redirect:/admin";
	}
}
