package com.belov.spring.car.spring_car.service;

import com.belov.spring.car.spring_car.entity.Car;
import com.belov.spring.car.spring_car.entity.Complectation;
import com.belov.spring.car.spring_car.repo.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    private CarRepository carRepository;

    @Override
    public Car getCarById(int id) {
        return carRepository.getById(id);
    }

    @Override
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }

    @Override
    public void saveCar(Car car) {
        carRepository.save(car);
    }

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCar(String name) {
        return carRepository.getByModel(name);
    }
}
