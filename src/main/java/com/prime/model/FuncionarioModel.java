package com.prime.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="funcionario", schema="master")
public class FuncionarioModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4333102323318674296L;
	
	@Id
	@Column(name = "matricula")
	private Integer matricula;
	
	@Column(name = "nome")
	private String nome;
	 
//	@Column(name = "senha")
//	private String senha;

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

//	public String getSenha() {
//		return senha;
//	}
//
//	public void setSenha(String senha) {
//		this.senha = senha;
//	}
	
}
