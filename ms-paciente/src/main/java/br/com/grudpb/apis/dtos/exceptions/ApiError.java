package br.com.grudpb.apis.dtos.exceptions;

import jakarta.ws.rs.core.Response;

public record ApiError (String message, Response.Status status){}
