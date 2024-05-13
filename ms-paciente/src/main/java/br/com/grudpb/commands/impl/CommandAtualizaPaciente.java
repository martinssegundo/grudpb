package br.com.grudpb.commands.impl;

import br.com.grudpb.apis.dtos.PacienteBasicoDTO;
import br.com.grudpb.apis.dtos.PacienteCompletoDTO;
import br.com.grudpb.commands.CommandReturn;
import br.com.grudpb.models.Paciente;
import br.com.grudpb.qualifiers.CommandAtualizaPacienteQualifier;
import io.smallrye.mutiny.Uni;
import jakarta.enterprise.context.ApplicationScoped;

@CommandAtualizaPacienteQualifier
@ApplicationScoped
public class CommandAtualizaPaciente implements CommandReturn<PacienteBasicoDTO, PacienteCompletoDTO> {



    @Override
    public Uni<PacienteBasicoDTO> execute(PacienteCompletoDTO pacienteCompletoDTO) {
        return atualizaPaciente(pacienteCompletoDTO)
                .onFailure()
                .invoke(() -> persisteNovoPaciente(pacienteCompletoDTO));

    }

    private Uni<PacienteBasicoDTO> persisteNovoPaciente(PacienteCompletoDTO pacienteCompletoDTO){
        return new Paciente(pacienteCompletoDTO.nome(), pacienteCompletoDTO.codigoConsulta())
                .persistAndFlush()
                .map(pacientePersistido -> {
                    Paciente paciente = (Paciente) pacientePersistido;
                    return new PacienteBasicoDTO(paciente.getNome(), paciente.getId().toString());
                });
    }

    private Uni<PacienteBasicoDTO> atualizaPaciente(PacienteCompletoDTO pacienteCompletoDTO){
        return Paciente.findById(pacienteCompletoDTO.codigo())
                .flatMap(encontrado -> {
                    Paciente pacienteEncontrado = (Paciente) encontrado;
                    pacienteEncontrado.getConsultas();
                    pacienteEncontrado.setNome(pacienteCompletoDTO.nome());
                    pacienteEncontrado.addConsulta(pacienteCompletoDTO.codigoConsulta(), pacienteEncontrado);
                    return encontrado.persistAndFlush();
                })
                .map(pacientePersistido -> {
                    Paciente paciente = (Paciente) pacientePersistido;
                    return new PacienteBasicoDTO(paciente.getNome(), paciente.getId().toString());
                });
    }
}
