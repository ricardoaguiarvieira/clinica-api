package com.prime.dao;

import java.time.LocalDate;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import com.prime.dto.AgendamentoDto;
import com.prime.model.AgendaModel;

@RequestScoped
public class AgendaDao {
	
	@Inject
    @PersistenceUnit() 
	EntityManager em;
	
	public List<AgendamentoDto> agendamentoPorDataEFuncionario(LocalDate data, Integer matricula) {
		
		TypedQuery<AgendaModel> query =  em.createNamedQuery("FIND_BY_DATE", AgendaModel.class);
		
		query.setParameter(1, data);
		query.setParameter(2, matricula);
		
		return AgendamentoDto.mapperAgendamentoDto(query.getResultList());
	}
}
