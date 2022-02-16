package br.com.bb.big.uteis;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import br.com.bb.big.dto.ProjetoDto;
import br.com.bb.big.models.AbendJobModel;

public class FactoryAbendJob {

	public static List<ProjetoDto> getProjetos(){
		List<ProjetoDto> projetos = new ArrayList<>();
		projetos.add(getProjeto());
		return projetos;
	}
	public static ProjetoDto getProjeto(){
		ProjetoDto projeto = new ProjetoDto();
		projeto.setSiglaProjeto("test1");
		return projeto;
	}
	
	public static List<AbendJobModel> getAbendJobs(){
		List<AbendJobModel> projetos = new ArrayList<>();
		projetos.add(getAbendJob());
		return projetos;
	}
	
	public static AbendJobModel getAbendJob(){
		AbendJobModel projeto = new AbendJobModel();
		projeto.setSiglaProjeto("test1");
		projeto.setNomeJob("test");
		projeto.setTsAbend(LocalDateTime.now());
		return projeto;
	}
}
