package com.dunzo.assignment.model;

import java.util.HashMap;
import java.util.Map;
/**
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public class GreenTea extends Beverage {


    public GreenTea(String name) {
        super(name);
    }

    @Override
    public Map<Ingredient, Quatity> getIngredients() {
        Map<Ingredient, Quatity> ingredientQuatityMap = new HashMap<Ingredient, Quatity>();
        ingredientQuatityMap.put(Ingredient.HotWater, new Quatity(100.0f, Ingredient.HotWater.getUnit()));
        ingredientQuatityMap.put(Ingredient.GreenMixture, new Quatity(30f, Ingredient.GreenMixture.getUnit()));
        ingredientQuatityMap.put(Ingredient.GingerSyrup, new Quatity(30.0f, Ingredient.GingerSyrup.getUnit()));
        ingredientQuatityMap.put(Ingredient.SugarSyrup, new Quatity(50f, Ingredient.SugarSyrup.getUnit()));
        return ingredientQuatityMap;
    }
}
