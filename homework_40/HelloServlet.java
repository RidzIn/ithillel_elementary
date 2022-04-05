package ua.ridz;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;

@WebServlet("/hi")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        if(Objects.equals(req.getParameter("name"), "Anton")){
            printWriter.write("Hello, world! I’m Anton");
        } else {
            printWriter.write("Hello Wrld!");
        }
        printWriter.close();
    }
}
