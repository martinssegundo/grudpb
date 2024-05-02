package br.com.grudpb.apis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record MedicamentoDTO(
        @JsonProperty("nome") String nome,
        @JsonProperty("via_aplicacao") String viaAplicacao,
        @JsonProperty("periodicidade") String periodicidade  ) {
}
