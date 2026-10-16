package com.dojo;

import java.time.LocalDate;
import java.util.List;

public class Util {

    public static List<Employee> getEmployees() {
        return List.of(
                new Employee("Patricia", "QA", 7200.00, LocalDate.of(2024, 2, 1)),
                new Employee("Diego", "Backend", 6200.00, LocalDate.of(2022, 9, 1)),
                new Employee("Ernesto", "Frontend", 4900.00, LocalDate.of(2021, 10, 1)),
                new Employee("Pilar", "DevOps", 8700.00, LocalDate.of(2019, 4, 1)),
                new Employee("Sofia", "QA", 2900.00, LocalDate.of(2023, 5, 12)),
                new Employee("Mateo", "Backend", 7150.00, LocalDate.of(2023, 1, 15)),
                new Employee("Lucia", "Frontend", 5300.00, LocalDate.of(2022, 8, 20)),
                new Employee("Carlos", "DevOps", 7200.00, LocalDate.of(2020, 11, 5)),
                new Employee("Valentina", "QA", 7500.00, LocalDate.of(2025, 1, 10)),
                new Employee("Alejandro", "Backend", 5900.00, LocalDate.of(2021, 3, 25)),
                new Employee("Camila", "Frontend", 6400.00, LocalDate.of(2023, 7, 8)),
                new Employee("Lucas", "DevOps", 9100.00, LocalDate.of(2018, 9, 14)),
                new Employee("Martina", "QA", 3100.00, LocalDate.of(2021, 11, 30)),
                new Employee("Gabriel", "Backend", 6800.00, LocalDate.of(2024, 4, 18)),
                new Employee("Isabella", "Frontend", 4600.00, LocalDate.of(2020, 6, 22)),
                new Employee("Joaquin", "DevOps", 7650.00, LocalDate.of(2022, 12, 1)),
                new Employee("Valeria", "QA", 3800.00, LocalDate.of(2023, 10, 5)),
                new Employee("Santiago", "Backend", 7400.00, LocalDate.of(2022, 2, 14)),
                new Employee("Antonella", "Frontend", 5750.00, LocalDate.of(2024, 5, 9)),
                new Employee("Daniel", "DevOps", 8300.00, LocalDate.of(2017, 8, 19))
        );
    }


}
