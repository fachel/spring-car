package com.belov.spring.car.spring_car.controller;

import com.belov.spring.car.spring_car.entity.Car;
import com.belov.spring.car.spring_car.entity.Complectation;
import com.belov.spring.car.spring_car.service.CarService;
import com.belov.spring.car.spring_car.service.ComplectationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Controller
public class MyController {

    @Autowired
    private CarService carService;

    @Autowired
    private ComplectationService complectationService;

    @GetMapping("/")
    public String showAllCars(Model model){
        List<Car> carList = carService.getAllCars();
        model.addAttribute("car_models", carList);
        model.addAttribute("complectation", new Complectation());
        return "index";
    }

    @GetMapping("/showComplectation/{car}")
    public String showComplectation(@PathVariable (name = "car") String car, Model model){
        List<Complectation> complectations = carService.getCar(car).getComplectationList();
        model.addAttribute("complectations", complectations);
        model.addAttribute("car", car);
        return "view_complectation";
    }

    @GetMapping("/addModel")
    public String addNewModel(Model model){
        model.addAttribute("action", "Создание модели");
        model.addAttribute("car", new Car());
        return "view_new_model";
    }

    @PostMapping("/saveModel")
    public String saveModel(@ModelAttribute ("car") Car car){
        carService.saveCar(car);
        return "redirect:/";
    }

    @GetMapping("/addNewComplectation")
    public String addNewComplectation(@RequestParam ("car_model") String car_model,  Model model){
        Car car = carService.getCar(car_model);
        List<Complectation> allComplects = complectationService.getAllComplectations();
        List<Complectation> carComplects = car.getComplectationList();
        List<Complectation> newComplects = new ArrayList<>();
        for (Complectation anyComplect: allComplects){
            if (carComplects.contains(anyComplect))
                continue;
            else
                newComplects.add(anyComplect);
        }
        model.addAttribute("complectations", newComplects);
        model.addAttribute("model", car_model);
        return "view_new_complectation";
    }

    @PostMapping("/saveNewComplectation")
    public String saveNewComplectation(@RequestParam ("model") String car_model,
                                       @RequestParam ("complectNames") List<String> listNames){
        Car car = carService.getCar(car_model);
        for (String complectName: listNames){
            car.addComplectation(complectationService.getComplectationByName(complectName));
        }
        carService.saveCar(car);

        String url = "redirect:/showComplectation/" + car_model;

        return url;
    }

    @GetMapping("/deleteComplectation")
    public String deleteComplectation(@RequestParam ("complect") String complect, @RequestParam ("car_model") String car_model){
        String url = "redirect:/showComplectation/" + car_model;
        Car car = carService.getCar(car_model);
        car.deleteComplectation(complect);
        carService.saveCar(car);
        return url;
    }

    @PostMapping("/updateComplectation")
    public String updateComplectation(@RequestParam ("complect_id") int id, @RequestParam("car_model") String car_model, Model model){
        Complectation complect = complectationService.getComplectationById(id);
        model.addAttribute("complect", complect);
        model.addAttribute("car_model", car_model);
        return "view_update_complect";
    }

    @PostMapping("/saveChanges")
    public String saveUpdatedComplect(@ModelAttribute ("complect")Complectation complect,
                                      @RequestParam ("car_model") String car_model){
        String url = "redirect:/showComplectation/" + car_model;
        complectationService.saveComplectation(complect);
        return url;
    }

    @GetMapping("/deleteModel")
    public String deleteModel(@RequestParam ("model") String model){
        System.out.println(model);
        int idCar = carService.getCar(model).getId();
        carService.deleteCarById(idCar);
        return "redirect:/";
    }

}
