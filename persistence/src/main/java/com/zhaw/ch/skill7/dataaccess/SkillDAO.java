package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.ISkillDAO;
import com.zhaw.ch.skill7.model.Skill;

import java.util.ArrayList;
import java.util.List;

public class SkillDAO implements ISkillDAO {

    private int currentId = 1;

    private List<Skill> skillsDatabase = new ArrayList<>();

    public SkillDAO() {
        initializeDatabase();
    }

    private void initializeDatabase() {
        addSkill(new Skill("React"));
        addSkill(new Skill("Java"));
        addSkill(new Skill("Blockchain"));
        addSkill(new Skill("Oracle"));
        addSkill(new Skill("Microservice"));
    }

    @Override
    public List<Skill> readSkills() {
        return skillsDatabase;
    }

    @Override
    public void addSkill(Skill skill) {
        skill.setId(currentId++);
        skillsDatabase.add(skill);
    }

    @Override
    public void removeSkill(Skill skill) {
        skillsDatabase.remove(skill);
    }

    @Override
    public void updateSkill(Skill skill) {
        for (Skill currentSkill : skillsDatabase) {
            if (currentSkill.getId() == skill.getId()) {
                currentSkill.setName(skill.getName());
            }

        }
    }
}
