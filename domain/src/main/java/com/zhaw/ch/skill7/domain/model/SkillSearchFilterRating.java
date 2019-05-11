package com.zhaw.ch.skill7.domain.model;

/**
 * Die Klasse SkillSearchFilterRating referenziert einen Skill inkl. Rating zu einem Suchfilter/SearchFilter
 */
public class SkillSearchFilterRating extends SkillRating{

    private SearchFilter searchFilter;

    public SkillSearchFilterRating(int rating, Skill skill, SearchFilter searchFilter){
        super(rating, skill);
        this.searchFilter = searchFilter;
    }

    public SearchFilter getSearchFilter() {
        return searchFilter;
    }

    public void setSearchFilter(SearchFilter searchFilter) {
        this.searchFilter = searchFilter;
    }
}
