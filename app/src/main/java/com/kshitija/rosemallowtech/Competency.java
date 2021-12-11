package com.kshitija.rosemallowtech;

public class Competency {

    String name;
    String category;
    int rating = -1;
    int selected = -1;

    public Competency(String name, String category, int rating, int selected) {
        this.name = name;
        this.category = category;
        this.rating = rating;
        this.selected = selected;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getSelected() {
        return selected;
    }

    public void setSelected(int selected) {
        this.selected = selected;
    }

}
