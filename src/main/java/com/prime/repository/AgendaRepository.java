package com.prime.repository;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import com.prime.dto.AgendamentoDto;
import com.prime.model.AgendaModel;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class AgendaRepository implements PanacheRepository<AgendaModel>{

	public List<AgendamentoDto> findPordataEDentista(LocalDate data, Integer matricula){
		return AgendamentoDto.mapperAgendamentoDto( find("data = ?1 and dentista = ?2", data, matricula).list());
	}
}
