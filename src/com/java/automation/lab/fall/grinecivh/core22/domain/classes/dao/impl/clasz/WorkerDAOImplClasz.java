package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.IOConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.WorkerDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.AbstractWorker;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.ObjectIO;

import java.util.List;

public class WorkerDAOImplClasz<T extends AbstractWorker> implements WorkerDAO<T> {
    @Override
    public T create(T o) {
        new ObjectIO<T>().write(o, IOConstant.WORKER_PATH);
        return o;
    }

    @Override
    public T getById(int id) {
        return new ObjectIO<T>().read(IOConstant.WORKER_PATH);
    }

    @Override
    public List<T> get() {
        return null;
    }

    @Override
    public T update(T o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
