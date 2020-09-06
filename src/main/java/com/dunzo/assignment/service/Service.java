package com.dunzo.assignment.service;

import com.dunzo.assignment.model.Beverage;
import com.dunzo.assignment.repository.BeveragesRepository;
import com.dunzo.assignment.serviceimpl.BeveragesService;

public interface Service {
    BeveragesRepository setUpIngredientsRepository();
    BeveragesService getBeveragesService(BeveragesRepository ingredientRepository, Beverage beverage);
}
