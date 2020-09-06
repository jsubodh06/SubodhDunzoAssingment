package com.dunzo.assignment.repository;

import com.dunzo.assignment.model.Ingredient;
import com.dunzo.assignment.model.Quatity;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * This class is reposiortu for the Beverage Machine
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public class BeveragesRepository {

    private ConcurrentHashMap<Ingredient, Quatity> ingredientQuatityMap;

    public BeveragesRepository(ConcurrentHashMap<Ingredient, Quatity> ingredientQuatityMap) {
        this.ingredientQuatityMap = ingredientQuatityMap;
    }

    /**
     * Add new ingrediant
     * @param ingredient
     * @param quatity
     */
    public synchronized void addIngredient(Ingredient ingredient, Quatity quatity) {
        Quatity current = ingredientQuatityMap.get(ingredient) == null ?  new Quatity(0.0f, ingredient.getUnit()) : ingredientQuatityMap.get(ingredient) ;
        ingredientQuatityMap.put(ingredient, new Quatity(current.getValue() + quatity.getValue(), ingredient.getUnit()));
        return;
    }

    /**
     * deduct ingredient
     * @param ingredient
     * @param quatity
     */
    public void deductIngredient(Ingredient ingredient, Quatity quatity) {
        Quatity current =ingredientQuatityMap.get(ingredient) == null ?  new Quatity(0.0f, ingredient.getUnit()) : ingredientQuatityMap.get(ingredient) ;
        ingredientQuatityMap.put(ingredient, new Quatity(current.getValue() - quatity.getValue(), ingredient.getUnit()));
        return;
    }


    /**
     * get ingredient
     * @param request
     * @return
     * @throws InterruptedException
     */
    public synchronized boolean getIngredient (Map<Ingredient, Quatity> request) {
        for (Ingredient ingredient : request.keySet()) {
            if (!canServe(ingredient,request.get(ingredient))) {
                return false;
            }
        }
        for (Ingredient ingredient : request.keySet()) {
            deductIngredient(ingredient, request.get(ingredient));
        }
        return true;
    }

    /**
     * check if ingredient amout is avaliable and beverage can be served
     * @param ingredient
     * @param quatity
     * @return
     */
    private boolean canServe(Ingredient ingredient, Quatity quatity) {
        if (Objects.isNull(ingredientQuatityMap.get(ingredient)) || ingredientQuatityMap.get(ingredient).getValue() < quatity.getValue()) {
            return false;
        }
        return true;
    }

    public ConcurrentHashMap<Ingredient, Quatity> currentRepository(){
        return this.ingredientQuatityMap;
    }
}
