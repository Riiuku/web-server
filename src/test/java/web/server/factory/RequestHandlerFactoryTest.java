package web.server.factory;

import org.junit.Test;
import web.server.domain.HttpMethod;
import web.server.handler.request.GetHandler;
import web.server.handler.request.PostHandler;
import web.server.handler.request.RequestHandler;

import static org.junit.Assert.assertTrue;

public class RequestHandlerFactoryTest {

    @Test
    public void getStatusShouldReturnGetHandler() {
        RequestHandler requestHandler = RequestHandlerFactory.createRequestHandler(HttpMethod.GET);
        assertTrue(requestHandler instanceof GetHandler);
    }

    @Test
    public void postStatusShouldReturnPostHandler() {
        RequestHandler requestHandler = RequestHandlerFactory.createRequestHandler(HttpMethod.POST);
        assertTrue(requestHandler instanceof PostHandler);
    }
}