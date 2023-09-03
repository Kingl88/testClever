package by.test.testClever;

import by.test.testClever.dao.UserDAO;
import by.test.testClever.entities.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.util.List;


public class TestUserService {
private final UserDAO userDAO = UserDAO.getInstance();
@Test
void getAllUsers() throws SQLException {
    List<User> list = userDAO.getAll();
    Assertions.assertEquals(23, list.size());
}
}
