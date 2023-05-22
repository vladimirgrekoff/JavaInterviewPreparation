package com.grekoff.app;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;

// http://localhost:8080/hello
@WebServlet(name = "HelloServlet", urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        this.message = "Hello World!";
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();

        try {
            resp.setContentType("text/html;charset=UTF-8");
            out.println("<html><head><title>Hello World</title></head>");
            out.println("<body><h2>" + message + "</h2></body></html>");
        }finally {
            out.close();
        }

    }

    @Override
    public void destroy() {
        super.destroy();
    }



}
