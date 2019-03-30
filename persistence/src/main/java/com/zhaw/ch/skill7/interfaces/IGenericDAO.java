package com.zhaw.ch.skill7.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T> {

    List<T> read();

    Optional<T> byId(long id);

    void add(T object);

    void remove(T object);

    void update(T object);

}
