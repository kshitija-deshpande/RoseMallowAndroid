package com.kshitija.rosemallowtech;

import java.util.ArrayList;
import java.util.List;

public class CompetencyManager {

    private static CompetencyManager sCompetencyManager;

    private List<Competency> competencyList;

    public static CompetencyManager getsCompetencyManager() {
        if (sCompetencyManager == null) {
            sCompetencyManager = new CompetencyManager();
        }
        return sCompetencyManager;
    }

    private CompetencyManager() {
        competencyList = new ArrayList<>();
        initCompetencies();
    }

    private void initCompetencies() {
        competencyList.add(new Competency("Transparent Communication", "Ownership", -1, -1));
        competencyList.add(new Competency("Service Delivery", "Ownership", -1, -1));
        competencyList.add(new Competency("Accountability", "Ownership", -1, -1));

        competencyList.add(new Competency("Planning", "Innovation", -1, -1));
        competencyList.add(new Competency("Brain Stroming", "Innovation", -1, -1));
        competencyList.add(new Competency("Ideation", "Innovation", -1, -1));

        competencyList.add(new Competency("Express Gratitude", "Trust & Integrity", -1, -1));
        competencyList.add(new Competency("Value Honesty", "Trust & Integrity", -1, -1));
        competencyList.add(new Competency("Reliable", "Trust & Integrity", -1, -1));
    }

    public List<Competency> getCompetencyList() {
        return competencyList;
    }

    //Needed for undo button
    public void clearRatingAndSelection() {
        for (int i = 0; i < competencyList.size(); i++) {
            competencyList.get(i).selected = -1;
            competencyList.get(i).rating = -1;
        }
    }

    //Needed for undo button
    public void clearRating() {
        for (int i = 0; i < competencyList.size(); i++) {
            competencyList.get(i).rating = -1;
        }
    }

}
