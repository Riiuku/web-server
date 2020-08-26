package web.server.exception;

public class HttpRequestException extends RuntimeException {
    public HttpRequestException() {
        super();
    }

    public HttpRequestException(String s) {
        super(s);
    }

    public HttpRequestException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public HttpRequestException(Throwable throwable) {
        super(throwable);
    }

    protected HttpRequestException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
