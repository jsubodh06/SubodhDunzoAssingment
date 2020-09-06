package com.dunzo.assignment.serviceimpl;

import com.dunzo.assignment.model.Beverage;
import com.dunzo.assignment.repository.BeveragesRepository;

/**
 * This class is responsible for ro check if Beverage can be prepared or not
 * if yes update the remaining ingredient count
 * if no generete a message
 * created by Subodh Jain
 * date :- 06-sept-2020
 */
public class BeveragesService implements Runnable{
    private BeveragesRepository beveragesRepository;

    private Beverage beverage;

    public BeveragesService(BeveragesRepository beveragesRepository) {
        this.beveragesRepository = beveragesRepository;
    }

    public Beverage getBeverage() {
        return beverage;
    }

    /**
     * This method will check whether Beverage can be prepare or not
     * if can prepared update the remaining of ingredients also
     * @return
     * @throws InterruptedException
     */
    public boolean perpareBeverage() throws InterruptedException {
        Thread.sleep(1000);
        boolean ready = beveragesRepository.getIngredient(beverage.getIngredients());
        if(ready){
            System.out.println(beverage.getName() + " is ready");
        }else{
            System.out.println("Ingredent are not available for the preparation of " + beverage.getName() +" Please refill the machine");
        }
        return ready;
    }


    public void setBerverage(Beverage beverage) {
        this.beverage = beverage;
    }

    public void run() {
        try {
            System.out.println("Waiting for outlet");
            perpareBeverage();
        } catch (InterruptedException e) {
            System.out.println("Machine not working. Need maintainance");
        }
    }

}
