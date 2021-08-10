package com.belov.spring.car.spring_car.service;

import com.belov.spring.car.spring_car.entity.Complectation;
import com.belov.spring.car.spring_car.repo.ComplectationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplectationImpl implements ComplectationService {

    @Autowired
    private ComplectationRepository complectationRepo;

    @Override
    public List<Complectation> getAllComplectations() {
        return complectationRepo.findAll();
    }

    @Override
    public Complectation getComplectationById(int id) {
        return complectationRepo.getById(id);
    }

    @Override
    public Complectation getComplectationByName(String name) {
        return complectationRepo.getComplectationByName(name);
    }

    @Override
    public void deleteComplectationById(int id) {
        complectationRepo.deleteById(id);
    }

    @Override
    public void saveComplectation(Complectation complectation) {
        complectationRepo.save(complectation);
    }
}
