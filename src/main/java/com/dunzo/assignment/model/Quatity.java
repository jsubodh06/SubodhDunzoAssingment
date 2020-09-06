package com.dunzo.assignment.model;

/**
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public class Quatity {
    private float value;
    private Unit unit;

    public Quatity(float value, Unit unit) {
        this.value = value;
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }
}
