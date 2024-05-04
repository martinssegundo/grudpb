package br.com.grudpb.apis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PacienteCompletoDTO(@JsonProperty("nome") String nome,
                                  @JsonProperty("codigo-identificacao") Long codigo,
                                  @JsonProperty("codigo-consulta") Long codigoConsulta) { }
