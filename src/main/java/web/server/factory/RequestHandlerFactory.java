package web.server.factory;

import web.server.domain.HttpMethod;
import web.server.domain.Request;
import web.server.handler.request.GetHandler;
import web.server.handler.request.PostHandler;
import web.server.handler.request.RequestHandler;

public class RequestHandlerFactory {
    public static RequestHandler createRequestHandler(HttpMethod httpMethod) {
        switch (httpMethod) {
            case GET: return new GetHandler();
            case POST: return new PostHandler();
            default: throw new IllegalArgumentException("Method: [" + httpMethod.name() + "] not handled yet!");
        }
    }
}
