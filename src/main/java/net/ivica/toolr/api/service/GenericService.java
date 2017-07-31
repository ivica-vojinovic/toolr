package net.ivica.toolr.api.service;

import net.ivica.toolr.api.Identifiable;

import java.util.List;

public interface GenericService<T extends Identifiable> {

    void clearSession();

    void delete(T entity);

    T findById(Long id);

    List<T> findAll();

    void flushSession();

    Long save(T entity);

    void saveOrUpdate(T entity);

    void update(T... entity);

}