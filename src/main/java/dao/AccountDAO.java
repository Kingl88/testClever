package dao;

import dao.interfacies.DAO;
import entities.Account;

import java.util.List;
import java.util.Optional;

public class AccountDAO implements DAO<Account> {
    @Override
    public Optional<Account> get(long id) {
        return Optional.empty();
    }

    @Override
    public List<Account> getAll() {
        return null;
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public void update(Account account, String[] params) {

    }

    @Override
    public void delete(Account account) {

    }
}
