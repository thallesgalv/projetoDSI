package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjetoService {
	@Autowired
	ProjetoDAO pdao;
	
	public void inserirProjeto(Projeto p) {
		pdao.inserirProjeto(p);
	}
	
	public Map<String, Object> getProjeto(int cdProjeto) {
		return pdao.getProjeto(cdProjeto);
	}
	
	public List<Map<String, Object>> getProjetos() {
		return pdao.getProjetos();
	}
	
	public void updateProjeto(int cdProjeto, Projeto proj) {
		  pdao.updateProjeto(cdProjeto, proj);
	}
	
	public void deleteProjeto(int cdProjeto) {
		pdao.deleteProjeto(cdProjeto);
	}
}
