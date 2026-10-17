package com.dojo;

import java.time.LocalDate;

public record Employee(String name, String area, double salary, LocalDate startDate) {
    public Employee {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException(("El nombre no puede estar vacio"));
        }
        if (area == null || area.isBlank()) {
            throw new IllegalArgumentException(("El áre no puede estar vacio"));
        }
        if (salary <= 0) {
            throw new IllegalArgumentException(("El salario no puede ser negativo"));
        }
        if (startDate == null || startDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(("La fecha no puede se null o una fecha futura"));
        }
    }
}
