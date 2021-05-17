package com.model;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class JogadorDAO {
	
	@Autowired
	DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}
	
	public void inserirJogador(Jogador jogador) {
		String sql = "INSERT INTO jogador(nome,posicao,time,mediadepontos)" +
	                 " VALUES (?,?,?,?)";
		Object[] obj = new Object[4];
		obj[0] = jogador.getNome();
		obj[1] = jogador.getPosicao();
		obj[2] = jogador.getTime();
		obj[3] = jogador.getMediadepontos();
		jdbc.update(sql, obj);
	}
	
	
}
