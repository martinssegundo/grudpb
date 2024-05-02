package br.com.grudpb.apis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PacienteCompletoDTO(@JsonProperty("nome") String nome,
                                  @JsonProperty("codigo-identificacao") String codigo,
                                  @JsonProperty("dados-consulta") ConsultaDTO consulta) {
}
