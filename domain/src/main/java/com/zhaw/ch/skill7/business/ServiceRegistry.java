package com.zhaw.ch.skill7.business;

import com.zhaw.ch.skill7.dataaccess.*;
import com.zhaw.ch.skill7.initializing.DatabaseInit;
import com.zhaw.ch.skill7.interfaces.*;

public class ServiceRegistry implements IBootable {

    private IAvailabilityPlanDAO availabilityPlanDAO;
    private IDevelopmentDAO developmentDAO;
    private IEmployeeDAO employeeDAO;
    private ISkillDAO skillDAO;
    private ISkillRatingDAO skillRatingDAO;
    private ITeamDAO teamDAO;
    private DatabaseInit databaseInit;

    public ServiceRegistry(){
        availabilityPlanDAO = new AvailabilityPlanDAO();
        developmentDAO = new DevelopmentDAO();
        employeeDAO = new EmployeeDAO();
        skillDAO = new SkillDAO();
        skillRatingDAO = new SkillRatingDAO();
        teamDAO = new TeamDAO();
        databaseInit = new DatabaseInit(developmentDAO, skillDAO, skillRatingDAO, teamDAO, employeeDAO, availabilityPlanDAO);
    }

    @Override
    public void boot() {
        databaseInit.initializeDatabase();
    }

    public IAvailabilityPlanDAO getAvailabilityPlanDAO() {
        return availabilityPlanDAO;
    }

    public IDevelopmentDAO getDevelopmentDAO() {
        return developmentDAO;
    }

    public IEmployeeDAO getEmployeeDAO() {
        return employeeDAO;
    }

    public ISkillDAO getSkillDAO() {
        return skillDAO;
    }

    public ISkillRatingDAO getSkillRatingDAO() {
        return skillRatingDAO;
    }

    public ITeamDAO getTeamDAO() {
        return teamDAO;
    }
}
