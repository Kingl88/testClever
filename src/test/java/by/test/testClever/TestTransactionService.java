package by.test.testClever;

import by.test.testClever.dao.AccountDAO;
import by.test.testClever.dao.BankDAO;
import by.test.testClever.entities.Transaction;
import by.test.testClever.services.TransactionService;
import by.test.testClever.utils.PDFSaverForCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Optional;

public class TestTransactionService {
    private final TransactionService service = new TransactionService();
    private final AccountDAO accountDAO = AccountDAO.getInstance();
    private final BankDAO bankDAO = BankDAO.getInstance();

    @Test
    void accountReplenishmentTransactionTest() {
        Long id = service.accountReplenishmentTransaction("insert", "BYN", 2, 2, BigDecimal.valueOf(1000));
        Assertions.assertNotNull(id);
        Optional<Transaction> transaction = service.getTransactionById(id);
        Transaction trans = transaction.get();
        trans.setTo(accountDAO.get(trans.getTo().getId()).get());
        trans.setFrom(accountDAO.get(trans.getFrom().getId()).get());
        trans.getFrom().setBank(bankDAO.get(trans.getFrom().getId()).get());
        trans.getTo().setBank(bankDAO.get(trans.getTo().getId()).get());
        PDFSaverForCheck.saveCheck(transaction.get());
    }
}
