package by.test.testClever.dao;

import by.test.testClever.dao.interfacies.DAO;
import by.test.testClever.entities.Account;
import by.test.testClever.entities.Bank;
import by.test.testClever.entities.User;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class AccountDAO extends AbstractDao implements DAO<Account> {
    private static final AccountDAO INSTANCE = new AccountDAO();
    private final String UPDATE_BALANCE_ACCOUNT = "UPDATE accounts SET balance = ? WHERE id = ?";
    private final String GET_ACCOUNT_BY_ID = "SELECT * from accounts WHERE id = ?";

    private AccountDAO() {
        super(LoggerFactory.getLogger(AccountDAO.class));
    }

    public static AccountDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<Account> get(long id) {
        ResultSet resultSet;
        Account newAccount = new Account();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_ACCOUNT_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            resultSet.next();
            newAccount.setId(resultSet.getLong("id"));
            newAccount.setNumberIBAN(resultSet.getString("number_iban"));
            newAccount.setNumber(resultSet.getString("number"));
            newAccount.setBank(new Bank(resultSet.getLong("bank_id")));
            newAccount.setUser(new User(resultSet.getLong("user_id")));
            newAccount.setBalance(resultSet.getBigDecimal("balance"));
            newAccount.setCurrencyType(resultSet.getString("currency_type"));

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(newAccount);
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public Long save(Account account) {
        return null;
    }

    @Override
    public void update(Account account) {
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_BALANCE_ACCOUNT);
            preparedStatement.setBigDecimal(1, account.getBalance());
            preparedStatement.setLong(2, account.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(Account account) {

    }
}
