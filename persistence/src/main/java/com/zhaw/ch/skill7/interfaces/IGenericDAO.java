package com.zhaw.ch.skill7.interfaces;

import java.util.List;
import java.util.Optional;

public interface IGenericDAO<T> {

    /**
     * Liest eine Liste aller Objekte T aus der Datenbank
     *
     * @return
     */
    List<T> read();

    /**
     * Liest ein einzelnes Objekt T von der Datenbank anhand deren ID
     *
     * @param id ID des zu landenden Objekts
     * @return Optional des gesuchten Objekt. Dieses beinhaltet das gesuchte Objekt oder Optional.empty(), falls das Objekt anhand der ID nicht gefunden wurde in der Datenbank
     */
    Optional<T> byId(long id);

    /**
     * Fügt ein Objekt T der Datenbank hinzu
     *
     * @param object Objekt, dass in die Datenbank gespeichert wird
     */
    void add(T object);

    /**
     * Löscht ein Objekt T aus der Datenbank
     * @param object Objekt, dass gelöscht werden soll
     */
    void remove(T object);

    /**
     * Führt einen Update auf ein Objekt T in der Datenbank durch
     * @param object Objekt, welches updated werden soll
     */
    void update(T object);

}
