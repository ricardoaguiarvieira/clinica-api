package com.prime.rest;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import com.prime.dto.PacienteReduzidoDto;
import com.prime.service.PacienteService;

@Path("/paciente")
@Tag(name = "Paciente")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PacienteResource {
	
	@Inject
	PacienteService pacienteService;

	@GET
	@Operation(summary = "Paciente por nome.", description = "Buscar paciente nome.")
    @APIResponse(responseCode = "200", description = "PacienteReduzidoDto",
        content = { @Content(mediaType = "application/json",
            schema = @Schema(implementation = PacienteReduzidoDto.class))})
    public Response findPacientePorNome(@QueryParam("nome") String nome) {
        return Response.status(Response.Status.OK).entity(
        		pacienteService.findPacientePorNome(nome)).build();
    }
}
