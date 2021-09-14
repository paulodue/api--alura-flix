package br.com.aluraflix.apialuraflix.model;

import javassist.NotFoundException;

public class CategoriaNaoEncontradaException extends RuntimeException {
    public CategoriaNaoEncontradaException(String message) {
        super(message);
    }
}
