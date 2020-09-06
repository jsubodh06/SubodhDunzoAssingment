package com.dunzo.assignment.model;

import java.util.Map;

/**
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public abstract class Beverage {
    private String name;


    public Beverage(String name) {
        this.name = name;
    }

    public abstract Map<Ingredient, Quatity> getIngredients();

    public String getName() {
        return name;
    }


}
