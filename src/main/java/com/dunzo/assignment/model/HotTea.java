package com.dunzo.assignment.model;

import java.util.HashMap;
import java.util.Map;
/**
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public class HotTea extends Beverage {
    public HotTea(String name) {
        super(name);
    }

    @Override
    public Map<Ingredient, Quatity> getIngredients() {
        Map<Ingredient, Quatity> ingredientQuatityMap = new HashMap<Ingredient, Quatity>();

        ingredientQuatityMap.put(Ingredient.HotWater, new Quatity(200f, Ingredient.HotWater.getUnit()));
        ingredientQuatityMap.put(Ingredient.Hotmilk, new Quatity(100f, Ingredient.Hotmilk.getUnit()));
        ingredientQuatityMap.put(Ingredient.GingerSyrup, new Quatity(10.0f, Ingredient.Hotmilk.getUnit()));
        ingredientQuatityMap.put(Ingredient.TeaLeavesSyrup, new Quatity(10f, Ingredient.CoffeeSyrup.getUnit()));
        ingredientQuatityMap.put(Ingredient.SugarSyrup, new Quatity(30f, Ingredient.SugarSyrup.getUnit()));

        return ingredientQuatityMap;
    }
}
