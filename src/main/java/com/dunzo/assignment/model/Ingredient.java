package com.dunzo.assignment.model;

/**
 * created by Subodh Jain
 * date :- 06-sept-2020
 * Ingredient enum to add new Beverages.
 */

public enum Ingredient {
    Hotmilk(Unit.ml,100.0f),
    HotWater(Unit.ml,100.0f),
    TeaLeavesSyrup(Unit.ml,100.0f),
    GingerSyrup(Unit.ml,10.0f),
    SugarSyrup(Unit.ml,10.0f),
    CoffeeSyrup(Unit.ml,100.0f),
    GreenMixture(Unit.ml,30f);

    private Unit unit;

    private Float minThresholdValue;

    Ingredient(Unit unit, Float minThresholdValue) {
        this.unit = unit;
        this.minThresholdValue = minThresholdValue;
    }

    public Unit getUnit () {
        return this.unit;
    }

    public float getMinThresholdValue() {
        return minThresholdValue;
    }
}


