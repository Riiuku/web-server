package web.server.handler.request;

import web.server.domain.Request;

public interface RequestHandler {
    void handle(Request request);
}
