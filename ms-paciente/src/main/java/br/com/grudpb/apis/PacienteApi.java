package br.com.grudpb.apis;

import br.com.grudpb.apis.dtos.PacienteBasicoDTO;
import br.com.grudpb.apis.dtos.PacienteCompletoDTO;
import br.com.grudpb.apis.dtos.exceptions.ApiError;
import br.com.grudpb.commands.CommandReturn;
import br.com.grudpb.qualifiers.CommandAtualizaPacienteQualifier;
import br.com.grudpb.qualifiers.CommandBasicoPacienteQualifier;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

@Path("v1/paciente")
@WithTransaction
public class PacienteApi{

    private final CommandReturn<PacienteBasicoDTO, Long> commandBasicoPaciente;
    private final CommandReturn<PacienteBasicoDTO, PacienteCompletoDTO> commandAtualizaPaciente;

    @Inject
    public PacienteApi(@CommandBasicoPacienteQualifier CommandReturn<PacienteBasicoDTO, Long> commandBasicoPaciente,
                       @CommandAtualizaPacienteQualifier CommandReturn<PacienteBasicoDTO, PacienteCompletoDTO> commandAtualizaPaciente) {
        this.commandBasicoPaciente = commandBasicoPaciente;
        this.commandAtualizaPaciente = commandAtualizaPaciente;
    }

    @Path("/informacoes/basicas/{cod-pasciente}")
    @GET
    @Operation(summary = "GET Paciente Basico", description = "Retorna um paciente com informações básicas")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",
                    description = "Paciente Basico",
                    content = @Content(schema = @Schema(implementation = PacienteBasicoDTO.class))),
            @APIResponse(responseCode = "404",
                    description = "Paciente não encontrado",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @APIResponse(responseCode = "500", description = "Internal server Error")
    })
    public Uni<Response> getPacienteBasico(@RestPath("cod-pasciente") Long codPasciente){
        return commandBasicoPaciente.execute(codPasciente)
                .map(dto -> Response.ok(dto).build());
    }

    @Path("/informacoes/completo/{cod-pasciente}")
    @GET
    @Operation(summary = "GET Paciente Basico", description = "Retorna um paciente com informações completas")
    @APIResponses(value = {
            @APIResponse(responseCode = "200",
                    description = "Paciente Basico",
                    content = @Content(schema = @Schema(implementation = PacienteCompletoDTO.class))),
            @APIResponse(responseCode = "404",
                    description = "Paciente não encontrado",
                    content = @Content(schema = @Schema(implementation = ApiError.class))),
            @APIResponse(responseCode = "500", description = "Internal server Error")
    })
    public Uni<RestResponse<PacienteCompletoDTO>> getPacienteCompleto(@RestPath("cod-pasciente") Long codPasciente){
        return null;
    }

    @POST
    @Operation(summary = "POST Paciente", description = "Atualiza um paciente")
    @APIResponses(value = {
            @APIResponse(responseCode = "201", description = "Pacietne Criado"),
            @APIResponse(responseCode = "500", description = "Internal server Error")
    })
    public Uni<Response> atualizaPaciente(PacienteCompletoDTO pacienteCompletoDTO){
        return commandAtualizaPaciente.execute(pacienteCompletoDTO)
                .map(paciente -> Response.status(Response.Status.CREATED).build());
    }


}
