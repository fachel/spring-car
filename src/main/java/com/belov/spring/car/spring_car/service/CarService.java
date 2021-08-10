package com.belov.spring.car.spring_car.service;

import com.belov.spring.car.spring_car.entity.Car;
import com.belov.spring.car.spring_car.entity.Complectation;

import java.util.List;

public interface CarService{
    public Car getCarById(int id);
    public void deleteCarById(int id);
    public void saveCar(Car car);
    public List<Car> getAllCars();
    public Car getCar(String name);
}
