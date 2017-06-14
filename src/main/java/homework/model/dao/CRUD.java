package homework.model.dao;

import java.util.Collection;

public interface CRUD<T> {

    void create(T obj);

    T read(int id);

    Collection<T> read();

    void update(int id, T obj);

    void delete(int id);
}
