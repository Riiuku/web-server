package web.server.domain;

import static web.server.config.Contract.EMPTY;
import static web.server.config.Contract.HTTP;

public enum HttpStatus {
    OK(200, "OK"),
    CREATED(201, "Created"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private int value;
    private String normal;

    HttpStatus(int value, String normal) {
        this.value = value;
        this.normal = normal;
    }

    public int getValue() {
        return value;
    }

    public String getNormal() {
        return normal;
    }

    public static String getResponseFor(HttpStatus httpStatus) {
        return HTTP + EMPTY + httpStatus.getValue() + EMPTY + httpStatus.getNormal() + "\r\n";
    }
}
