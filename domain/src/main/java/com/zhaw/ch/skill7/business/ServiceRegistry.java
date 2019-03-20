package com.zhaw.ch.skill7.business;

import com.zhaw.ch.skill7.dataaccess.*;
import com.zhaw.ch.skill7.initializing.DatabaseInit;
import com.zhaw.ch.skill7.interfaces.*;

public class ServiceRegistry implements IBootable {

    private static final ServiceRegistry instance = new ServiceRegistry();

    private IAvailabilityPlanDAO availabilityPlanDAO;
    private IDevelopmentDAO developmentDAO;
    private IEmployeeDAO employeeDAO;
    private ISkillDAO skillDAO;
    private ISkillRatingDAO skillRatingDAO;
    private ITeamDAO teamDAO;
    private DatabaseInit databaseInit;

    private ServiceRegistry() {
        availabilityPlanDAO = new AvailabilityPlanDAO();
        developmentDAO = new DevelopmentDAO();
        employeeDAO = new EmployeeDAO();
        skillDAO = new SkillDAO();
        skillRatingDAO = new SkillRatingDAO();
        teamDAO = new TeamDAO();
        databaseInit = new DatabaseInit(developmentDAO, skillDAO, skillRatingDAO, teamDAO, employeeDAO, availabilityPlanDAO);
    }

    public static ServiceRegistry getInstance() {
        return instance;
    }

    @Override
    public void boot() {
        databaseInit.initializeDatabase();
    }

    IAvailabilityPlanDAO getAvailabilityPlanDAO() {
        return availabilityPlanDAO;
    }

    IDevelopmentDAO getDevelopmentDAO() {
        return developmentDAO;
    }

    IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    ISkillDAO getSkillDAO() {
        return skillDAO;
    }

    ISkillRatingDAO getSkillRatingDAO() {
        return skillRatingDAO;
    }

    ITeamDAO getTeamDAO() {
        return teamDAO;
    }
}
