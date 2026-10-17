package com.dojo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class EmployeeQueries {

    //Nombres de quienes ganan más de 5,000, ordenados alfabéticamente.
    public static List<String> namesEarningOver (List<Employee> employees, double amount) {
        return employees.stream()
                .filter(employee -> employee.salary() > amount)
                .map(Employee::name)
                .sorted()
                .toList();
    }

    //Total de la planilla (suma de salarios).
    public static double sumSalary (List<Employee> employees) {
        return  employees.stream()
                .mapToDouble(Employee::salary)
                .sum();
    }

    //Salario promedio de toda la empresa.
    public static double companyAverageSalary (List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::salary)
                .average()
                .orElse(0.0);
    }

    //Empleados agrupados por área (Map<String, List<Empleado>>).
    public static Map<String, List<Employee>> employeesGroupByArea (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::area));
    }

    //Cantidad de empleados por área (Map<String, Long>).
    public static Map<String, Long> totalEmployeesByArea (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::area, Collectors.counting()));
    }

    //Salario promedio por área.
    public static Map<String, Double> averageSalaryByArea (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::area, Collectors.averagingDouble(Employee::salary)));
    }

    //Quien más gana en cada área.
    public static Map<String, Optional<Employee>> topEmployeeByArea (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.groupingBy(Employee::area, Collectors.maxBy(Comparator.comparingDouble(Employee::salary))));
    }

    //El empleado más antiguo (devuelve Optional<Empleado>).
    public static Optional<Employee> oldEmployee (List<Employee> employees) {
        return employees.stream()
                .min(Comparator.comparing(Employee::startDate));
    }

    //Partir en dos grupos: ganan más / no más que el promedio general (partitioningBy).
    public static Map<Boolean, List<Employee>> partitionedEmployees (List<Employee> employees) {
        return employees.stream()
                .collect(Collectors.partitioningBy(employee -> employee.salary() > companyAverageSalary(employees)));
    }

    //Todos los nombres en un solo String: "Ana, Luis, Rosa" (joining).
    public static String employeeNamesString (List<Employee> employees) {
        return employees.stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
    }
}
