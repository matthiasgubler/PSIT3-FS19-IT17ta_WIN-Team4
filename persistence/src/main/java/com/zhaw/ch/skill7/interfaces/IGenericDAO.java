package com.zhaw.ch.skill7.interfaces;

import java.util.List;

public interface IGenericDAO<T> {

    List<T> read();

    void add(T object);

    void remove(T object);

    void update(T object);

}
