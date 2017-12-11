package dao;

import entity.BaseEntity;

import java.util.List;

public interface BaseDao <T extends BaseEntity> {
    T insert(T entity);

    T update(T entity);

    Boolean delete(T entity);

    T findById(int id);

    List<T> find();
}
