package br.com.aluraflix.apialuraflix.model;

public class VideoNaoEncontradoException extends RuntimeException {
    public VideoNaoEncontradoException(String message) {
        super(message);
    }
}
