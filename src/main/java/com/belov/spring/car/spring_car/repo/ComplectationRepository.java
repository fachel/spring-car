package com.belov.spring.car.spring_car.repo;

import com.belov.spring.car.spring_car.entity.Complectation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ComplectationRepository extends JpaRepository<Complectation, Integer> {
    public Complectation getComplectationByName(String name);
}
