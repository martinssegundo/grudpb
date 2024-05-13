package br.com.grudpb.apis;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

@QuarkusTest
class PacienteApiTest {
    @Inject
    PacienteApi pacienteApi;

    @Test
    void testGetPacienteBasico() {
        given()
                .when()
                .get("/v1/paciente/informacoes/basicas/1")
                .then()
                .statusCode(200)
                .body("nome", equalTo("Luiz Segundo"))
                .body("codigo-identificacao", equalTo("1"));
    }

    //@Test
    void testGetPacienteCompleto() {
        given()
                .when()
                .get("/v1/paciente/informacoes/completo/1")
                .then()
                .statusCode(200)
                .body("nome", equalTo("Luiz Segundo"))
                .body("codigo-identificacao", equalTo("1"));
    }

    @Test
    void testAtualizaPaciente() throws IOException {

        String filePath = "jsons/paciente-update-body.json"; // Caminho do arquivo dentro da pasta resources
        String jsonContent = new String(getClass().getClassLoader().getResourceAsStream(filePath).readAllBytes());



        given()
                .contentType("application/json")
                .body(jsonContent)
                .when()
                .post("/v1/paciente")
                .then()
                .statusCode(201);
    }
}