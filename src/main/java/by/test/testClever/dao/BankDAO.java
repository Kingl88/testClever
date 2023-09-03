package by.test.testClever.dao;

import by.test.testClever.dao.interfacies.DAO;
import by.test.testClever.entities.Bank;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class BankDAO extends AbstractDao implements DAO<Bank> {
    private static final BankDAO INSTANCE = new BankDAO();
    private final String GET_BANK_BY_ID = "SELECT * from banks WHERE id = ?";

    private BankDAO() {
        super(LoggerFactory.getLogger(AccountDAO.class));
    }

    public static BankDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<Bank> get(long id) {
        ResultSet resultSet;
        Bank newBank = new Bank();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BANK_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            resultSet.next();
            newBank.setId(resultSet.getLong("id"));
            newBank.setName(resultSet.getString("name"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(newBank);
    }

    @Override
    public List<Bank> getAll() {
        return null;
    }

    @Override
    public Long save(Bank bank) {
        return null;
    }

    @Override
    public void update(Bank bank) {

    }

    @Override
    public void delete(Bank bank) {

    }
}
