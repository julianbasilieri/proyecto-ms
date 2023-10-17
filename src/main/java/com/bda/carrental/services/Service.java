package com.bda.carrental.services;

import java.util.List;

public interface Service <T, W> {
    void add(T entity);

    T getById(W id);

    List<T> getAll();

    T delete(W id);

    void update(T entity);
}
