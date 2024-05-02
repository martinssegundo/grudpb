package br.com.grudpb.commands;

import io.smallrye.mutiny.Uni;

public interface CommandReturn <T, Y> {
    Uni<T> execute(Y y);
}
