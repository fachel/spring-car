package com.belov.spring.car.spring_car.service;

import com.belov.spring.car.spring_car.entity.Car;
import com.belov.spring.car.spring_car.entity.Complectation;

import java.util.List;

public interface ComplectationService{
    public List<Complectation> getAllComplectations();
    public Complectation getComplectationById(int id);
    public Complectation getComplectationByName(String name);
    public void deleteComplectationById(int id);
    public void saveComplectation(Complectation complectation);
}
