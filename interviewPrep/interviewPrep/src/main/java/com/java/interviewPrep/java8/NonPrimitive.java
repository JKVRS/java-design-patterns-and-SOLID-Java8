package com.java.interviewPrep.java8;

import lombok.Getter;
import lombok.Setter;

import java.lang.reflect.Array;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Getter
@Setter
class Employee{
   int id;
   String name;
   String deptName;
   int salary;

    public Employee(int id, String name, String deptName, int salary) {
        this.id = id;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDeptName() {
        return deptName;
    }

    public int getSalary() {
        return salary;
    }

    public static void main(String[] args) {
        List<Employee> emp = Stream.of(
                new Employee(1, "Alice", "HR", 55000),
                new Employee(2, "Bob", "Finance", 60000),
                new Employee(3, "Charlie", "IT", 75000),
                new Employee(4, "David", "IT", 72000),
                new Employee(5, "Eve", "Marketing", 50000)
        ).toList();

        // collect employee to map
        Map<Integer,Employee> mp = emp.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        mp.forEach((id,employee)-> System.out.println(id+" "+employee.getName()));

        // map employee by  dept
        System.out.println("Map employee by dept:=");
        Map<String, List<Employee>> mp1 = emp.stream().collect(Collectors.groupingBy(Employee::getDeptName));
        mp1.forEach((dep,employee)->{
            System.out.println(dep);
            employee.forEach(i-> System.out.println(i.getName() +" "+i.getDeptName()));
        });

        // sort employee base on salary
        System.out.println("Sort employee based on salary:=");
        emp.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(i-> System.out.println(i.getName()+" "+i.getSalary()));

        // heighest salary per detartment
        System.out.println("Heighest salary per department:=");
        emp.stream().collect(Collectors.groupingBy(Employee::getDeptName,
                Collectors.maxBy(Comparator.comparing(Employee::getSalary)))).entrySet().stream()
                .forEach(i-> System.out.println(i.getKey()+" "+i.getValue().get().getSalary()));


    }
}

class NonPrimitive {

}
