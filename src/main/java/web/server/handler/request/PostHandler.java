package web.server.handler.request;

import web.server.domain.HttpStatus;
import web.server.domain.OperatedFile;
import web.server.domain.Request;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

import static web.server.config.Contract.*;

public class PostHandler implements RequestHandler {
    @Override
    public void handle(Request request, BufferedWriter out) throws IOException {

        OperatedFile operatedFile;
        try {
            operatedFile = getFileType(request.getPath());
        } catch (IllegalArgumentException exception) {
            out.write(HttpStatus.getResponseFor(HttpStatus.INTERNAL_SERVER_ERROR));
            out.write("\r\n");
            return;
        }

        if(!new File(CONTENT_PATH + request.getPath()).exists()) {
            out.write(HttpStatus.getResponseFor(HttpStatus.NOT_FOUND));
            out.write("\r\n");
            return;
        }

        System.out.println("/");
        Process process = Runtime.getRuntime().exec(new String[]{"php", "-r", "require '" + request.getPath()});

        System.out.println("Tutaj");

    }

    private OperatedFile getFileType(String path) {
        String format = path.split(DOT)[path.split(DOT).length - 1];
        return OperatedFile.valueOf(format.toUpperCase());

    }
}
