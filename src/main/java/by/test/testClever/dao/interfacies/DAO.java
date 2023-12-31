package by.test.testClever.dao.interfacies;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface DAO <T>{
    Optional<T> get(long id);

    List<T> getAll() throws SQLException;

    Long save(T t) throws SQLException;

    void update(T t);

    void delete(T t);
}
