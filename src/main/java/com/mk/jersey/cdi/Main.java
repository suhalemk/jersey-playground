
package com.mk.jersey.cdi;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.webapp.WebAppContext;
import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import org.glassfish.jersey.jetty.JettyHttpContainerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.core.UriBuilder;
import java.io.IOException;
import java.net.URI;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {

    private static int getPort(int defaultPort) {
        //grab port from environment, otherwise fall back to default port 9998
        String httpPort = System.getProperty("jersey.test.port");
        if (null != httpPort) {
            try {
                return Integer.parseInt(httpPort);
            } catch (NumberFormatException e) {
            }
        }
        return defaultPort;
    }

    private static URI getBaseURI() {
        return UriBuilder.fromUri("http://localhost/").port(getPort(9998)).build();
    }

    public static final URI BASE_URI = getBaseURI();

    public static ResourceConfig createApp() {
        return new MyApplication();
    }

    protected static HttpServer startServer() throws IOException {

        System.out.println("Starting grizzly2...");
        return  GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
    }

    protected static Server startJettyServer() throws IOException {

        System.out.println("Starting Jetty...");
        Server server = JettyHttpContainerFactory.createServer(BASE_URI, createApp(), false);

        WebAppContext context = new WebAppContext();
        context.setResourceBase("~/projects/amp-backend/community2.0/JerseyCDI/src/main/webapp");
        context.setDescriptor("WEB-INF/web.xml");
        context.setContextPath("/");
        context.setParentLoaderPriority(true);
       //server.setHandler(context);

        return server;
    }

    public static void main(String[] args) {
        //useGrizzly();
        useJetty();
    }

    private static void useGrizzly() {
        try {
            System.out.println("JSON with Jackson Jersey Example App");

            final HttpServer server = startServer();//GrizzlyHttpServerFactory.createHttpServer(BASE_URI, createApp(), false);
            Runtime.getRuntime().addShutdownHook(new Thread(() -> server.shutdownNow()));
            server.start();

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private static void useJetty() {
        try {
            System.out.println("JSON with Jackson Jersey Example App");

            final Server server = startJettyServer();
            Runtime.getRuntime().addShutdownHook(new Thread(() -> server.setStopAtShutdown(true)));
            server.start();

            System.out.println(String.format("Application started.%nStop the application using CTRL+C"));

            Thread.currentThread().join();
        } catch (IOException | InterruptedException ex) {
            Logger.getLogger(MyApplication.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
