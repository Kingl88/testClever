package by.test.testClever.dao;

import by.test.testClever.dao.interfacies.DAO;
import by.test.testClever.entities.Bank;

import java.util.List;
import java.util.Optional;

public class BankDAO implements DAO<Bank> {
    @Override
    public Optional<Bank> get(long id) {
        return Optional.empty();
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
