package com.dojo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Util.employeeList();   // una sola vez

        System.out.println("1. Nombres de quienes ganan más de 5,000:");
        System.out.println(EmployeeQueries.namesEarningOver(employees, 5000));

        System.out.println("2. Total de la planilla (suma de salarios).");
        System.out.println(EmployeeQueries.sumSalary(employees));

        System.out.println("3. Salario promedio:");
        System.out.println(EmployeeQueries.companyAverageSalary(employees));

        System.out.println("4.Empleados agrupados por área (Map<String, List<Empleado>>).");
        System.out.println(EmployeeQueries.employeesGroupByArea(employees));

        System.out.println("5. Cantidad de empleados por área (Map<String, Long>).");
        System.out.println(EmployeeQueries.totalEmployeesByArea(employees));

        System.out.println("6. Salario promedio por área.");
        System.out.println(EmployeeQueries.averageSalaryByArea(employees));

        System.out.println("7. Quien más gana en cada área.");
        System.out.println(EmployeeQueries.topEmployeeByArea(employees));

        System.out.println("8. El empleado más antiguo (devuelve Optional<Empleado>).");
        System.out.println(EmployeeQueries.oldEmployee(employees));

        System.out.println("9. Partir en dos grupos: ganan más / no más que el promedio general (partitioningBy).");
        System.out.println(EmployeeQueries.partitionedEmployees(employees));

        System.out.println("10. Todos los nombres en un solo String: \"Ana, Luis, Rosa\" (joining).");
        System.out.println(EmployeeQueries.employeeNamesString(employees));
    }
}