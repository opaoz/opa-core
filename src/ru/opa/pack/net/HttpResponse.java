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
                //"Content-Length: " + message.length() + "\r\n" +
                "Access-Control-Allow-Origin: *\r\n" +
                "Connection: close\r\n\r\n";
        String result = response + message;

        outputStream.write(result.getBytes());
        outputStream.flush();
    }

    public static String readBodyPOST(BufferedReader in, String line) throws IOException {
        //BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        /*if (line == null) {
            in.close();
            return "none";
        }*/
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
            char[] c = new char[contentLength];
            in.read(c, 0, contentLength);

            body.append(c);
            /*for (int i = 0; i < contentLength; i++) {
                c = in.read();
                body.append((char) c);
            }*/
        }

        return body.toString();
    }

    public static void sendFileGET(OutputStream outputStream, String request, String publicFolder) throws IOException {
        String[] requestParam = request.split(" ");
        String path = requestParam[1];
        if (path.equals("/")) {
            path = "/index.html";
        }

        String response = "HTTP/1.1 200 OK\r\n" +
                "Server: YarServer/2009-09-09\r\n" +
                "Content-Type: text/" + (path.endsWith(".html") ? "html" : path.endsWith(".js") ? "javascript" : path.endsWith(".css") ? "css" : "jpeg") +
                "\r\n" +
                //"Content-Length: " + message.length() + "\r\n" +
                "Access-Control-Allow-Origin: *\r\n" +
                "Connection: close\r\n\r\n";

        PrintWriter out = new PrintWriter(outputStream, true);

        outputStream.write(response.getBytes());
        File file = new File(publicFolder + path);
        System.out.println(path);
        if (!file.exists()) {
            System.out.println("404");
            out.write("HTTP 404"); // the file does not exists
        }

        /*String statusLine = "HTTP/1.1 200 OK" + "\r\n";
        String serverdetails = "Server: Java HTTPServer";
        String contentTypeLine = "Content-Type: text/html" + "\r\n";

        out.write(statusLine);
        out.write(serverdetails);
        out.write(contentTypeLine);*/

        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);
        String line;
        while ((line = bfr.readLine()) != null) {
            out.write(line);
            out.write("\r\n");
        }

        bfr.close();
        out.close();
        fr.close();
    }

    public static void sendFileGET(OutputStream outputStream, String request) throws IOException {
        sendFileGET(outputStream, request, "public");
    }
}
