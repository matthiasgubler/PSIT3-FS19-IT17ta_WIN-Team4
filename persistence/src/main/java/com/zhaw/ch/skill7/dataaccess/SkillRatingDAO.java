package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.ISkillRatingDAO;
import com.zhaw.ch.skill7.model.SkillRating;

import java.util.ArrayList;
import java.util.List;

public class SkillRatingDAO implements ISkillRatingDAO {

    private int currentId = 1;

    private List<SkillRating> skillRatingsDatabase = new ArrayList<>();

    public SkillRatingDAO() {

    }

    @Override
    public List<SkillRating> readSkillRatings() {
        return skillRatingsDatabase;
    }

    @Override
    public void addSkillRating(SkillRating skillRating) {
        skillRating.setId(currentId++);
        skillRatingsDatabase.add(skillRating);
    }

    @Override
    public void removeSkillRating(SkillRating skillRating) {
        skillRatingsDatabase.remove(skillRating);
    }

    @Override
    public void updateSkillRating(SkillRating skillRating) {
        for (SkillRating currentSkillRating : skillRatingsDatabase) {
            if (currentSkillRating.getId() == skillRating.getId()) {
                currentSkillRating.setRating(skillRating.getRating());
            }
        }
    }
}
