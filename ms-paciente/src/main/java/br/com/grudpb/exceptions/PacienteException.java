package br.com.grudpb.exceptions;

import br.com.grudpb.apis.dtos.exceptions.ApiError;
import jakarta.ws.rs.core.Response;

public class PacienteException extends Throwable {
    private ApiError apiError;

    public PacienteException(Response.Status status, String message){
        apiError = new ApiError(message,status);
    }

    public ApiError getApiError() {
        return apiError;
    }
}
