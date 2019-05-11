package com.zhaw.ch.skill7.domain.model;

import com.zhaw.ch.skill7.helper.MathHelper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SkillTeamRating extends SkillRating {

    private Team team;
    private List<Integer> intermediateRatings;
    private Semaphore semaphore;
    private static final int SEMAPHORE_THRESHOLD = 2;
    private int actualRating;
    private boolean upToDate;

    /**
     * Konstruktor der Klasse SkillTeamRating
     *
     * @param requiredRating Benötigtes Rating für bewerteten Skill
     * @param skill          Skill der bewertet wird
     * @param team           Team dessen Skill bewertet wird
     */
    public SkillTeamRating(int requiredRating, Skill skill, Team team) {
        super(requiredRating, skill);
        this.team = team;
        this.intermediateRatings = new ArrayList<>();
        this.semaphore = Semaphore.RED;
        this.actualRating = 0;
        this.upToDate = true;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Semaphore getSemaphore() {
        return calculateSemaphore(getActualRating(), getRating());
    }

    public String getSemaphoreString() {
        return getSemaphore().toString();
    }

    public int getRequiredRating() {
        return this.getRating();
    }

    public int getActualRating(){
        Map<Skill, List<SkillEmployeeRating>> memberSkills = team.getMemberSkills();

        List<SkillEmployeeRating> specificMemberSkills;

        specificMemberSkills = memberSkills.get(this.getSkill());

        List<Integer> employeeRatings = new ArrayList<>();
        if (specificMemberSkills != null) {
            for (SkillEmployeeRating specificMemberSkill : specificMemberSkills) {
                employeeRatings.add(specificMemberSkill.getRating());
            }
        }
        return MathHelper.calculateMedian(employeeRatings);
    }

    private static Semaphore calculateSemaphore(int actualRating, int expectedRating) {
        if (actualRating >= expectedRating) {
            return Semaphore.GREEN;
        } else if (expectedRating - actualRating <= SEMAPHORE_THRESHOLD) {
            return Semaphore.YELLOW;
        } else {
            return Semaphore.RED;
        }
    }


}
