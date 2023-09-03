package by.test.testClever.services;

import by.test.testClever.dao.UserDAO;
import by.test.testClever.entities.User;

import java.sql.SQLException;
import java.util.List;

public class UserService {
    private final UserDAO userDAO = UserDAO.getInstance();

    public UserService(){
    }



    public List<User> getAll() throws SQLException {
        return userDAO.getAll();
    }

}
