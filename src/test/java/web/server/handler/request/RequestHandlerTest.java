package web.server.handler.request;

import org.junit.Test;
import web.server.domain.HttpMethod;
import web.server.domain.Request;
import web.server.factory.RequestHandlerFactory;

import static org.junit.Assert.*;

public class RequestHandlerTest {

    @Test
    public void checkGetHandler() {
        RequestHandler requestHandler = RequestHandlerFactory.createRequestHandler(HttpMethod.GET);


    }
}