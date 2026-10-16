package com.dojo;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //public record Employee(String name, String area, double salary, LocalDate dateInit);

        //Nombres de quienes ganan más de 5,000, ordenados alfabéticamente.
        System.out.println("Nombres de quienes ganan más de 5,000, ordenados alfabéticamente.");
        List<String> employeeNameSortedBySalary = Util.getEmployees().stream().
                filter(employee -> employee.salary() > 5000)
                .map(Employee::name)
                .sorted()
                .toList();

        System.out.println(employeeNameSortedBySalary);

        //Total de la planilla (suma de salarios).
        System.out.println("Total de la planilla (suma de salarios).");
        double sumSalary = Util.getEmployees().stream()
                .mapToDouble(Employee::salary)
                .sum();
        System.out.println(sumSalary);

        //Empleados agrupados por área (Map<String, List<Empleado>>).
        System.out.println("Empleados agrupados por área (Map<String, List<Empleado>>).");
        Map<String, List<Employee>> employeesGroupByArea = Util.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::area));

        System.out.println(employeesGroupByArea);

        //Cantidad de empleados por área (Map<String, Long>).
        System.out.println("Cantidad de empleados por área (Map<String, Long>).");
        Map<String, Long> totalEmployeesByArea = Util.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::area, Collectors.counting()));

        System.out.println(totalEmployeesByArea);

            //Salario promedio por área.
            System.out.println("Salario promedio por área.");
            Map<String, Double> averageSalaryByArea = Util.getEmployees().stream()
                    .collect(Collectors.groupingBy(Employee::area, Collectors.averagingDouble(Employee::salary)));

            System.out.println(averageSalaryByArea);

        //Quien más gana en cada área.
        System.out.println("Quien más gana en cada área.");
        //Map<String, Employee> employeeSalaryPluss = Util.getEmployees().stream()
                //.collect(Collectors.groupingBy(Employee::area, Collectors.maxBy(Employee::salary)));

        //System.out.println(employeeSalaryPluss);


        //El empleado más antiguo (devuelve Optional<Empleado>).
        System.out.println("El empleado más antiguo (devuelve Optional<Empleado>).");
        Optional<Employee> oldEmployee = Util.getEmployees().stream()
                .min(Comparator.comparing(Employee::startDate));

        System.out.println(oldEmployee);

        //Partir en dos grupos: ganan más / no más que el promedio general (partitioningBy).
        System.out.println("Partir en dos grupos: ganan más / no más que el promedio general (partitioningBy).");
        double averageSalary = Util.getEmployees().stream().mapToDouble(Employee::salary).average().orElse(0.0);
        Map<Boolean, List<Employee>> partitionedEmployees = Util.getEmployees().stream()
                .collect(Collectors.partitioningBy(salary -> salary.salary() > averageSalary));

        System.out.println("Ganan más que el promedio: " + partitionedEmployees.get(true).size());
        System.out.println("No ganan más que el promedio: " + partitionedEmployees.get(false).size());


        //Todos los nombres en un solo String: "Ana, Luis, Rosa" (joining).
        System.out.println("Todos los nombres en un solo String: \"Ana, Luis, Rosa\" (joining).");
        String employeeNamesString = Util.getEmployees().stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        System.out.println(employeeNamesString);


    }
}