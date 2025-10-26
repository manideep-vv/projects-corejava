package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Data
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    private   int id;
  private   String name;
    private String cityName;

    public static List<Employee> getData(){
        return Arrays.asList(
                new Employee(1, "mani", "HYD"),
                new Employee(2, "sai", "CHN"),
                new Employee(3, "Roopa", "BLR"),
                new Employee(4, "Roopa", "BLR"),
                new Employee(5, "Radhika", "HYD"),
                new Employee(6, "Mohan", "CHN")
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getName().equals(employee.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }

    @Override
    public String toString() {
        return " \n Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", cityName='" + cityName + '\'' +
                '}';
    }
}
