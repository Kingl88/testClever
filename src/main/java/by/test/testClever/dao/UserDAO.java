package by.test.testClever.dao;

import by.test.testClever.dao.interfacies.DAO;
import by.test.testClever.entities.Bank;
import by.test.testClever.entities.User;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserDAO extends AbstractDao implements DAO<User> {
    private static final UserDAO INSTANCE = new UserDAO();
    private final String GET_ALL_USERS = "select users.id, users.name, surname, lastname, b.name as bank_name, b.id as bank_id from users\n" +
            "join public.banks_users bu on users.id = bu.user_id\n" +
            "join public.banks b on b.id = bu.bank_id";

    private UserDAO() {
        super(LoggerFactory.getLogger(UserDAO.class));
    }

    public static UserDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<User> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAll() throws SQLException {
        ArrayList<User> users = new ArrayList<>();
        ResultSet resultSet = null;
        try (Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery(GET_ALL_USERS);
            while (resultSet.next()) {
                User tempUser = new User();
                Bank tempBank = new Bank(resultSet.getLong("bank_id"), resultSet.getString("bank_name"), null);
                tempUser.setId(resultSet.getLong("id"));
                if (users.contains(tempUser)) {
                    int userIndex = users.indexOf(tempUser);
                    tempUser = users.get(userIndex);
                    if (!tempUser.getBanks().contains(tempBank)) {
                        tempUser.getBanks().add(tempBank);
                    }
                } else {
                    tempUser.setName(resultSet.getString("name"));
                    tempUser.setSurname(resultSet.getString("surname"));
                    tempUser.setLastname(resultSet.getString("lastname"));
                    tempUser.setBanks(new ArrayList<>());
                    tempUser.getBanks().add(tempBank);
                    users.add(tempUser);
                }
            }
        } finally {
            closeQuietly(resultSet);
        }
        return users;
    }

    @Override
    public Long save(User user) {
        return null;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }
}
