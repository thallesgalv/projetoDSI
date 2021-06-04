package com.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CursoService {
	@Autowired
	CursoDAO cdao;
	
	public void inserirCurso(Curso c) {
		cdao.inserirCurso(c);
	}
	
	public Map<String, Object> getCurso(int cdCurso) {
		return cdao.getCurso(cdCurso);
	}
	
	public List<Map<String, Object>> getCursos() {
		return cdao.getCursos();
	}
	
	public void updateCurso(int cdCurso, Curso cur) {
      cdao.updateCurso(cdCurso, cur);
	}
	
	public void deleteCurso(int cdCurso) {
		cdao.deleteCurso(cdCurso);
	}
}
