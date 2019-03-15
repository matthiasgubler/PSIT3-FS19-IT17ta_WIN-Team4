package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.SkillRating;

import java.util.List;

public interface ISkillRatingDAO {

    List<SkillRating> readSkillRatings();

    void addSkillRating(SkillRating skillRating);

    void removeSkillRating(SkillRating skillRating);

    void updateSkillRating(SkillRating skillRating);

}
