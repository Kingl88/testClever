package dao;

import dao.interfacies.DAO;
import db.DBConnection;
import entities.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO implements DAO<User> {
    private final String GET_ALL_USERS = "SELECT u FROM Users u";
    private final Connection connection = DBConnection.getConnection();
    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(GET_ALL_USERS);
        while (resultSet.next()){
            User tempUser = new User();
            tempUser.setId(resultSet.getLong("id"));
            tempUser.setName(resultSet.getString("name"));
            tempUser.setName(resultSet.getString("surname"));
            tempUser.setName(resultSet.getString("lastname"));
        }
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user, String[] params) {

    }

    @Override
    public void delete(User user) {

    }
}
