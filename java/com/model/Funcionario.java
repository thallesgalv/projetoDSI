package com.model;

public class Funcionario {
	
	private int cdFuncionario;
	private String nmFuncionario, nmCargo, ftFuncionario;
	
	public Funcionario() {}
	
	public Funcionario(String nmFuncionario, String nmCargo, String ftFuncionario) {
		this.nmFuncionario=nmFuncionario;
		this.nmCargo=nmCargo;
		this.ftFuncionario=ftFuncionario;
	}
	
	public Funcionario(int cdFuncionario, String nmFuncionario, String nmCargo, String ftFuncionario) {
		this.cdFuncionario=cdFuncionario;
		this.nmFuncionario=nmFuncionario;
		this.nmCargo=nmCargo;
		this.ftFuncionario=ftFuncionario;
	}
	
	public int getCdFuncionario() {
		return cdFuncionario;
	}
	public void setCdFuncionario(int cdFuncionario) {
		this.cdFuncionario = cdFuncionario;
	}
	public String getNmFuncionario() {
		return nmFuncionario;
	}
	public void setNmFuncionario(String nmFuncionario) {
		this.nmFuncionario = nmFuncionario;
	}
	public String getNmCargo() {
		return nmCargo;
	}
	public void setNmCargo(String nmCargo) {
		this.nmCargo = nmCargo;
	}
	public String getFtFuncionario() {
		return ftFuncionario;
	}
	public void setFtFuncionario(String ftFuncionario) {
		this.ftFuncionario = ftFuncionario;
	}
}