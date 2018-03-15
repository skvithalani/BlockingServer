package org.thoughtworks.com;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class PingHandler extends HttpServlet {

    private int counter = 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);
//        synchronized (this) {

            File file = new File("/Users/salonivithalani/Desktop/tw_tmt/extra/BlockingServer/server/src/main/java/org/thoughtworks/com/test1.txt");
            file.createNewFile();
            FileOutputStream os = new FileOutputStream(file);
            for (int i = 0; i < 900000; i++) {
                os.write(i);
            }
            os.flush();
            os.close();

            PrintWriter out = resp.getWriter();
            System.out.println(counter);
            out.println("request" + counter++);
//        }
    }
}
