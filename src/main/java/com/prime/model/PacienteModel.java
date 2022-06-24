package com.prime.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="cliente", schema="master")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PacienteModel {
	
	@Id
	private Long idcliente;
	private String nome;

}
