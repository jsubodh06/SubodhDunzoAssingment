package com.dunzo.assignment.serviceimpl;


import com.dunzo.assignment.repository.BeveragesRepository;
import com.dunzo.assignment.exception.IngredientNotAvailableException;
import com.dunzo.assignment.model.BerveragesName;
import com.dunzo.assignment.model.Ingredient;
import com.dunzo.assignment.model.Quatity;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

public class BeverageServiceTest {

    private static BeveragesService beverageService ;

    @Before
    public void setUp() {
        ConcurrentHashMap<Ingredient, Quatity> input = new ConcurrentHashMap();
        input.put(Ingredient.Hotmilk, new Quatity(300f, Ingredient.Hotmilk.getUnit()));
        input.put(Ingredient.HotWater, new Quatity(300f, Ingredient.HotWater.getUnit()));
        input.put(Ingredient.TeaLeavesSyrup, new Quatity(300f, Ingredient.TeaLeavesSyrup.getUnit()));
        input.put(Ingredient.GingerSyrup, new Quatity(300f, Ingredient.GingerSyrup.getUnit()));
        input.put(Ingredient.SugarSyrup, new Quatity(300f, Ingredient.SugarSyrup.getUnit()));
        input.put(Ingredient.CoffeeSyrup, new Quatity(300f, Ingredient.CoffeeSyrup.getUnit()));
        BeveragesRepository ingredientRepository = new BeveragesRepository(input);
        beverageService = new BeveragesService(ingredientRepository);
    }

    @Test
    public void testBeverageServiceIsMaking() throws IngredientNotAvailableException,InterruptedException {
        beverageService.setBerverage(BeveragesFactory.getBeverage(BerveragesName.BLACK_TEA.name()));
        Assert.assertEquals(true, beverageService.perpareBeverage());
    }

    @Test(expected = IngredientNotAvailableException.class)
    public void testBeverageServiceIsNotAvailable() throws IngredientNotAvailableException,InterruptedException {
        beverageService.setBerverage(BeveragesFactory.getBeverage("MilkShake"));
        Assert.assertEquals(true, beverageService.perpareBeverage());
    }

    @Test()
    public void testBeverageQuantityNotAvailable() throws IngredientNotAvailableException,InterruptedException {
        beverageService.setBerverage(BeveragesFactory.getBeverage(BerveragesName.GREEN_TEA.name()));
        Assert.assertEquals(false, beverageService.perpareBeverage());
        beverageService.setBerverage(BeveragesFactory.getBeverage(BerveragesName.HOT_COFFEE.name()));
        Assert.assertEquals(false, beverageService.perpareBeverage());
        beverageService.setBerverage(BeveragesFactory.getBeverage(BerveragesName.BLACK_TEA.name()));
        Assert.assertEquals(true, beverageService.perpareBeverage());
        beverageService.setBerverage(BeveragesFactory.getBeverage(BerveragesName.HOT_TEA.name()));
        Assert.assertEquals(false, beverageService.perpareBeverage());
        beverageService.setBerverage(BeveragesFactory.getBeverage(BerveragesName.GREEN_TEA.name()));
        Assert.assertEquals(false, beverageService.perpareBeverage());
    }
}