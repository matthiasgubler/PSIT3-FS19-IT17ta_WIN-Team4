package com.zhaw.ch.skill7.business;

import com.zhaw.ch.skill7.dataaccess.GenericDAO;
import com.zhaw.ch.skill7.initializing.DatabaseInit;
import com.zhaw.ch.skill7.interfaces.IBootable;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.*;

public class ServiceRegistry implements IBootable {

    private static final ServiceRegistry instance = new ServiceRegistry();

    private final IGenericDAO<AvailabilityPlan> availabilityPlanDAO;
    private final IGenericDAO<Development> developmentDAO;
    private final IGenericDAO<Employee> employeeDAO;
    private final IGenericDAO<Skill> skillDAO;
    private final IGenericDAO<SkillTeamRating> skillTeamRatingDAO;
    private final IGenericDAO<SkillEmployeeRating> skillEmployeeRatingDAO;
    private final IGenericDAO<SkillSearchFilterRating> skillSearchFilterRatingDAO;
    private final IGenericDAO<Team> teamDAO;
    private final DatabaseInit databaseInit;

    private ServiceRegistry() {
        availabilityPlanDAO = new GenericDAO<>();
        developmentDAO = new GenericDAO<>();
        employeeDAO = new GenericDAO<>();
        skillDAO = new GenericDAO<>();
        skillTeamRatingDAO = new GenericDAO<>();
        skillEmployeeRatingDAO = new GenericDAO<>();
        skillSearchFilterRatingDAO = new GenericDAO<>();
        teamDAO = new GenericDAO<>();
        databaseInit = new DatabaseInit(developmentDAO, skillDAO, skillTeamRatingDAO, skillEmployeeRatingDAO, skillSearchFilterRatingDAO, teamDAO, employeeDAO, availabilityPlanDAO);
    }

    public static ServiceRegistry getInstance() {
        return instance;
    }

    @Override
    public void boot() {
        databaseInit.initializeDatabase();
    }

    public IGenericDAO<AvailabilityPlan> getAvailabilityPlanDAO() {
        return availabilityPlanDAO;
    }

    public IGenericDAO<Development> getDevelopmentDAO() {
        return developmentDAO;
    }

    public IGenericDAO<Employee> getEmployeeDAO() {
        return employeeDAO;
    }

    public IGenericDAO<Skill> getSkillDAO() {
        return skillDAO;
    }

    public IGenericDAO<SkillTeamRating> getSkillTeamRatingDAO() {
        return skillTeamRatingDAO;
    }

    public IGenericDAO<SkillEmployeeRating> getSkillEmployeeRatingDAO() {
        return skillEmployeeRatingDAO;
    }

    public IGenericDAO<SkillSearchFilterRating> getSkillSearchFilterRatingDAO() {
        return skillSearchFilterRatingDAO;
    }

    public IGenericDAO<Team> getTeamDAO() {
        return teamDAO;
    }
}
