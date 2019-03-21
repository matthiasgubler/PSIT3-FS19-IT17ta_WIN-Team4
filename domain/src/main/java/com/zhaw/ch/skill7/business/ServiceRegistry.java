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
    private ISkillRatingDAO skillTeamRatingDAO;
    private ISkillRatingDAO skillEmployeeRatingDAO;
    private ISkillRatingDAO skillSearchFilterRatingDAO;
    private ITeamDAO teamDAO;
    private DatabaseInit databaseInit;

    private ServiceRegistry() {
        availabilityPlanDAO = new AvailabilityPlanDAO();
        developmentDAO = new DevelopmentDAO();
        employeeDAO = new EmployeeDAO();
        skillDAO = new SkillDAO();
        skillTeamRatingDAO = new SkillRatingDAO();
        skillEmployeeRatingDAO = new SkillRatingDAO();
        skillSearchFilterRatingDAO = new SkillRatingDAO();
        teamDAO = new TeamDAO();
        databaseInit = new DatabaseInit(developmentDAO, skillDAO, skillTeamRatingDAO, skillEmployeeRatingDAO, skillSearchFilterRatingDAO, teamDAO, employeeDAO, availabilityPlanDAO);
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

    public ISkillRatingDAO getSkillTeamRatingDAO() {
        return skillTeamRatingDAO;
    }

    public ISkillRatingDAO getSkillEmployeeRatingDAO() {
        return skillEmployeeRatingDAO;
    }

    public ISkillRatingDAO getSkillSearchFilterRatingDAO() {
        return skillSearchFilterRatingDAO;
    }

    ITeamDAO getTeamDAO() {
        return teamDAO;
    }
}
