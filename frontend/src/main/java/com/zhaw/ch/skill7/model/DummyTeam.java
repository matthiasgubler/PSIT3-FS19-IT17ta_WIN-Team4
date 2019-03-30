package com.zhaw.ch.skill7.model;

import com.zhaw.ch.skill7.domain.model.Team;

import java.util.Collections;
import java.util.Map;

public class DummyTeam extends Team {
    public DummyTeam() {
        super("[TEAM AUSWÄHLEN]");
        setId(-1);
    }

    public Map<String, Long> getSkillNeeds() {
        return Collections.EMPTY_MAP;
    }
}
