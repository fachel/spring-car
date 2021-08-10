package com.belov.spring.car.spring_car.repo;

import com.belov.spring.car.spring_car.entity.Car;
import com.belov.spring.car.spring_car.entity.Complectation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    public Car getByModel(String name);
}
