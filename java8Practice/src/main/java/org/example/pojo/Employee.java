package org.example.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Employee {
    int empId;
    String empName;
    int salary;
    List<String> hobbies;

    public Employee(int empId, String empName, int salary, List<String> hobbies) {
        this.empId = empId;
        this.empName = empName;
        this.salary=salary;
        this.hobbies=hobbies;
    }

    public int getSalary() {
        return salary;
    }
}
