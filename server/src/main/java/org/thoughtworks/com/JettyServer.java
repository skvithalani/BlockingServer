package org.thoughtworks.com;

import org.mortbay.jetty.Server;
import org.mortbay.jetty.servlet.ServletHandler;
import org.mortbay.util.IO;

/**
 * Hello world!
 *
 */
public class JettyServer
{
    public static void main( String[] args ) throws Exception {
        Server server = new Server(8080);

        server.setThreadPool(new IO());
        System.out.println(server.getThreadPool());
        ServletHandler handler = new ServletHandler();
        handler.addServletWithMapping(PingHandler.class, "/");

        server.setHandler(handler);

        server.start();
        server.join();
    }
}
