package com.projects.kata1;

import com.projects.kata1.model.entities.Patient;
import com.projects.kata1.model.enums.UrgencyLevel;
import com.projects.kata1.services.TriageService;

import java.time.LocalTime;
import java.util.List;

public class Kata1Application {

    public static void main(String[] args) {

        List<Patient> patients = List.of(

                // urgência crítica
                new Patient("Pedro", 45, UrgencyLevel.CRITICA, LocalTime.of(10, 30)),

                // idoso com urgência média (vira alta)
                new Patient("Maria", 65, UrgencyLevel.MEDIA, LocalTime.of(10, 0)),

                // menor de idade (ganha +1 prioridade)
                new Patient("João", 15, UrgencyLevel.MEDIA, LocalTime.of(9, 30)),

                // urgência alta normal
                new Patient("Carlos", 40, UrgencyLevel.ALTA, LocalTime.of(9, 0)),

                // urgência baixa
                new Patient("Ana", 30, UrgencyLevel.BAIXA, LocalTime.of(8, 45)),

                // empate por horário (mesma prioridade)
                new Patient("Lucas", 35, UrgencyLevel.ALTA, LocalTime.of(8, 30))
        );

        TriageService service = new TriageService();

        List<Patient> queue = service.sortQueue(patients);

        System.out.println("Fila ordenada por prioridade:");

        queue.forEach(System.out::println);
    }
}
