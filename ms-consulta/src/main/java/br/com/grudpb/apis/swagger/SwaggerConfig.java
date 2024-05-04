package br.com.grudpb.apis.swagger;


import jakarta.ws.rs.core.Application;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.info.Contact;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "API Gerenciador de consulta",
                description = "Api de gerenciamento de paciente com Quarkus",
                version = "1.0.0",
                contact = @Contact(
                        name = "Luiz Segundo",
                        url = "https://github.com/martinssegundo")),
        servers = {
                @Server(url = "http://localhost:8080")
        })
public class SwaggerConfig extends Application {
}
