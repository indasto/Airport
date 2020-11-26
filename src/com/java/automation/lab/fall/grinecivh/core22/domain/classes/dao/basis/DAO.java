package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis;

import java.util.List;

public interface DAO<T> {

    T create(T o);
    T getById(int id);
    List<T> get();
    T update(T o);
    int deleteById(int id);
}
