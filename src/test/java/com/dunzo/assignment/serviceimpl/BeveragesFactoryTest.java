package com.dunzo.assignment.serviceimpl;


import com.dunzo.assignment.exception.IngredientNotAvailableException;
import com.dunzo.assignment.model.*;
import org.junit.Assert;
import org.junit.Test;

public class BeveragesFactoryTest {

    @Test
    public void testBeverageInFactory() throws IngredientNotAvailableException {
        Assert.assertEquals(BlackTea.class, BeveragesFactory.getBeverage(BerveragesName.HOT_TEA.name()).getClass());
        Assert.assertEquals(HotTea.class, BeveragesFactory.getBeverage(BerveragesName.BLACK_TEA.name()).getClass());
        Assert.assertEquals(HotCoffee.class, BeveragesFactory.getBeverage(BerveragesName.HOT_COFFEE.name()).getClass());
    }

    @Test(expected = IngredientNotAvailableException.class)
    public void testBeverageNotPresentInFactory() throws IngredientNotAvailableException {
        BeveragesFactory.getBeverage("MilkShake");
    }

    @Test
    public void testAddingNewBeveragesInFactory() throws IngredientNotAvailableException{
        BeveragesFactory.addBeverage(BerveragesName.GREEN_TEA.name(), new GreenTea(BerveragesName.GREEN_TEA.name()));
        Assert.assertEquals(GreenTea.class, BeveragesFactory.getBeverage(BerveragesName.GREEN_TEA.name()).getClass());
    }

}