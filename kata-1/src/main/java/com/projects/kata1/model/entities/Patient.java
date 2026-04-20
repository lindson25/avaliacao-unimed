package com.projects.kata1.model.entities;

import com.projects.kata1.model.enums.UrgencyLevel;

import java.time.LocalTime;

public class Patient {

    private String name;
    private int age;
    private UrgencyLevel urgency;
    private LocalTime arrivalTime;

    public Patient(String name, int age, UrgencyLevel urgency, LocalTime arrivalTime) {
        this.name = name;
        this.age = age;
        this.urgency = urgency;
        this.arrivalTime = arrivalTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UrgencyLevel getUrgency() {
        return urgency;
    }

    public void setUrgency(UrgencyLevel urgency) {
        this.urgency = urgency;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", urgency=" + urgency +
                ", arrivalTime=" + arrivalTime +
                '}';
    }
}
