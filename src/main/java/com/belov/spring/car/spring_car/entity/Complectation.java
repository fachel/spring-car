package com.belov.spring.car.spring_car.entity;

import com.sun.xml.bind.v2.model.core.ID;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "complectations")
public class Complectation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "price")
    private int price;

    @Column(name = "color")
    private String color;

    @Column(name = "preheating")
    private String preheating;

    @Column(name = "audio_system")
    private String audio_system;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "complectationList")
    private List<Car> carList;

    public void addCarToComplectation(Car car){
        if (carList == null){
            carList = new ArrayList<>();
        }
        carList.add(car);
    }

    public Complectation() {
    }

    public Complectation(String name, int price, String color, String preheating, String audio_system) {
        this.name = name;
        this.price = price;
        this.color = color;
        this.preheating = preheating;
        this.audio_system = audio_system;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPreheating() {
        return preheating;
    }

    public void setPreheating(String preheating) {
        this.preheating = preheating;
    }

    public String getAudio_system() {
        return audio_system;
    }

    public void setAudio_system(String audio_system) {
        this.audio_system = audio_system;
    }

    @Override
    public String toString() {
        return "Complectation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", preheating='" + preheating + '\'' +
                ", audio_system='" + audio_system + '\'' +
                '}';
    }

    public List<Car> getCarList() {
        return carList;
    }

    public void setCarList(List<Car> carList) {
        this.carList = carList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Complectation that = (Complectation) o;
        name = name.trim();
        String anyName = that.name;
        anyName = anyName.trim();
        return Objects.equals(name, anyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
