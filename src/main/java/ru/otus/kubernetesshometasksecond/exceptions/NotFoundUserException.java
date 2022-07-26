package ru.otus.kubernetesshometasksecond.exceptions;

public class NotFoundUserException extends RuntimeException {

    public NotFoundUserException(String message) {
        super(message);
    }
}
