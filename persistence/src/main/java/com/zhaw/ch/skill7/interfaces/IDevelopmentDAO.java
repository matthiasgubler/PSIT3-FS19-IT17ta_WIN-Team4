package com.zhaw.ch.skill7.interfaces;

import com.zhaw.ch.skill7.model.Development;

import java.util.List;

public interface IDevelopmentDAO {

    List<Development> readDevelopments();

    void addDevelopment(Development development);

    void removeDevelopment(Development development);

    void updateDevelopment(Development development);

}
