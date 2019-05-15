package com.zhaw.ch.skill7.database;

import com.zhaw.ch.skill7.domain.model.*;
import com.zhaw.ch.skill7.domain.model.builder.AvailabilityPlanBuilder;
import com.zhaw.ch.skill7.interfaces.IGenericDAO;

import java.util.Arrays;

public class DatabaseInit {

    private final IGenericDAO<Development> developmentDAO;
    private final IGenericDAO<Skill> skillDAO;
    private final IGenericDAO<SkillTeamRating> skillTeamRatingDAO;
    private final IGenericDAO<SkillEmployeeRating> skillEmployeeRatingDAO;
    private final IGenericDAO<SkillSearchFilterRating> skillSearchFilterRatingDAO;
    private final IGenericDAO<Team> teamDAO;
    private final IGenericDAO<Employee> employeeDAO;
    private final IGenericDAO<AvailabilityPlan> availabilityPlanDAO;

    public DatabaseInit(IGenericDAO<Development> developmentDAO, IGenericDAO<Skill> skillDAO, IGenericDAO<SkillTeamRating> skillTeamRatingDAO, IGenericDAO<SkillEmployeeRating> skillEmployeeRatingDAO, IGenericDAO<SkillSearchFilterRating> skillSearchFilterRatingDAO, IGenericDAO<Team> teamDAO, IGenericDAO<Employee> employeeDAO, IGenericDAO<AvailabilityPlan> availabilityPlanDAO) {
        this.developmentDAO = developmentDAO;
        this.skillDAO = skillDAO;
        this.skillTeamRatingDAO = skillTeamRatingDAO;
        this.skillEmployeeRatingDAO = skillEmployeeRatingDAO;
        this.skillSearchFilterRatingDAO = skillSearchFilterRatingDAO;
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
        Skill skillCSharp = new Skill("C#");

        addAll(skillDAO, skillReact, skillJava, skillBlockchain, skillOracleDB, skillMicroservice, skillCSharp);

        Team teamSkill7 = new Team("Skill7");
        Team teamFooBar = new Team("FooBar");
        Team teamEForce = new Team("EForce");
        Team teamFred = new Team("Fred");
        Team teamGreen = new Team("Green");
        Team teamYellow = new Team("Yellow");
        Team teamRed = new Team("Red");
        addAll(teamDAO, teamSkill7, teamFooBar, teamEForce, teamFred, teamGreen, teamYellow, teamRed);

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
        AvailabilityPlan availabilityPlan12 = AvailabilityPlanBuilder.anAvailabilityPlan().withTuesdayAvailability(Availability.MORNING).build();

        addAll(availabilityPlanDAO, availabilityPlan1, availabilityPlan2, availabilityPlan3, availabilityPlan4, availabilityPlan5, availabilityPlan6, availabilityPlan7, availabilityPlan8, availabilityPlan9, availabilityPlan10, availabilityPlan11, availabilityPlan12);

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

        Employee employeeAndreas = new Employee("Anders", "Andreas", teamYellow, availabilityPlan3);
        Employee employeeBrigitte = new Employee("Buenzli", "Brigitte", teamYellow, availabilityPlan3);
        Employee employeeClaudia = new Employee("Caballero", "Claudia", teamYellow, availabilityPlan3);

        Employee employeeGreen1 = new Employee("Green", "Uno", teamGreen, availabilityPlan3);
        Employee employeeGreen2 = new Employee("Green", "Dos", teamGreen, availabilityPlan3);
        Employee employeeGreen3 = new Employee("Green", "Tres", teamGreen, availabilityPlan3);

        Employee employeeRed1 = new Employee("Red", "One", teamRed, availabilityPlan3);
        Employee employeeRed2 = new Employee("Red", "Two", teamRed, availabilityPlan3);
        Employee employeeRed3 = new Employee("Red", "Three", teamRed, availabilityPlan3);

        addAll(employeeDAO, employeeMischa, employeeNicolas, employeeOliver, employeeValentino, employeeMatthias, employeeJunior, employeeMarkus, employeePhilipp, employeeJames, employeeDaniela, employeeThomas, employeeFred, employeeAndreas, employeeBrigitte, employeeClaudia, employeeGreen1, employeeGreen2, employeeGreen3, employeeRed1, employeeRed2, employeeRed3);

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
        Development development11 = new Development(skillJava, DevelopmentRating.HIGH, employeeValentino);
        Development development12 = new Development(skillReact, DevelopmentRating.MEDIUM, employeeValentino);

        addAll(developmentDAO, development1, development2, development3, development4, development5, development6, development7, development8, development9, development10, development11, development12);

        SkillTeamRating skillRatingTeam1 = new SkillTeamRating(8, skillJava, teamSkill7);
        SkillTeamRating skillRatingTeam2 = new SkillTeamRating(2, skillOracleDB, teamSkill7);
        SkillTeamRating skillRatingTeam3 = new SkillTeamRating(6, skillReact, teamFooBar);
        SkillTeamRating skillRatingTeam4 = new SkillTeamRating(4, skillMicroservice, teamFooBar);
        SkillTeamRating skillRatingTeam5 = new SkillTeamRating(10, skillJava, teamFooBar);
        SkillTeamRating skillRatingTeam6 = new SkillTeamRating(9, skillBlockchain, teamEForce);
        SkillTeamRating skillRatingTeam7 = new SkillTeamRating(5, skillReact, teamEForce);
        SkillTeamRating skillTeamRating9 = new SkillTeamRating(6, skillJava, teamYellow);
        SkillTeamRating skillTeamRating8 = new SkillTeamRating(4, skillCSharp,  teamYellow);
        SkillTeamRating skillTeamRating10 = new SkillTeamRating(6, skillJava, teamGreen);
        SkillTeamRating skillTeamRating11 = new SkillTeamRating(6, skillJava, teamRed);
        SkillTeamRating skillTeamRating12 = new SkillTeamRating(6, skillCSharp, teamRed);
        SkillTeamRating skillTeamRating13 = new SkillTeamRating(6, skillBlockchain, teamRed);

        SkillEmployeeRating skillRatingEmployee1 = new SkillEmployeeRating(9, skillJava, employeeMatthias);
        SkillEmployeeRating skillRatingEmployee2 = new SkillEmployeeRating(5, skillReact, employeeMatthias);
        SkillEmployeeRating skillRatingEmployee3 = new SkillEmployeeRating(4, skillMicroservice, employeeMatthias);
        SkillEmployeeRating skillRatingEmployee41 = new SkillEmployeeRating(7, skillJava, employeeMischa);
        SkillEmployeeRating skillRatingEmployee4 = new SkillEmployeeRating(8, skillBlockchain, employeeMischa);
        SkillEmployeeRating skillRatingEmployee51 = new SkillEmployeeRating(6, skillJava, employeeNicolas);
        SkillEmployeeRating skillRatingEmployee5 = new SkillEmployeeRating(8, skillOracleDB, employeeNicolas);
        SkillEmployeeRating skillRatingEmployee61 = new SkillEmployeeRating(5, skillReact, employeeOliver);
        SkillEmployeeRating skillRatingEmployee6 = new SkillEmployeeRating(9, skillJava, employeeOliver);
        SkillEmployeeRating skillRatingEmployee7 = new SkillEmployeeRating(6, skillJava, employeeValentino);
        SkillEmployeeRating skillRatingEmployee71 = new SkillEmployeeRating(3, skillBlockchain, employeeValentino);
        SkillEmployeeRating skillRatingEmployee8 = new SkillEmployeeRating(3, skillJava, employeeJunior);
        SkillEmployeeRating skillRatingEmployee9 = new SkillEmployeeRating(5, skillJava, employeeMarkus);
        SkillEmployeeRating skillRatingEmployee10 = new SkillEmployeeRating(2, skillReact, employeePhilipp);
        SkillEmployeeRating skillRatingEmployee11 = new SkillEmployeeRating(9, skillBlockchain, employeePhilipp);
        SkillEmployeeRating skillRatingEmployee12 = new SkillEmployeeRating(4, skillJava, employeePhilipp);
        SkillEmployeeRating skillRatingEmployee13 = new SkillEmployeeRating(7, skillJava, employeeJames);
        SkillEmployeeRating skillRatingEmployee14 = new SkillEmployeeRating(2, skillJava, employeeDaniela);
        SkillEmployeeRating skillRatingEmployee15 = new SkillEmployeeRating(9, skillJava, employeeThomas);
        SkillEmployeeRating skillRatingEmployee16 = new SkillEmployeeRating(6, skillJava, employeeFred);
        SkillEmployeeRating skillRatingEmployee17 = new SkillEmployeeRating(2, skillCSharp, employeeAndreas);
        SkillEmployeeRating skillRatingEmployee18 = new SkillEmployeeRating(2, skillCSharp, employeeBrigitte);
        SkillEmployeeRating skillRatingEmployee19 = new SkillEmployeeRating(1, skillCSharp, employeeClaudia);
        SkillEmployeeRating skillRatingEmployee20 = new SkillEmployeeRating(8, skillJava, employeeAndreas);
        SkillEmployeeRating skillRatingEmployee21 = new SkillEmployeeRating(6, skillJava, employeeBrigitte);
        SkillEmployeeRating skillRatingEmployee22 = new SkillEmployeeRating(4, skillJava, employeeClaudia);
        SkillEmployeeRating skillEmployeeRatingGreen1 = new SkillEmployeeRating(8, skillJava, employeeGreen1);
        SkillEmployeeRating skillEmployeeRatingGreen2 = new SkillEmployeeRating(8, skillJava, employeeGreen2);
        SkillEmployeeRating skillEmployeeRatingGreen3 = new SkillEmployeeRating(8, skillJava, employeeGreen3);
        SkillEmployeeRating skillEmployeeRatingRed1 = new SkillEmployeeRating(8, skillJava, employeeRed1);
        SkillEmployeeRating skillEmployeeRatingRed2 = new SkillEmployeeRating(8, skillJava, employeeRed2);
        SkillEmployeeRating skillEmployeeRatingRed3 = new SkillEmployeeRating(8, skillJava, employeeRed3);
        SkillEmployeeRating skillEmployeeRatingRed4 = new SkillEmployeeRating(8, skillCSharp, employeeRed1);
        SkillEmployeeRating skillEmployeeRatingRed5 = new SkillEmployeeRating(4, skillCSharp, employeeRed2);
        SkillEmployeeRating skillEmployeeRatingRed6 = new SkillEmployeeRating(2, skillCSharp, employeeRed3);
        SkillEmployeeRating skillEmployeeRatingRed7 = new SkillEmployeeRating(10, skillBlockchain, employeeRed1);
        SkillEmployeeRating skillEmployeeRatingRed8 = new SkillEmployeeRating(2, skillBlockchain, employeeRed1);
        SkillEmployeeRating skillEmployeeRatingRed9 = new SkillEmployeeRating(1, skillBlockchain, employeeRed1);

        addAll(skillTeamRatingDAO, skillRatingTeam1, skillRatingTeam2, skillRatingTeam3, skillRatingTeam4, skillRatingTeam5, skillRatingTeam6, skillRatingTeam7, skillTeamRating8, skillTeamRating9, skillTeamRating10, skillTeamRating11, skillTeamRating12, skillTeamRating13);
        addAll(skillEmployeeRatingDAO, skillRatingEmployee1, skillRatingEmployee2, skillRatingEmployee3, skillRatingEmployee4, skillRatingEmployee5, skillRatingEmployee6, skillRatingEmployee7, skillRatingEmployee8, skillRatingEmployee9, skillRatingEmployee10, skillRatingEmployee11, skillRatingEmployee12, skillRatingEmployee13, skillRatingEmployee14, skillRatingEmployee15, skillRatingEmployee16, skillRatingEmployee17, skillRatingEmployee18, skillRatingEmployee19, skillRatingEmployee20, skillRatingEmployee21, skillRatingEmployee22, skillEmployeeRatingGreen1, skillEmployeeRatingGreen2, skillEmployeeRatingGreen3, skillEmployeeRatingRed1, skillEmployeeRatingRed2, skillEmployeeRatingRed3, skillEmployeeRatingRed4, skillEmployeeRatingRed5, skillEmployeeRatingRed6, skillEmployeeRatingRed7, skillEmployeeRatingRed8, skillEmployeeRatingRed9, skillRatingEmployee41, skillRatingEmployee51, skillRatingEmployee61, skillRatingEmployee71);
    }

    @SafeVarargs
    private final <T> void addAll(IGenericDAO<T> dao, T... objects) {
        Arrays.asList(objects).forEach(dao::add);
    }

}
