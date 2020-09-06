package com.dunzo.assignment.serviceimpl;

import com.dunzo.assignment.model.Beverage;
import com.dunzo.assignment.model.Ingredient;
import com.dunzo.assignment.model.Quatity;
import com.dunzo.assignment.repository.BeveragesRepository;
import com.dunzo.assignment.service.Service;

import java.util.concurrent.ConcurrentHashMap;



/**
 * This calls is responsivle for creating repository setup and all the communcation with repository
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public class ServiceImpl implements Service {

    BeveragesRepository beveragesRepository;

    public BeveragesRepository setUpIngredientsRepository() {
        beveragesRepository = new BeveragesRepository(getIngredent());
        return beveragesRepository;
    }

    private  ConcurrentHashMap<Ingredient, Quatity> getIngredent() {

        ConcurrentHashMap<Ingredient, Quatity> input =  new ConcurrentHashMap<Ingredient, Quatity>();
        input.put(Ingredient.Hotmilk, new Quatity(200, Ingredient.Hotmilk.getUnit()));
        input.put(Ingredient.HotWater, new Quatity(200, Ingredient.HotWater.getUnit()));
        input.put(Ingredient.TeaLeavesSyrup, new Quatity(200, Ingredient.TeaLeavesSyrup.getUnit()));
        input.put(Ingredient.GingerSyrup, new Quatity(200, Ingredient.GingerSyrup.getUnit()));
        input.put(Ingredient.SugarSyrup, new Quatity(200, Ingredient.SugarSyrup.getUnit()));
        return input;
    }

    /**
     *  This method will intialize the Beverage with need to be worked around
     * @param ingredientRepository
     * @param beverage
     * @return
     */
    public BeveragesService getBeveragesService(BeveragesRepository ingredientRepository, Beverage beverage) {
        BeveragesService beveragesService = new BeveragesService(ingredientRepository);
        beveragesService.setBerverage(beverage);
        return beveragesService;
    }

}
