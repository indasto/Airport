package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.PropertyConstant;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.RouteDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Route;

import java.util.List;

public class RouteService extends BaseService {
    private RouteDAO routeDAO = ROUTE_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));

    public Route create(Route o) {
        return routeDAO.create(o);
    }

    public Route getById(int id) {
        return routeDAO.getById(id);
    }

    public List<Route> get() {
        return routeDAO.get();
    }

    public Route update(Route o) {
        return routeDAO.update(o);
    }

    public int deleteById(int id) {
        return routeDAO.deleteById(id);
    }
}
