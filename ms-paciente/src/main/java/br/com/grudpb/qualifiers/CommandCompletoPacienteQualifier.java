package br.com.grudpb.qualifiers;


import jakarta.inject.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandCompletoPacienteQualifier {
}
