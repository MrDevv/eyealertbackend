package com.mrdevv.exception;

import lombok.Getter;

public class JwtExpiredException extends RuntimeException {
    @Getter
    private final String messageFront;
    private final String messageBack;

    public JwtExpiredException(String messageFront, String messageBack) {
        this.messageFront = messageFront;
        this.messageBack = messageBack;
        ;
    }

    @Override
    public String getMessage() {
        String message = super.getMessage();

        if (message == null){
            message = "";
        }

        return message.concat(messageBack);
    }
}
