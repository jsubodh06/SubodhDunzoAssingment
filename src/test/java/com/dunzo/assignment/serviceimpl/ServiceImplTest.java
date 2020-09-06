package com.dunzo.assignment.serviceimpl;


import com.dunzo.assignment.exception.IngredientNotAvailableException;
import com.dunzo.assignment.model.BerveragesName;
import com.dunzo.assignment.model.Ingredient;
import com.dunzo.assignment.model.Quatity;
import com.dunzo.assignment.repository.BeveragesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class ServiceImplTest {

    ConcurrentHashMap<Ingredient, Quatity> input;
    ServiceImpl service;
    BeveragesRepository beveragesRepository;

    @Before
    public void setup(){
        input =  new ConcurrentHashMap<Ingredient, Quatity>();
        input.put(Ingredient.Hotmilk, new Quatity(200, Ingredient.Hotmilk.getUnit()));
        input.put(Ingredient.HotWater, new Quatity(200, Ingredient.HotWater.getUnit()));
        input.put(Ingredient.TeaLeavesSyrup, new Quatity(200, Ingredient.TeaLeavesSyrup.getUnit()));
        input.put(Ingredient.GingerSyrup, new Quatity(200, Ingredient.GingerSyrup.getUnit()));
        input.put(Ingredient.SugarSyrup, new Quatity(200, Ingredient.SugarSyrup.getUnit()));

        beveragesRepository = new BeveragesRepository(input);

        service = new ServiceImpl();
    }

    @Test
    public void testSetUpIngredientsRepository(){
        BeveragesRepository beveragesRepositoryTemp = service.setUpIngredientsRepository();

        Assert.assertEquals(beveragesRepositoryTemp.currentRepository().size(),beveragesRepository.currentRepository().size());
    }


    @Test
    public void testGetBeveragesService() throws IngredientNotAvailableException {
        BeveragesService beveragesService =  service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.HOT_COFFEE.name()));
        Assert.assertEquals(beveragesService.getBeverage().getName(),BeveragesFactory.getBeverage(BerveragesName.HOT_COFFEE.name()).getName());
    }



}
