package com.prime.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.prime.model.AgendaModel;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AgendamentoDto {
	
	private Long id;
	private Integer idCliente;
	private String nomeCliente;
	private LocalDate data;
	private String descricao;
	private String hora;
	private String status;
	private Integer matricula;
	private String observacao;
	
	public AgendamentoDto(AgendaModel agenda) {
		this.id = agenda.getIdagenda();
		this.idCliente = agenda.getIdcliente();
		this.nomeCliente = agenda.getNome();
		this.data = agenda.getData();
		this.descricao = agenda.getDescricao();
		this.hora = agenda.getHora();
		this.status = agenda.getStatus();
		this.matricula = agenda.getDentista();
		this.observacao = agenda.getObs();
	}
	
	public static List<AgendamentoDto> mapperAgendamentoDto(List<AgendaModel> agendamentos){
		return agendamentos.stream().map(a -> new AgendamentoDto(a))
				.collect(Collectors.toList());
	}
	
	public static AgendaModel mapperAgendaModel(AgendamentoDto agendamento) {
		return new AgendaModel(agendamento.getId(), 
				agendamento.getIdCliente(), 
				agendamento.getNomeCliente(), 
				agendamento.getData(), 
				agendamento.getDescricao(), 
				agendamento.getHora(), 
				agendamento.getStatus(), 
				agendamento.getMatricula(),
				"",
				agendamento.getObservacao());
	}
}
