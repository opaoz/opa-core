package ru.opa.pack.net;

import java.io.*;

/**
 * Created by Vladimir_Levin on 05.12.2015.
 */
public final class HttpResponse {
    public static void writeResponse(String message, OutputStream outputStream) throws IOException {
        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/json\r\n" +
                "Content-Length: " + message.length() + "\r\n" +
                "Access-Control-Allow-Origin: *\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + message;

        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public static String readInputHeadersPOST(InputStream inputStream) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        String line = in.readLine();
        if (line == null) {
            in.close();
            return "none";
        }
        StringBuilder headers = new StringBuilder();
        StringBuilder body = new StringBuilder();
        boolean isPost = line.startsWith("POST");
        int contentLength = 0;

        headers.append("" + line);

        while (!(line = in.readLine()).equals("")) {
            headers.append('\n' + line);

            if (isPost) {
                String contentHeader = "Content-Length: ";
                if (line.startsWith(contentHeader)) {
                    contentLength = Integer.parseInt(line.substring(contentHeader.length()));
                }
            }
        }

        if (isPost) {
            int c;
            for (int i = 0; i < contentLength; i++) {
                c = in.read();
                body.append((char) c);
            }
        }

        return body.toString();
    }
}
