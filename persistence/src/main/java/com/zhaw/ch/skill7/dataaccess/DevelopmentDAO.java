package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IDevelopmentDAO;
import com.zhaw.ch.skill7.model.Development;

import java.util.ArrayList;
import java.util.List;

public class DevelopmentDAO implements IDevelopmentDAO {

    private int currentId = 1;

    private List<Development> developmentDatabase = new ArrayList<>();

    @Override
    public List<Development> readDevelopments() {
        return developmentDatabase;
    }

    @Override
    public void addDevelopment(Development development) {
        development.setId(currentId++);
        developmentDatabase.add(development);
    }

    @Override
    public void removeDevelopment(Development development) {
        developmentDatabase.remove(development);
    }

    @Override
    public void updateDevelopment(Development development) {
        for (Development currentDevelopment : developmentDatabase) {
            if (currentDevelopment.getId() == development.getId()) {
                currentDevelopment.setDevelopmentRating(development.getDevelopmentRating());
            }
        }
    }
}
