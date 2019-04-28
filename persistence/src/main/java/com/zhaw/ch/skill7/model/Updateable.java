package com.zhaw.ch.skill7.model;

/**
 * Interface eines Objekt welches Updateable / Updatebar ist
 *
 * @param <T> Typ des updatbaren Objekt
 */
public interface Updateable<T> {

    /**
     * Führt eine Update auf ein Objekt durch durch ein weiteres Objekt
     * @param objectWithNewData Objekt mit den neuen Daten, die auf das Updateable Objekt übernommen werden
     */
    void update(T objectWithNewData);
}
