package web.server.domain;

public enum OperatedFile {
    PHP("php"),
    JS("js");

    private String value;

    OperatedFile(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
