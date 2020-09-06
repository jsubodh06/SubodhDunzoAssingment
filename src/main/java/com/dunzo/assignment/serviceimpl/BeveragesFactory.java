package com.dunzo.assignment.serviceimpl;

import com.dunzo.assignment.exception.IngredientNotAvailableException;
import com.dunzo.assignment.model.*;

import java.util.HashMap;
/**
 *
 * created by Subodh Jain
 * date :- 06-sept-2020
 * Beverages Factory provide objects of all beverages available in machine.
 */
public class BeveragesFactory {
    private static HashMap<String, Beverage> factory;

    static
    {
        factory = new HashMap<String, Beverage>();
        factory.put(BerveragesName.HOT_COFFEE.name(), new BlackTea(BerveragesName.HOT_COFFEE.name()));
        factory.put(BerveragesName.HOT_TEA.name(), new BlackTea(BerveragesName.HOT_TEA.name()));
        factory.put(BerveragesName.BLACK_TEA.name(), new HotTea(BerveragesName.BLACK_TEA.name()));
        factory.put(BerveragesName.HOT_COFFEE.name(), new HotCoffee(BerveragesName.HOT_COFFEE.name()));
        factory.put(BerveragesName.GREEN_TEA.name(), new GreenTea(BerveragesName.GREEN_TEA.name()));
    }

    /**
     *  This method will check that request beverage is served by machine or not
     * @param beverageName
     * @return
     * @throws IngredientNotAvailableException
     */
    public static Beverage getBeverage(String beverageName) throws IngredientNotAvailableException {
        if(factory.containsKey(beverageName)){
            return factory.get(beverageName);
        }else{
            throw new IngredientNotAvailableException(beverageName + " not present in machine");
        }
    }


    /**
     *  This method will add new Beverage to machine
     * @param beverageName
     * @param beverage
     */
    public static void addBeverage(String beverageName, Beverage beverage){
        factory.put(beverageName,beverage);
    }
}
