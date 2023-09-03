package by.test.testClever.services;

import by.test.testClever.dao.AccountDAO;
import by.test.testClever.dao.TransactionDAO;
import by.test.testClever.entities.Account;
import by.test.testClever.entities.Transaction;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.Optional;

public class TransactionService {
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    private final TransactionDAO transactionDAO = TransactionDAO.getInstance();

    public Optional<Transaction> getTransactionById(Long id){
        return transactionDAO.get(id);
    }
    public Long accountReplenishmentTransaction(String type, String currencyType, long toId, long fromId, BigDecimal count) {
        Account to = null;
        Long result = null;
        if (toId == fromId) {
            Optional<Account> accountTo = accountDAO.get(toId);
            if (accountTo.isPresent()) {
                to = accountTo.get();
                to.setBalance(to.getBalance().add(count));
                accountDAO.update(to);
            }
            if (Objects.nonNull(to) && currencyType.equals(to.getCurrencyType())) {
                Transaction transaction = new Transaction();
                transaction.setTo(to);
                transaction.setFrom(to);
                transaction.setCurrencyType(currencyType);
                transaction.setType(type);
                transaction.setCount(count);
                result = transactionDAO.save(transaction);
            }
        }
        return result;
    }
}
