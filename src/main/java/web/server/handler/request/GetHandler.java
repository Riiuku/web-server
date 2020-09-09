package web.server.handler.request;

import web.server.config.ServerProperties;
import web.server.domain.HttpStatus;
import web.server.domain.Request;

import java.io.*;

import static web.server.config.Contract.INDEX;

public class GetHandler implements RequestHandler {
    @Override
    public void handle(Request request, BufferedWriter out) throws IOException {

        File htmlFile;

        if (request.getPath().isEmpty()) {
            htmlFile = new File(ServerProperties.get("content.path") + INDEX);
        } else {
            htmlFile = new File(ServerProperties.get("content.path") + request.getPath());
        }

        if (htmlFile.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(htmlFile))) {
                out.write(HttpStatus.getResponseFor(HttpStatus.OK));
                out.write("\r\n");
                for (String line; (line = br.readLine()) != null; ) {
                    out.write(line);
                }
            } catch (Exception exception) {
                out.write(HttpStatus.getResponseFor(HttpStatus.INTERNAL_SERVER_ERROR));
            }
        } else {
            out.write(HttpStatus.getResponseFor(HttpStatus.NOT_FOUND));
        }
    }
}
