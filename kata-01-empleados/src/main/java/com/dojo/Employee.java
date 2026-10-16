package com.dojo;

import java.time.LocalDate;

public record Employee(String name, String area, double salary, LocalDate startDate) {
}
