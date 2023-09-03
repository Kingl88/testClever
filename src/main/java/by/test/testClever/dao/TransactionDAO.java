package by.test.testClever.dao;

import by.test.testClever.dao.interfacies.DAO;
import by.test.testClever.entities.Account;
import by.test.testClever.entities.Transaction;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class TransactionDAO extends AbstractDao implements DAO<Transaction> {
    private static final TransactionDAO INSTANCE = new TransactionDAO();
    private final String SAVE_TRANSACTION = "insert into transactions (type, currency_type, from_account_id, to_account_id, count)\n" +
            "VALUES (?, ?, ?, ?, ?)";
    private final String GET_TRANSACTION_BY_ID = "select * from transactions where id = ?";

    private TransactionDAO() {
        super(LoggerFactory.getLogger(TransactionDAO.class));
    }

    public static TransactionDAO getInstance() {
        return INSTANCE;
    }

    @Override
    public Optional<Transaction> get(long id) {
        ResultSet resultSet;
        Transaction newTransaction = new Transaction();
        try (Connection connection = getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(GET_TRANSACTION_BY_ID);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
            resultSet = preparedStatement.getResultSet();
            resultSet.next();
            newTransaction.setId(resultSet.getLong("id"));
            newTransaction.setType(resultSet.getString("type"));
            newTransaction.setCurrencyType(resultSet.getString("currency_type"));
            newTransaction.setTo(new Account((long) resultSet.getInt("to_account_id")));
            newTransaction.setFrom(new Account((long) resultSet.getInt("from_account_id")));
            newTransaction.setCount(resultSet.getBigDecimal("count"));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(newTransaction);
    }


    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public Long save(Transaction transaction) {
        ResultSet resultSet = null;
        Long result = null;
        try (Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement(SAVE_TRANSACTION, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, transaction.getType());
            statement.setString(2, transaction.getCurrencyType());
            statement.setLong(3, transaction.getFrom().getId());
            statement.setLong(4, transaction.getTo().getId());
            statement.setBigDecimal(5, transaction.getCount());
            statement.executeUpdate();

            resultSet = statement.getGeneratedKeys();
            while (resultSet.next()) {
                result = resultSet.getLong("id");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            closeQuietly(resultSet);
        }
        return result;
    }

    @Override
    public void update(Transaction transaction) {

    }

    @Override
    public void delete(Transaction transaction) {

    }
}
