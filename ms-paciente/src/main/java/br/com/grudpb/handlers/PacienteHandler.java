package br.com.grudpb.handlers;

import br.com.grudpb.exceptions.PacienteException;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class PacienteHandler implements ExceptionMapper<PacienteException> {
    @Override
    public Response toResponse(PacienteException e) {
        return Response.status(e.getApiError().status()).entity(e.getApiError()).build();
    }
}
