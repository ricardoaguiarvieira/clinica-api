package com.prime.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.prime.dto.AgendaDentistaDto;
import com.prime.dto.AgendamentoDto;
import com.prime.exception.NegocioException;
import com.prime.service.AgendaService;

@Path("/agenda")
@Tag(name = "Agenda")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AgendaResource {
	
	@Inject
	AgendaService agendaService;
	
	@POST
	@Operation(summary = "Salvar agendamento", description = "")
    @APIResponse(responseCode = "200", description = "AgendamentoDto",
        content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = AgendamentoDto.class))})
    public Response saveAgendamento(AgendamentoDto agendamento) {
		
		return Response.status(Response.Status.OK).entity(
				agendaService.saveAgendamento(agendamento)).build();
    }
	
	@GET
	@Path("{data}")
	@Operation(summary = "Agendamentos por data", description = "Example data: 'dd/mm/yyyy'")
    @APIResponse(responseCode = "200", description = "AgendamentoDto",
        content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = AgendaDentistaDto[].class))})
    public Response getAgendamentoPorData(@PathParam("data") String data) {
		
        try {
			return Response.status(Response.Status.OK).entity(
					agendaService.getAgendamentosPorData(data)).build();
		} catch (NegocioException e) {
			e.printStackTrace();
			return Response.status(Response.Status.PRECONDITION_FAILED).entity(e).build();
		}
    }
	
	@PUT
	@Operation(summary = "Atualizar agendamento", description = "")
    @APIResponse(responseCode = "200", description = "AgendamentoDto",
        content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = AgendamentoDto.class))})
    public Response updateAgendamento(AgendamentoDto agendamento) {
		
		return Response.status(Response.Status.OK).entity(
				agendaService.updateAgendamento(agendamento)).build();
    }
	
	@DELETE
	@Path("{id}")
	@Operation(summary = "Deletar agendamento", description = "")
    @APIResponse(responseCode = "200", description = "AgendamentoDto",
        content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = AgendamentoDto.class))})
    public Response deleteAgendamento(@PathParam("id") Long id) {
		
		return Response.status(Response.Status.OK).entity(
				agendaService.deleteAgendamento(id)).build();
    }
	
	@GET
	@Path("horarios")
	@Operation(summary = "Horarios Disponíveis", description = "Recupera horarios disponíveis")
    @APIResponse(responseCode = "200", description = "AgendamentoDto",
        content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = String[].class))})
    public Response getHorarios(@PathParam("data") String data) {
			return Response.status(Response.Status.OK).entity(
					agendaService.getHorarios()).build();
    }

}
