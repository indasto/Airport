package com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.RouteDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RouteDAOImpl implements RouteDAO {
    List<Route> routes;

    public RouteDAOImpl() {
        routes = new ArrayList<>();
    }

    @Override
    public Route create(Route o) {
        routes.add(o);
        return o;
    }

    @Override
    public Route getById(int id) {
        return routes.get(id);
    }

    @Override
    public List<Route> get() {
        return Collections.unmodifiableList(routes);
    }

    @Override
    public Route update(Route o) {
        return null;
    }

    @Override
    public int deleteById(int id) {
        routes.remove(id);
        return id;
    }
}
