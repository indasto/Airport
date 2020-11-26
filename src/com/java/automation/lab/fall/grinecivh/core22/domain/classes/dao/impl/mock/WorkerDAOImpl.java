package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.WorkerDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.AbstractWorker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WorkerDAOImpl<T extends AbstractWorker> implements WorkerDAO<T> {

    List<T> workers;

    public WorkerDAOImpl(){
        workers = new ArrayList<>();
    }

    @Override
    public T create(T o) {
        workers.add(o);
        return o;
    }

    @Override
    public T getById(int id) {
        return workers.get(id);
    }

    @Override
    public List<T> get() {
        return Collections.unmodifiableList(workers);
    }

    @Override
    public T update(T o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        workers.remove(id);
        return id;
    }
}
