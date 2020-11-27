package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.IOConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.RouteDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.ObjectIO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Route;

import java.util.List;

public class RouteDAOImplClasz implements RouteDAO {
    @Override
    public Route create(Route o) {
        new ObjectIO<Route>().write(o, IOConstant.ROUTE_PATH);
        return o;
    }

    @Override
    public Route getById(int id) {
         return new ObjectIO<Route>().read(IOConstant.ROUTE_PATH);
    }

    @Override
    public List<Route> get() {
        return null;
    }

    @Override
    public Route update(Route o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        return 0;
    }
}
