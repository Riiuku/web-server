package web.server.domain;

public class Request {
    private HttpMethod httpMethod;
    private String path;
    private String data;

    public Request(HttpMethod httpMethod, String path, String data) {
        this.httpMethod = httpMethod;
        this.path = path;
        this.data = data;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
