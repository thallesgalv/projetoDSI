package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FuncionarioService {
	@Autowired
	FuncionarioDAO fdao;
	
	public void inserirFuncionario(Funcionario f) {
		fdao.inserirFuncionario(f);
	}
	
	public Map<String, Object> getFuncionario(int cdFuncionario) {
		return fdao.getFuncionario(cdFuncionario);
	}
	
	public List<Map<String, Object>> getFuncionarios() {
		return fdao.getFuncionarios();
	}
	
	public void updateFuncionario(int cdFuncionario, Funcionario func) {
		  fdao.updateFuncionario(cdFuncionario, func);
	}
	
	public void deleteFuncionario(int cdFuncionario) {
		fdao.deleteFuncionario(cdFuncionario);
	}
}
