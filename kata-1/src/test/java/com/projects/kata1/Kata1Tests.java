package com.projects.kata1;

import com.projects.kata1.model.entities.Patient;
import com.projects.kata1.model.enums.UrgencyLevel;
import com.projects.kata1.services.TriageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Kata1Tests {

    private TriageService service;

    @BeforeEach
    void setup() {
        service = new TriageService();
    }

    @Test
    void minorShouldGainExtraPriorityLevel() {

        Patient minor = new Patient(
                "João",
                15,
                UrgencyLevel.MEDIA,
                LocalTime.of(10, 0)
        );

        Patient adult = new Patient(
                "Carlos",
                30,
                UrgencyLevel.MEDIA,
                LocalTime.of(9, 0)
        );

        List<Patient> result = service.sortQueue(List.of(adult, minor));

        assertEquals("João", result.get(0).getName());
    }

    @Test
    void elderlyMediumUrgencyShouldBecomeHigh() {

        Patient elderly = new Patient(
                "Maria",
                65,
                UrgencyLevel.MEDIA,
                LocalTime.of(10, 0)
        );

        Patient adult = new Patient(
                "Carlos",
                30,
                UrgencyLevel.MEDIA,
                LocalTime.of(9, 0)
        );

        List<Patient> result = service.sortQueue(List.of(adult, elderly));

        assertEquals("Maria", result.get(0).getName());
    }

    @Test
    void shouldOrderByArrivalTimeWhenSamePriority() {

        Patient first = new Patient(
                "Ana",
                40,
                UrgencyLevel.ALTA,
                LocalTime.of(9, 0)
        );

        Patient second = new Patient(
                "Carlos",
                40,
                UrgencyLevel.ALTA,
                LocalTime.of(10, 0)
        );

        List<Patient> result = service.sortQueue(List.of(second, first));

        assertEquals("Ana", result.get(0).getName());
    }

    @Test
    void criticalPatientsShouldAlwaysComeFirst() {

        Patient critical = new Patient(
                "Pedro",
                50,
                UrgencyLevel.CRITICA,
                LocalTime.of(11, 0)
        );

        Patient low = new Patient(
                "Lucas",
                25,
                UrgencyLevel.BAIXA,
                LocalTime.of(8, 0)
        );

        List<Patient> result = service.sortQueue(List.of(low, critical));

        assertEquals("Pedro", result.get(0).getName());
    }
}
