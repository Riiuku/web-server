package web.server.exception;

public class PortAssignedException extends RuntimeException {
    public PortAssignedException() {

    }

    public PortAssignedException(String s) {
        super(s);
    }

    public PortAssignedException(String s, Throwable throwable) {
        super(s, throwable);
    }

    public PortAssignedException(Throwable throwable) {
        super(throwable);
    }

    protected PortAssignedException(String s, Throwable throwable, boolean b, boolean b1) {
        super(s, throwable, b, b1);
    }
}
