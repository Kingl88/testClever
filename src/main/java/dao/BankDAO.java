package dao;

import dao.interfacies.DAO;
import entities.Bank;

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
    public void save(Bank bank) {

    }

    @Override
    public void update(Bank bank, String[] params) {

    }

    @Override
    public void delete(Bank bank) {

    }
}
