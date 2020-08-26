package web.server.domain;

import java.util.Arrays;
import java.util.function.Predicate;

public enum HttpMethod {
    GET, POST, PUT, DELETE, PATCH, OPTIONS;

    public static boolean contains(String value) {
        return Arrays
                .stream(HttpMethod.values())
                .map(Enum::toString)
                .anyMatch(Predicate.isEqual(value));
    }

}
