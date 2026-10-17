package com.dojo;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeQueriesTest {

    private static final List<Employee> EMPLOYEES = List.of(
            new Employee("Ana",   "Backend", 6000, LocalDate.of(2020, 1, 10)),
            new Employee("Luis",  "Backend", 4000, LocalDate.of(2022, 5, 3)),
            new Employee("Rosa",  "QA",      3000, LocalDate.of(2019, 7, 21)),
            new Employee("Pedro", "QA",      5500, LocalDate.of(2021, 3, 15)),
            new Employee("Marta", "DevOps",  8000, LocalDate.of(2023, 9, 1))
    );

    @Test
    void namesEarningOverReturnsOnlyThoseAboveAmount() {
        List<String> result = EmployeeQueries.namesEarningOver(EMPLOYEES, 5000);
        assertEquals(List.of("Ana", "Marta", "Pedro"), result);
    }
}
