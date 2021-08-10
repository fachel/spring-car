package com.belov.spring.car.spring_car.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "model")
    private String model;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "car_compl",
    joinColumns = @JoinColumn(name = "id_car"),
    inverseJoinColumns = @JoinColumn(name = "id_compl"))
    private List<Complectation> complectationList;


    public void addComplectation(Complectation compl){
        if (complectationList == null){
            complectationList = new ArrayList<>();
        }
        complectationList.add(compl);
    }

    public void deleteComplectation(String compl){
        Iterator<Complectation> iterator = complectationList.iterator();
        while (iterator.hasNext()){
            Complectation complect = iterator.next();
            if (complect.getName().trim().equals(compl.trim())){
                iterator.remove();
                return;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public List<Complectation> getComplectationList() {
        return complectationList;
    }

    public void setComplectationList(List<Complectation> complectationList) {
        this.complectationList = complectationList;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", model='" + model + '\'' +
                '}';
    }

    public Car(String model) {
        this.model = model;
    }

    public Car() {
    }
}
