package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.stream.Collectors;

/**
 * Аннотация @WebServlet подсказывает Tomcat, по какому пути обрабатывать запросы.
 * Например, если наш сервлет называется simpleservlet, то путь запроса пользователя будет:
 * http://localhost:8080/simpleservlet/start
 */
@WebServlet(name = "myServlet", urlPatterns = "/start")
public class StartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        resp.getWriter().write("Hello, my dear friends");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String jsonString = req.getReader().lines().collect(Collectors.joining("\n"));
        System.out.println(jsonString);
        resp.setStatus(200);
        resp.getWriter().write("OK");
    }
}
