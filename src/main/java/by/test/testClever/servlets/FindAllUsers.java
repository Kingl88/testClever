package by.test.testClever.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import by.test.testClever.services.UserService;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet(name = "findAllUsers", value = "/findAllUsers")
public class FindAllUsers extends HttpServlet {
    private final UserService service = new UserService();

    public FindAllUsers() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        try {
            response.getWriter().write(Arrays.toString(service.getAll().toArray()));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
