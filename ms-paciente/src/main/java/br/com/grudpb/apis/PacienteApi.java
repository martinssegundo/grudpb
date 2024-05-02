package br.com.grudpb.apis;

import br.com.grudpb.apis.dtos.PacienteBasicoDTO;
import br.com.grudpb.apis.dtos.PacienteCompletoDTO;
import br.com.grudpb.commands.CommandReturn;
import br.com.grudpb.qualifiers.CommandBasicoPacienteQualifier;
import io.quarkus.hibernate.reactive.panache.common.WithTransaction;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestPath;
import org.jboss.resteasy.reactive.RestResponse;

@Path("v1/paciente")
@WithTransaction
public class PacienteApi {

    private final CommandReturn<PacienteBasicoDTO, Long> commandBasicoPaciente;

    @Inject
    public PacienteApi(@CommandBasicoPacienteQualifier CommandReturn<PacienteBasicoDTO, Long> commandBasicoPaciente) {
        this.commandBasicoPaciente = commandBasicoPaciente;
    }

    @Path("/informacoes/basicas/{cod-pasciente}")
    @GET
    public Uni<Response> getPacienteBasico(@RestPath("cod-pasciente") Long codPasciente){
        return commandBasicoPaciente.execute(codPasciente)
                .map(dto -> Response.ok(dto).build());
    }

    @Path("/informacoes/completo/{cod-pasciente}")
    public Uni<RestResponse<PacienteCompletoDTO>> getPacienteCompleto(@RestPath("cod-pasciente") Long codPasciente){
        return null;
    }
}
