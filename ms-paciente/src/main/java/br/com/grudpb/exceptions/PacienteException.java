package br.com.grudpb.exceptions;

import jakarta.ws.rs.core.Response;

public class PacienteException extends Throwable {
    private String message;
    private Response.Status status;

    public PacienteException(Response.Status status, String message){
        super(message);
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Response.Status getStatus() {
        return status;
    }
}
