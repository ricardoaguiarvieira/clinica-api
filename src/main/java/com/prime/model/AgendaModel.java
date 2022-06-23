package com.prime.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="agenda", schema="master")
@NamedNativeQueries({
	@NamedNativeQuery(
			name="FIND_BY_DATE", 
			query = "  SELECT \n"
					+ " A.idagenda, \n"
					+ " A.idcliente, \n"
					+ " A.nome, \n"
					+ " A.`data`, \n"
					+ " A.descricao, \n"
					+ " A.hora, \n"
					+ " A.status, \n"
					+ " A.sala, \n"
					+ " A.obs \n"
					+ "FROM master.agenda as A\n"
					+ "WHERE A.data = ? AND A.dentista = ?;", 
			resultClass = AgendaModel.class)
})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AgendaModel implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idagenda;
	private Integer idcliente;
	private String nome;
	private LocalDate data;
	private String descricao;
	private String hora;
	private String status;
	private Integer dentista;
	private String sala;
	private String obs;
	
}
