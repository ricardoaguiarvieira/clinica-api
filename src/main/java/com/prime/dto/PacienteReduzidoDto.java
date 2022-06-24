package com.prime.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.prime.model.PacienteModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PacienteReduzidoDto {

	private Long idPaciente;
	private String nome;
	
	public PacienteReduzidoDto(PacienteModel paciente) {
		this.idPaciente = paciente.getIdcliente();
		this.nome = paciente.getNome();
	}
	
	public static List<PacienteReduzidoDto> mapperAgendamentoDto(List<PacienteModel> agendamentos){
		return agendamentos.stream().map(a -> new PacienteReduzidoDto(a))
				.collect(Collectors.toList());
	}

}
