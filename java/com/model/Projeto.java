package com.model;

public class Projeto {
  private int cdProjeto;
  private int cdFuncionario;
  private String nmProjeto, dsProjeto;

  public Projeto() {}
	
	public Projeto(int cdFuncionario, String nmProjeto, String dsProjeto) {
		this.cdFuncionario=cdFuncionario;
		this.nmProjeto=nmProjeto;
		this.dsProjeto=dsProjeto;
	}
	
  public Projeto(int cdProjeto, int cdFuncionario, String nmProjeto, String dsProjeto) {
    this.cdProjeto = cdProjeto;
    this.cdFuncionario = cdFuncionario;
    this.nmProjeto = nmProjeto;
    this.dsProjeto = dsProjeto;
  }
  
  
  public int getCdProjeto() {
    return cdProjeto;
  }
  public void setCdProjeto(int cdProjeto) {
    this.cdProjeto = cdProjeto;
  }
  public int getCdFuncionario() {
    return cdFuncionario;
  }
  public void setCdFuncionario(int cdFuncionario) {
    this.cdFuncionario = cdFuncionario;
  }
  public String getNmProjeto() {
		return nmProjeto;
	}
	public void setNmProjeto(String nmProjeto) {
		this.nmProjeto = nmProjeto;
	}
  public String getDsProjeto() {
		return dsProjeto;
	}
	public void setDsProjeto(String dsProjeto) {
		this.dsProjeto = dsProjeto;
	}
}
