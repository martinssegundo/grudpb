package br.com.grudpb.apis.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record PacienteBasicoDTO (
        @JsonProperty("nome") String nome,
        @JsonProperty("codigo-identificacao") String codigo){
}
