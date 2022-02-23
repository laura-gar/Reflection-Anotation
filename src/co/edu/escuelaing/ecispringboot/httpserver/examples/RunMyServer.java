package co.edu.escuelaing.ecispringboot.httpserver.examples;

import co.edu.escuelaing.ecispringboot.httpserver.ECISpringBoot;

public class RunMyServer {
    public static void main(String ... args){
        ECISpringBoot.getInstance().startServer();
    }
}
