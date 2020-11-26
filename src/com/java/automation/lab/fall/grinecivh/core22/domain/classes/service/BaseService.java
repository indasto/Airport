package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.sql.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.OfficeEmployees;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.Pilot;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.Security;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.Steward;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.PropertyReader;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.util.Route;

import java.util.Map;

public class BaseService {
    protected static final PropertyReader PROPS = PropertyReader.getInstance();

    protected static final Map<String, ClientDAO> CLIENT_DAOS = Map.of(
            "MOCK", new ClientDAOImpl(),
            "OBJ", new ClientDAOImplClasz(),
            "SQL", new ClientDAOImplSql()
    );

    protected static final Map<String, FlightDAO> FLIGHT_DAOS = Map.of(
            "MOCK", new FlightDAOImpl(),
            "OBJ", new FlightDAOImplClasz(),
            "SQL", new FlightDAOImplSql()
    );

    protected static final Map<String, PlaneDao<ShortDistancePlane>> SHORT_PLANE_DAOS = Map.of(
            "MOCK", new PlaneDAOImpl(),
            "OBJ", new PlaneDAOImplClasz(),
            "SQL", new PlaneDAOImplSql()
    );

    protected static final Map<String, PlaneDao<MediumDistancePlane>> MEDIUM_PLANE_DAOS = Map.of(
            "MOCK", new PlaneDAOImpl(),
            "OBJ", new PlaneDAOImplClasz(),
            "SQL", new PlaneDAOImplSql()
    );

    protected static final Map<String, PlaneDao<PrivatePlane>> PRIVATE_PLANE_DAOS = Map.of(
            "MOCK", new PlaneDAOImpl(),
            "OBJ", new PlaneDAOImplClasz(),
            "SQL", new PlaneDAOImplSql()
    );

    protected static final Map<String, PlaneDao<LongDistancePlane>> LONG_PLANE_DAOS = Map.of(
            "MOCK", new PlaneDAOImpl(),
            "OBJ", new PlaneDAOImplClasz(),
            "SQL", new PlaneDAOImplSql()
    );

    protected static final Map<String, RouteDAO> ROUTE_DAOS = Map.of(
            "MOCK", new RouteDAOImpl(),
            "OBJ", new RouteDAOImplClasz(),
            "SQL", new RouteDAOImplSql()
    );

    protected static final Map<String, TicketDAO> TICKET_DAOS = Map.of(
            "MOCK", new TicketDAOImpl(),
            "OBJ", new TicketDAOImplClasz(),
            "SQL", new TicketDAOImplSql()
    );

    protected static final Map<String,WorkerDAO<Pilot> > PILOT_DAOS = Map.of(
            "MOCK", new WorkerDAOImpl(),
            "OBJ", new WorkerDAOImplClasz(),
            "SQL", new WorkerDAOImplSql()
    );

    protected static final Map<String,WorkerDAO<OfficeEmployees> > OFFICE_EMPLOYEE_DAOS = Map.of(
            "MOCK", new WorkerDAOImpl(),
            "OBJ", new WorkerDAOImplClasz(),
            "SQL", new WorkerDAOImplSql()
    );

    protected static final Map<String,WorkerDAO<Security> > SECURITY_DAOS = Map.of(
            "MOCK", new WorkerDAOImpl(),
            "OBJ", new WorkerDAOImplClasz(),
            "SQL", new WorkerDAOImplSql()
    );

    protected static final Map<String,WorkerDAO<Steward> > STEWARD_DAOS = Map.of(
            "MOCK", new WorkerDAOImpl(),
            "OBJ", new WorkerDAOImplClasz(),
            "SQL", new WorkerDAOImplSql()
    );

}
