package com.zhaw.ch.skill7.initializing;

import com.zhaw.ch.skill7.interfaces.*;
import com.zhaw.ch.skill7.model.*;
import com.zhaw.ch.skill7.view.*;
import com.zhaw.ch.skill7.model.builder.AvailabilityPlanBuilder;

import java.util.Arrays;

public class DatabaseInit {

    private IDevelopmentDAO developmentDAO;
    private ISkillDAO skillDAO;
    private ISkillRatingDAO skillRatingDAO;
    private ITeamDAO teamDAO;
    private IEmployeeDAO employeeDAO;
    private IAvailabilityPlanDAO availabilityPlanDAO;

    public DatabaseInit(IDevelopmentDAO developmentDAO, ISkillDAO skillDAO, ISkillRatingDAO skillRatingDAO, ITeamDAO teamDAO, IEmployeeDAO employeeDAO, IAvailabilityPlanDAO availabilityPlanDAO) {
        this.developmentDAO = developmentDAO;
        this.skillDAO = skillDAO;
        this.skillRatingDAO = skillRatingDAO;
        this.teamDAO = teamDAO;
        this.employeeDAO = employeeDAO;
        this.availabilityPlanDAO = availabilityPlanDAO;
    }

    public void initializeDatabase() {
        Skill skillReact = new Skill("React");
        Skill skillJava = new Skill("Java");
        Skill skillBlockchain = new Skill("Blockchain");
        Skill skillOracleDB = new Skill("Oracle DB");
        Skill skillMicroservice = new Skill("Microservice");

        addAllSkills(skillReact, skillJava, skillBlockchain, skillOracleDB, skillMicroservice);

        Team teamSkill7 = new Team("Skill7");
        Team teamFooBar = new Team("FooBar");
        Team teamEForce = new Team("EForce");
        addAllTeams(teamSkill7, teamFooBar, teamEForce);

        AvailabilityPlan availabilityPlan1 = AvailabilityPlanBuilder.anAvailabilityPlan().withMondayAvailability(Availability.AFTERNOON).build();
        AvailabilityPlan availabilityPlan2 = AvailabilityPlanBuilder.anAvailabilityPlan().withMondayAvailability(Availability.NOT_AVAILABLE).build();
        AvailabilityPlan availabilityPlan3 = AvailabilityPlanBuilder.anAvailabilityPlan().build();
        AvailabilityPlan availabilityPlan4 = AvailabilityPlanBuilder.anAvailabilityPlan().withThursdayAvailability(Availability.NOT_AVAILABLE).withFridayAvailability(Availability.NOT_AVAILABLE).build();
        AvailabilityPlan availabilityPlan5 = AvailabilityPlanBuilder.anAvailabilityPlan().withThursdayAvailability(Availability.NOT_AVAILABLE).withFridayAvailability(Availability.NOT_AVAILABLE).build();
        AvailabilityPlan availabilityPlan6 = AvailabilityPlanBuilder.anAvailabilityPlan().withWednesdayAvailability(Availability.NOT_AVAILABLE).build();
        AvailabilityPlan availabilityPlan7 = AvailabilityPlanBuilder.anAvailabilityPlan().withWednesdayAvailability(Availability.MORNING).build();
        AvailabilityPlan availabilityPlan8 = AvailabilityPlanBuilder.anAvailabilityPlan().withWednesdayAvailability(Availability.AFTERNOON).build();
        AvailabilityPlan availabilityPlan9 = AvailabilityPlanBuilder.anAvailabilityPlan().withFridayAvailability(Availability.NOT_AVAILABLE).build();
        AvailabilityPlan availabilityPlan10 = AvailabilityPlanBuilder.anAvailabilityPlan().build();
        AvailabilityPlan availabilityPlan11 = AvailabilityPlanBuilder.anAvailabilityPlan().build();
        AvailabilityPlan availabilityPlan12 = AvailabilityPlanBuilder.anAvailabilityPlan().build();

        addAllAvailabilityPlans(availabilityPlan1,availabilityPlan2,availabilityPlan3,availabilityPlan4,availabilityPlan5,availabilityPlan6,availabilityPlan7,availabilityPlan8,availabilityPlan9,availabilityPlan10,availabilityPlan11,availabilityPlan12);

        Employee employeeMischa = new Employee("Kolb", "Mischa", teamSkill7, availabilityPlan1);
        Employee employeeNicolas = new Employee("Salvisberg", "Nicolas", teamSkill7, availabilityPlan2);
        Employee employeeOliver = new Employee("Tanner", "Oliver", teamSkill7, availabilityPlan3);
        Employee employeeValentino = new Employee("Tella", "Valentino", teamSkill7, availabilityPlan4);
        Employee employeeMatthias = new Employee("Gubler", "Matthias", teamSkill7, availabilityPlan5);

        Employee employeeJunior = new Employee("Bodenmann", "Junior", teamFooBar, availabilityPlan6);
        Employee employeeMarkus = new Employee("Beer", "Markus", teamFooBar, availabilityPlan7);
        Employee employeePhilipp = new Employee("Lattenau", "Philipp", teamFooBar, availabilityPlan8);
        Employee employeeJames = new Employee("Schönheer", "James", teamFooBar, availabilityPlan9);

        Employee employeeDaniela = new Employee("Coloumb", "Daniela", teamEForce, availabilityPlan10);
        Employee employeeThomas = new Employee("Deutsch", "Thomas", teamEForce, availabilityPlan11);
        Employee employeeFred = new Employee("Heierli", "Fred", teamEForce, availabilityPlan12);

        addAllEmployees(employeeMischa,employeeNicolas,employeeOliver,employeeValentino,employeeMatthias,employeeJunior,employeeMarkus,employeePhilipp,employeeJames,employeeDaniela,employeeThomas,employeeFred);

        Development development1 = new Development(skillReact, DevelopmentRating.HIGH, employeeMischa);
        Development development2 = new Development(skillReact, DevelopmentRating.LOW, employeeDaniela);
        Development development3 = new Development(skillMicroservice, DevelopmentRating.HIGH, employeeMatthias);
        Development development4 = new Development(skillBlockchain, DevelopmentRating.MEDIUM, employeeMatthias);
        Development development5 = new Development(skillReact, DevelopmentRating.MEDIUM, employeeJunior);
        Development development6 = new Development(skillMicroservice, DevelopmentRating.MEDIUM, employeeThomas);
        Development development7 = new Development(skillJava, DevelopmentRating.HIGH, employeeDaniela);
        Development development8 = new Development(skillReact, DevelopmentRating.LOW, employeeNicolas);
        Development development9 = new Development(skillJava, DevelopmentRating.MEDIUM, employeePhilipp);
        Development development10 = new Development(skillOracleDB, DevelopmentRating.LOW, employeeDaniela);

        addAllDevelopments(development1,development2,development3,development4,development5,development6,development7,development8,development9,development10);

        SkillRating skillRatingTeam1 = new SkillRating(8, skillJava, teamSkill7);
        SkillRating skillRatingTeam2 = new SkillRating(2, skillOracleDB, teamSkill7);
        SkillRating skillRatingTeam3 = new SkillRating(6, skillReact, teamFooBar);
        SkillRating skillRatingTeam4 = new SkillRating(4, skillMicroservice, teamFooBar);
        SkillRating skillRatingTeam5 = new SkillRating(10, skillJava, teamFooBar);
        SkillRating skillRatingTeam6 = new SkillRating(9, skillBlockchain, teamEForce);
        SkillRating skillRatingTeam7 = new SkillRating(5, skillReact, teamEForce);

        SkillRating skillRatingEmployee1 = new SkillRating(9, skillJava, employeeMatthias);
        SkillRating skillRatingEmployee2 = new SkillRating(5, skillReact, employeeMatthias);
        SkillRating skillRatingEmployee3 = new SkillRating(4, skillMicroservice, employeeMatthias);
        SkillRating skillRatingEmployee4 = new SkillRating(7, skillJava, employeeMischa);
        SkillRating skillRatingEmployee5 = new SkillRating(6, skillJava, employeeNicolas);
        SkillRating skillRatingEmployee6 = new SkillRating(9, skillJava, employeeOliver);
        SkillRating skillRatingEmployee7 = new SkillRating(6, skillJava, employeeValentino);
        SkillRating skillRatingEmployee8 = new SkillRating(3, skillJava, employeeJunior);
        SkillRating skillRatingEmployee9 = new SkillRating(5, skillJava, employeeMarkus);
        SkillRating skillRatingEmployee10 = new SkillRating(2, skillReact, employeePhilipp);
        SkillRating skillRatingEmployee11 = new SkillRating(9, skillBlockchain, employeePhilipp);
        SkillRating skillRatingEmployee12 = new SkillRating(4, skillJava, employeePhilipp);
        SkillRating skillRatingEmployee13 = new SkillRating(7, skillJava, employeeJames);
        SkillRating skillRatingEmployee14 = new SkillRating(2, skillJava, employeeDaniela);
        SkillRating skillRatingEmployee15 = new SkillRating(9, skillJava, employeeThomas);
        SkillRating skillRatingEmployee16 = new SkillRating(6, skillJava, employeeFred);

        addAllSkillRatings(skillRatingTeam1, skillRatingTeam2, skillRatingTeam3, skillRatingTeam4, skillRatingTeam5, skillRatingTeam6, skillRatingTeam7, skillRatingEmployee1, skillRatingEmployee2, skillRatingEmployee3, skillRatingEmployee4, skillRatingEmployee5, skillRatingEmployee6, skillRatingEmployee7, skillRatingEmployee8, skillRatingEmployee9, skillRatingEmployee10, skillRatingEmployee11, skillRatingEmployee12, skillRatingEmployee13, skillRatingEmployee14, skillRatingEmployee15, skillRatingEmployee16);
    }

    private void addAllSkills(Skill... skills) {
        Arrays.asList(skills).forEach(skillDAO::addSkill);
    }

    private void addAllTeams(Team... teams) {
        Arrays.asList(teams).forEach(teamDAO::addTeam);
    }

    private void addAllAvailabilityPlans(AvailabilityPlan... availabilityPlans) {
        Arrays.asList(availabilityPlans).forEach(availabilityPlanDAO::addAvailabilityPlan);
    }

    private void addAllEmployees(Employee... employees) {
        Arrays.asList(employees).forEach(employeeDAO::addEmployee);
    }

    private void addAllDevelopments(Development... developments) {
        Arrays.asList(developments).forEach(developmentDAO::addDevelopment);
    }

    private void addAllSkillRatings(SkillRating... skillRatings) {
        Arrays.asList(skillRatings).forEach(skillRatingDAO::addSkillRating);
    }

}
