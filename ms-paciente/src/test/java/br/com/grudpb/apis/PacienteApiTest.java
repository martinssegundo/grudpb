package br.com.grudpb.apis;

import br.com.grudpb.apis.dtos.PacienteBasicoDTO;
import br.com.grudpb.apis.dtos.PacienteCompletoDTO;
import br.com.grudpb.commands.CommandReturn;
import io.quarkus.test.Mock;
import io.quarkus.test.junit.QuarkusTest;
import io.smallrye.mutiny.Uni;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.jboss.resteasy.reactive.RestResponse;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@QuarkusTest
class PacienteApiTest {
    @Mock
    CommandReturn<PacienteBasicoDTO, Long> commandBasicoPaciente;
    @Mock
    CommandReturn<PacienteBasicoDTO, PacienteCompletoDTO> commandAtualizaPaciente;
    @Inject
    PacienteApi pacienteApi;


    //@Test
    void testGetPacienteBasico() {
        when(commandBasicoPaciente.execute(anyLong())).thenReturn(null);
        when(commandAtualizaPaciente.execute(any(PacienteCompletoDTO.class))).thenReturn(null);
        given()
                .when()
                .get("")
                .then()
                .statusCode(200);
        Uni<Response> result = pacienteApi.getPacienteBasico(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    //@Test
    void testGetPacienteCompleto() {
        Uni<RestResponse<PacienteCompletoDTO>> result = pacienteApi.getPacienteCompleto(Long.valueOf(1));
        Assertions.assertEquals(null, result);
    }

    //@Test
    void testAtualizaPaciente() {
        //when(commandBasicoPaciente.execute(anyLong())).thenReturn(null);
        //when(commandAtualizaPaciente.execute(any(PacienteCompletoDTO.class))).thenReturn(null);

        Uni<Response> result = pacienteApi.atualizaPaciente(new PacienteCompletoDTO("nome", Long.valueOf(1), Long.valueOf(1)));
        Assertions.assertEquals(null, result);
    }
}