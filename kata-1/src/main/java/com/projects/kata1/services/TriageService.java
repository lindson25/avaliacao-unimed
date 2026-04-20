package com.projects.kata1.services;

import com.projects.kata1.model.entities.Patient;
import com.projects.kata1.model.enums.UrgencyLevel;

import java.util.Comparator;
import java.util.List;

public class TriageService {

    public List<Patient> sortQueue(List<Patient> patients) {

        return patients.stream()
                .sorted(Comparator
                        .comparingInt(this::calculatePriority).reversed()
                        .thenComparing(Patient::getArrivalTime))
                .toList();
    }

    private int calculatePriority(Patient patient) {

        int priority = mapUrgency(patient.getUrgency());

        if (patient.getAge() >= 60 && patient.getUrgency() == UrgencyLevel.MEDIA) {
            priority = mapUrgency(UrgencyLevel.ALTA);
        }

        if (patient.getAge() < 18) {
            priority += 1;
        }

        return priority;
    }

    private int mapUrgency(UrgencyLevel level) {

        return switch (level) {
            case CRITICA -> 4;
            case ALTA -> 3;
            case MEDIA -> 2;
            case BAIXA -> 1;
        };
    }
}
