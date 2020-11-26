package com.java.automation.lab.fall.grinecivh.core22.domain.classes.service;

import com.java.automation.lab.fall.grinecivh.core22.domain.classes.constant.PropertyConstant;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.dao.basis.WorkerDAO;
import com.java.automation.lab.fall.grinecivh.core22.domain.classes.entity.human.worker.*;

import java.util.List;

public class WorkerService extends BaseService {

    private WorkerDAO<OfficeEmployees> officeEmployeesDAO = OFFICE_EMPLOYEE_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));
    private WorkerDAO<Pilot> pilotDAO = PILOT_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));
    private WorkerDAO<Security> securityDAO = SECURITY_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));
    private WorkerDAO<Steward> stewardDAO = STEWARD_DAOS.get(PROPS.getValue(PropertyConstant.ENV_KEY));


    public <T extends AbstractWorker> void create(T worker) {

        if (worker instanceof OfficeEmployees) {
            officeEmployeesDAO.create((OfficeEmployees) worker);
        } else if (worker instanceof Pilot) {
            pilotDAO.create((Pilot) worker);
        } else if (worker instanceof Security) {
            securityDAO.create((Security) worker);
        } else if (worker instanceof Steward) {
            stewardDAO.create((Steward) worker);
        }
    }

    public AbstractWorker getById(int id, Class<?> cl) {

        AbstractWorker worker = null;

        if (cl.equals(OfficeEmployees.class)) {
            worker = officeEmployeesDAO.getById(id);
        } else if (cl.equals(Pilot.class)) {
            worker = pilotDAO.getById(id);
        } else if (cl.equals(Security.class)) {
            worker = securityDAO.getById(id);
        } else if (cl.equals(Steward.class)) {
            worker = stewardDAO.getById(id);
        }

        return worker;
    }

    public List<? extends AbstractWorker> get(Class<?> cl) {

        if (cl.equals(OfficeEmployees.class)) {
            return officeEmployeesDAO.get();
        } else if (cl.equals(Pilot.class)) {
            return pilotDAO.get();
        } else if (cl.equals(Security.class)) {
            return securityDAO.get();
        } else if (cl.equals(Steward.class)) {
            return stewardDAO.get();
        }

        return null;
    }

    public <T extends AbstractWorker> void update(T worker) {

        if (worker instanceof OfficeEmployees) {
            officeEmployeesDAO.update((OfficeEmployees) worker);
        } else if (worker instanceof Pilot) {
            pilotDAO.update((Pilot) worker);
        } else if (worker instanceof Security) {
            securityDAO.update((Security) worker);
        } else if (worker instanceof Steward) {
            stewardDAO.update((Steward) worker);
        }
    }

    public int deleteById(int id, Class<?> cl) {

        if (cl.equals(OfficeEmployees.class)) {
            return officeEmployeesDAO.deleteById(id);
        } else if (cl.equals(Pilot.class)) {
            return pilotDAO.deleteById(id);
        } else if (cl.equals(Security.class)) {
            return securityDAO.deleteById(id);
        } else if (cl.equals(Steward.class)) {
            return stewardDAO.deleteById(id);
        }

        return -1;
    }
}
