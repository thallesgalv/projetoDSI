package com.model;

public class Curso {
  private int cdCurso;
  private int cdFuncionario;
  private String nmCurso, dsCurso;

  public Curso() {}
	
	public Curso(int cdFuncionario, String nmCurso, String dsCurso) {
		this.cdFuncionario=cdFuncionario;
		this.nmCurso=nmCurso;
		this.dsCurso=dsCurso;
	}
	
  public Curso(int cdCurso, int cdFuncionario, String nmCurso, String dsCurso) {
    this.cdCurso = cdCurso;
    this.cdFuncionario = cdFuncionario;
    this.nmCurso = nmCurso;
    this.dsCurso = dsCurso;
  }
  
  public int getCdCurso() {
    return cdCurso;
  }
  public void setCdCurso(int cdCurso) {
    this.cdCurso = cdCurso;
  }
  public int getCdFuncionario() {
    return cdFuncionario;
  }
  public void setCdFuncionario(int cdFuncionario) {
    this.cdFuncionario = cdFuncionario;
  }
  public String getNmCurso() {
		return nmCurso;
	}
	public void setNmCurso(String nmCurso) {
		this.nmCurso = nmCurso;
	}
  public String getDsCurso() {
		return dsCurso;
	}
	public void setDsCurso(String dsCurso) {
		this.dsCurso = dsCurso;
	}
}
