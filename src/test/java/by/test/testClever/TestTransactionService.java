package by.test.testClever;

import by.test.testClever.dao.AccountDAO;
import by.test.testClever.entities.Account;
import by.test.testClever.services.TransactionService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class TestTransactionService {
private final TransactionService service = new TransactionService();
private final AccountDAO accountDAO = AccountDAO.getInstance();
    @Test
    void accountReplenishmentTransactionTest(){
       Long id = service.accountReplenishmentTransaction(2, "insert", "BYN", 2, 2, BigDecimal.valueOf(1000));
        Account account = accountDAO.get(id).get();
        Assertions.assertEquals(account.getId(), id);
        Assertions.assertEquals(account.getCurrencyType(), "BYN");
    }
}
