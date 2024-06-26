package br.com.grudpb.commands.impl;

import br.com.grudpb.apis.dtos.PacienteCompletoDTO;
import br.com.grudpb.commands.CommandReturn;
import br.com.grudpb.models.Paciente;
import br.com.grudpb.qualifiers.CommandCompletoPacienteQualifier;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;


@ApplicationScoped
@CommandCompletoPacienteQualifier
public class CommandPacientreCompleto implements CommandReturn<PacienteCompletoDTO, Long> {
    @Override
    public Uni<PacienteCompletoDTO> execute(Long codPaciente) {
        return Paciente.findById(codPaciente)
                .map(finded -> {
                    var paciente = (Paciente) finded;
                    return null;
                });
    }
}
