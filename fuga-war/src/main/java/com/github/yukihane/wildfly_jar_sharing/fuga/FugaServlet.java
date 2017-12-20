package com.github.yukihane.wildfly_jar_sharing.fuga;

import java.io.IOException;
import java.io.PrintWriter;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.github.yukihane.wildfly_sharing_jar.Hello;

@WebServlet("/fuga")
public class FugaServlet extends HttpServlet {

    @Inject
    private Hello hello;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println(hello.hello() + ", fuga!");
        out.println("</body></html>");
    }

}
