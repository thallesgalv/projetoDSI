package com.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JogadorService {
	
	@Autowired
	JogadorDAO cdao;
	
	public void inserirJogador(Jogador j) {
		cdao.inserirJogador(j);
	}
	
}
