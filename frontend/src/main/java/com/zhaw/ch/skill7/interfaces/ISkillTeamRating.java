package com.zhaw.ch.skill7.interfaces;

/**
 *  Ein Objekt, das die Resultat der Bewertung eines Skills enthält.
 */
public interface ISkillTeamRating {

    /**
     * Gibt den bewerteten Skill zurück.
     *
     * @return der bewertete Skill
     */
    String getSkill();

    /**
     * Gibt erhaltene Rating des bewerteten Skills zurück.
     *
     * @return die erhaltene Bewertung des Skills
     */
    int getActualRating();

    /**
     * Gibt benötigtes Rating des Skills zurück.
     *
     * @return das benötigte Rating des SKills.
     */
    int getRequiredRating();

    /**
     * Gibt erhaltenen Status der Bewertung zurück.
     *
     * @return der erhaltene Status des Skills.
     */
    String getSemaphore();
}
