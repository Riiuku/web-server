package web.server.handler.request;

import web.server.domain.Request;

import java.io.BufferedWriter;
import java.io.IOException;

public interface RequestHandler {
    void handle(Request request, BufferedWriter out) throws IOException;
}
