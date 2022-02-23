package co.edu.escuelaing.ecispringboot.httpserver.examples;

import co.edu.escuelaing.ecispringboot.httpserver.Service;

public class StatusService {
    @Service("/status")
    public static String status(){
        return "HTTP/1.1 200 OK\r\n"
                + "Content-Type: text/html\r\n"
                + "\r\n"
                + "<!DOCTYPE html>"
                + "<html>"
                + "<head>"
                + "<meta charset=\"UTF-8\">"
                + "<title>Status</title>\n"
                + "</head>"
                + "<body>"
                + "Service Status OK"
                + "</body>"
                + "</html>";
    }
}
