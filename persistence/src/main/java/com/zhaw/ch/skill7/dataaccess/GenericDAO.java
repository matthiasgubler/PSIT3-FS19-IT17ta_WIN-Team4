package com.zhaw.ch.skill7.dataaccess;

import com.zhaw.ch.skill7.interfaces.IGenericDAO;
import com.zhaw.ch.skill7.model.IdUpdateableEntity;

import java.util.ArrayList;
import java.util.List;

public class GenericDAO<T extends IdUpdateableEntity<T>> implements IGenericDAO<T> {

    private int currentId = 1;

    private final List<T> objectDatabase = new ArrayList<>();


    @Override
    public List<T> read() {
        return objectDatabase;
    }

    @Override
    public void add(T object) {
        object.setId(currentId++);
        objectDatabase.add(object);
    }

    @Override
    public void remove(T object) {
        objectDatabase.remove(object);
    }

    @Override
    public void update(T object) {
        for (T currentObject : objectDatabase) {
            if (currentObject.isIdEquals(object)) {
                currentObject.update(object);
            }
        }
    }

}
