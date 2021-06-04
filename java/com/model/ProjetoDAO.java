package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProjetoDAO {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirProjeto(Projeto projeto) {
		String sql = "INSERT INTO projeto (cdFuncionario,nmProjeto,dsProjeto) VALUES (?,?,?)";
		Object obj [] = new Object[3];
		obj[0] = projeto.getCdFuncionario();
		obj[1] = projeto.getNmProjeto();
		obj[2] = projeto.getDsProjeto();
		
		jdbc.update(sql,obj);
	}
	
	public Map<String, Object> getProjeto(int cdProjeto) {
    String sql = "SELECT * FROM projeto WHERE cdProjeto = ?";
    return jdbc.queryForMap(sql,new Object[] {cdProjeto});
  }
	
	public List<Map<String, Object>> getProjetos() {
    String sql = "SELECT * FROM projeto";
    List<Map<String, Object>> projetos = (List<Map<String, Object>>) jdbc.queryForList(sql);
    return projetos;
  }
	
	public void updateProjeto(int cdProjeto,Projeto proj) {
		String sql = "UPDATE projeto SET cdFuncionario = ?, nmProjeto = ?, dsProjeto = ? WHERE cdProjeto = ?";
    jdbc.update(sql, new Object[]{
      proj.getCdFuncionario(),proj.getNmProjeto(), proj.getDsProjeto(), cdProjeto
    });
	}
	 
	public void deleteProjeto(int cdProjeto) {		 
		String sqlP = "DELETE FROM projeto WHERE cdProjeto = ?" ;
		jdbc.update(sqlP, new Object[] {cdProjeto});
	}
}
