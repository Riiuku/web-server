package web.server.handler.request;

import web.server.domain.HttpStatus;
import web.server.domain.Request;

import java.io.*;

import static web.server.config.Contract.CONTENT_PATH;
import static web.server.config.Contract.INDEX;

public class GetHandler implements RequestHandler {
    @Override
    public void handle(Request request, BufferedWriter out) throws IOException {

        File htmlFile;
        if (request.getPath().equals("/")) {
            htmlFile = new File(CONTENT_PATH + INDEX);
        } else {
            htmlFile = new File(CONTENT_PATH + request.getPath());
        }

        if (htmlFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(htmlFile))) {
                out.write(HttpStatus.getResponseFor(HttpStatus.OK));
                out.write("\r\n");
                for (String line; (line = br.readLine()) != null; ) {
                    out.write(line + "\r\n");
                }
            } catch (Exception exception) {
                out.write(HttpStatus.getResponseFor(HttpStatus.INTERNAL_SERVER_ERROR));
                out.write("\r\n");
            }
        } else {
            out.write(HttpStatus.getResponseFor(HttpStatus.NOT_FOUND));
            out.write("\r\n");
        }
    }
}
