package br.com.grudpb.commands.impl;

import br.com.grudpb.apis.dtos.PacienteBasicoDTO;
import br.com.grudpb.commands.CommandReturn;
import br.com.grudpb.exceptions.PacienteException;
import br.com.grudpb.models.Paciente;
import br.com.grudpb.qualifiers.CommandBasicoPacienteQualifier;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.Response;

@ApplicationScoped
@CommandBasicoPacienteQualifier
public class CommandBasicoPaciente implements CommandReturn<PacienteBasicoDTO, Long> {


    @Override
    public Uni<PacienteBasicoDTO> execute(Long codPaciente) {
        return Paciente.findById(codPaciente)
                .map(finded -> {
                    var paciente = (Paciente) finded;
                    return new PacienteBasicoDTO(paciente.getNome(), paciente.getId().toString());
                })
                .onFailure()
                .recoverWithUni(error -> Uni.createFrom().failure(new PacienteException(Response.Status.NOT_FOUND, "Paciente não encontrado")));
    }
}
