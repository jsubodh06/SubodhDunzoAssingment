package com.dunzo.assignment;


import com.dunzo.assignment.constant.Constants;
import com.dunzo.assignment.exception.IngredientNotAvailableException;
import com.dunzo.assignment.model.BerveragesName;
import com.dunzo.assignment.model.Ingredient;
import com.dunzo.assignment.repository.BeveragesRepository;
import com.dunzo.assignment.service.Service;
import com.dunzo.assignment.serviceimpl.BeveragesFactory;
import com.dunzo.assignment.serviceimpl.ServiceImpl;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *  Beverages Machine which takes N oulets at a time and serve accoridingly
 */
public class DunzoCoffeeeMachineApplication {

    public static void main(String[] args) throws IngredientNotAvailableException {

        Service service = new ServiceImpl();

        BeveragesRepository beveragesRepository =  service.setUpIngredientsRepository();

        initiateAlertSystem(beveragesRepository);

        executeMachineAsync(beveragesRepository,service);

    }

    /**
     * excute N machine at a time
     * @throws IngredientNotAvailableException
     */
    private static void executeMachineAsync(BeveragesRepository beveragesRepository,Service service) throws IngredientNotAvailableException {

        ExecutorService executorService = getExecutorServiceInitialize();
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.GREEN_TEA.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.BLACK_TEA.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.HOT_TEA.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.HOT_COFFEE.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.GREEN_TEA.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.BLACK_TEA.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.HOT_TEA.name())));
        executorService.execute(service.getBeveragesService(beveragesRepository, BeveragesFactory.getBeverage(BerveragesName.HOT_COFFEE.name())));
    }

    /**
     * initialization for outlets
     * @return
     */
    private static ExecutorService getExecutorServiceInitialize(){
        return Executors.newFixedThreadPool(Constants.NUMBER_OF_OUTLETS);
    }

    /**
     *  Initalize alert system which will get trigger when any ingredient is below minimum threshold
     * @param beveragesRepository
     */
    public static  void initiateAlertSystem(final BeveragesRepository beveragesRepository) {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                while(true){
                    try {
                        currentStatusOfRepository(beveragesRepository);
                    } catch (InterruptedException e) {
                        System.out.println("Alert not working");
                    }
                }
            }
        });
        t1.start();
    }



    /**
     *  check current status of machine ingredients and notify if any ingredient is lesser than minimum threshold value
     * @throws InterruptedException
     */
    private static void currentStatusOfRepository(BeveragesRepository beveragesRepository) throws InterruptedException{
        for (Ingredient ingredient : beveragesRepository.currentRepository().keySet()) {
            if(beveragesRepository.currentRepository().get(ingredient).getValue() < ingredient.getMinThresholdValue()){
                System.out.println(ingredient.name() + " is below threshold " + ingredient.getMinThresholdValue());

            }
        }
        Thread.sleep(5000); // every 5 seconds check of status
    }

}
