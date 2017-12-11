package service;

import java.util.List;

public interface BaseService<T> {
    T insert(T entity);

    T update(T entity);

    Boolean delete(T entity);

    T findById(int id);

    List<T> find();
}
