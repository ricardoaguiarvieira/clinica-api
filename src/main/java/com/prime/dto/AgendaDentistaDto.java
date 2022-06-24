package com.prime.dto;

import java.util.List;

import com.prime.model.FuncionarioModel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AgendaDentistaDto {
	
	private Integer matriculaDentista;
	private String nomeDentista;
	private List<AgendamentoDto> agenda;
	
	public AgendaDentistaDto(FuncionarioModel f) {
		this.matriculaDentista = f.getMatricula();
		this.nomeDentista = f.getNome();
	}
}
