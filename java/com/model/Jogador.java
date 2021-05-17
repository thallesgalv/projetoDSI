package com.model;

public class Jogador {
	
	private int id;
	private String nome, posicao, time;
	private int mediadepontos;
	
	public Jogador() {
		
	}
	
	public Jogador(int id, String nome, String posicao, String time, int mediadepontos) {
		this.id = id;
		this.nome = nome;
		this.posicao = posicao;
		this.time = time;
		this.mediadepontos = mediadepontos;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	public int getMediadepontos() {
		return mediadepontos;
	}

	public void setmMdiadepontos(int mediadepontos) {
		this.mediadepontos = mediadepontos;
	}
	
}
