package com.model;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class FuncionarioDAO {
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirFuncionario(Funcionario funcionario) {
		String sql = "INSERT INTO funcionario (nmFuncionario,nmCargo,ftFuncionario) VALUES (?,?,?)";
		Object obj [] = new Object[3];
		obj[0] = funcionario.getNmFuncionario();
		obj[1] = funcionario.getNmCargo();
		obj[2] = funcionario.getFtFuncionario();
		
		jdbc.update(sql,obj);
	}
	
	public Map<String, Object> getFuncionario(int cdFuncionario) {
		String sql = "SELECT * FROM funcionario WHERE cdFuncionario = ?";
		return jdbc.queryForMap(sql,new Object[] {cdFuncionario});
	}
	
	public List<Map<String, Object>> getFuncionarios() {
		String sql = "SELECT * FROM funcionario";
		List<Map<String, Object>> funcionarios = (List<Map<String, Object>>) jdbc.queryForList(sql);
		return funcionarios;
	}
	
	public void updateFuncionario(int cdFuncionario,Funcionario func) {
		String sql = "UPDATE funcionario SET nmFuncionario = ?, getNmCargo = ?, getFtFuncionario = ? WHERE cdFuncionario = ?";
		jdbc.update(sql, new Object[]{
			func.getNmFuncionario(),func.getNmCargo(), func.getFtFuncionario(), cdFuncionario
		});
	}
	 
	public void deleteFuncionario(int cdFuncionario) {		 
		String sqlP = "DELETE FROM funcionario WHERE cdFuncionario = ?" ;
		jdbc.update(sqlP, new Object[] {cdFuncionario});
	}
}
