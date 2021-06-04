package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CursoDAO {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirCurso(Curso curso) {
		String sql = "INSERT INTO curso (cdFuncionario,nmCurso,dsCurso) VALUES (?,?,?)";
		Object obj [] = new Object[3];
		obj[0] = curso.getCdFuncionario();
		obj[1] = curso.getNmCurso();
		obj[2] = curso.getDsCurso();
		
		jdbc.update(sql,obj);
	}
	
	public Map<String, Object> getCurso(int cdCurso) {
		String sql = "SELECT * FROM curso WHERE cdCurso = ?";
		return jdbc.queryForMap(sql,new Object[] {cdCurso});
	}
	
	public List<Map<String, Object>> getCursos() {
		String sql = "SELECT * FROM curso";
		List<Map<String, Object>> cursos = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return cursos;
	}
	
	public void updateCurso(int cdCurso,Curso cur) {
		String sql = "UPDATE curso SET getCdFuncionario = ?, getNmCurso = ?, getDsCurso = ? WHERE cdCurso = ?";
		jdbc.update(sql, new Object[]{
			cur.getCdFuncionario(),cur.getNmCurso(), cur.getDsCurso(), cdCurso
		});
	}
	 
	public void deleteCurso(int cdCurso) {		 
		String sqlP = "DELETE FROM curso WHERE cdCurso = ?" ;
		jdbc.update(sqlP, new Object[] {cdCurso});
	}
}
