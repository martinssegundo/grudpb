package br.com.grudpb.apis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;


public record ConsultaDTO(@JsonProperty("data-consulta") LocalDate dataConsulta,
                          @JsonProperty("diagnostico") String diagnostico,
                          @JsonProperty("medicamentos") List<MedicamentoDTO> medicamentos) { }
