package com.dojo;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.assertThrows;

class EmployeeTest {

    @Test
    void rejectsNegativeSalary() {
        assertThrows(IllegalArgumentException.class,
                () -> new Employee("Ana", "Backend", -100, LocalDate.of(2020, 1, 1)));
    }
}