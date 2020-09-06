package com.dunzo.assignment.repository;

import com.dunzo.assignment.model.Ingredient;
import com.dunzo.assignment.model.Quatity;
import com.dunzo.assignment.repository.BeveragesRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BeveragesRepositoryTest {

   ConcurrentHashMap<Ingredient, Quatity> input;
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
    }


    @Test
    public void testAddIngrediant() {
        int initialSize = beveragesRepository.currentRepository().size();


        beveragesRepository.addIngredient(Ingredient.CoffeeSyrup,new Quatity(200,Ingredient.CoffeeSyrup.getUnit()));

        int afterAddingSize = beveragesRepository.currentRepository().size();

        Assert.assertEquals((initialSize+1),afterAddingSize);

        Assert.assertEquals(new Quatity(200,Ingredient.CoffeeSyrup.getUnit()).getValue(),beveragesRepository.currentRepository().get(Ingredient.CoffeeSyrup).getValue(),0.0);

    }

    @Test
    public void testdeductIngrediant() {
        beveragesRepository.deductIngredient(Ingredient.SugarSyrup,new Quatity(200,Ingredient.CoffeeSyrup.getUnit()));
        Assert.assertEquals(0.0,input.get(Ingredient.SugarSyrup).getValue(),0.0);
    }


    @Test
    public void testGetIngrediant() {
        Map<Ingredient, Quatity> ingredientQuatityMap = new HashMap<Ingredient, Quatity>();
        ingredientQuatityMap.put(Ingredient.Hotmilk,new Quatity(200, Ingredient.SugarSyrup.getUnit()));

        Assert.assertEquals(true,beveragesRepository.getIngredient(ingredientQuatityMap));

        Assert.assertEquals(false,beveragesRepository.getIngredient(ingredientQuatityMap));
    }


}
