package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.ClientDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.FlightDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.PlaneDao;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz.ClientDAOImplClasz;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz.FlightDAOImplClasz;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.clasz.PlaneDAOImplClasz;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock.ClientDAOImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock.FlightDAOImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.mock.PlaneDAOImpl;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.sql.ClientDAOImplSql;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.sql.FlightDAOImplSql;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.impl.sql.PlaneDAOImplSql;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.plane.*;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.io.PropertyReader;

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
}
