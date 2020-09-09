package web.server.domain;

import web.server.config.ServerProperties;

import static web.server.config.Contract.EMPTY;

public enum HttpStatus {
    OK(200),
    CREATED(201),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    private int value;

    HttpStatus(int i) {
        value = i;
    }


    public int getValue() {
        return value;
    }

    public static String getResponseFor(HttpStatus httpStatus) {
        return ServerProperties.get("http") + EMPTY + httpStatus.getValue() + EMPTY + httpStatus + "\r\n";
    }
}
