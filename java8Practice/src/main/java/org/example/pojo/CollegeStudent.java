package org.example.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.stream.Stream;

@Data
@AllArgsConstructor
public class CollegeStudent {
    String name;
    DeptName deptName;
    int marks;

    String gender;





    static   String male = "Male";
    static String female = "Female";
    static String CSE = "CSE";

    @Override
    public String toString() {
        return " \n CollegeStudent{" +
                "name='" + name + '\'' +
                ", deptName=" + deptName +
                ", marks=" + marks +
                ", gender='" + gender + '\'' +
                '}';
    }

    public static Stream<CollegeStudent> getCollegeStudents() {


        return Stream.of(
                new CollegeStudent("DrSarala", DeptName.ECE, 99, female),
                new CollegeStudent("Mani", DeptName.ECE, 95, male),
                new CollegeStudent("KhadarVali", DeptName.ECE, 90, male),

                new CollegeStudent("Santu", DeptName.EEE, 95, female),
                new CollegeStudent("charan", DeptName.EEE, 85, male),
                new CollegeStudent("Loopa", DeptName.EEE, 45, female),
                null,
                new CollegeStudent("Rama", DeptName.CSE, 25, female),
                new CollegeStudent("SAI gadu", DeptName.CSE, 65, male),
                new CollegeStudent("rangayya", DeptName.CSE, 85, male)
        );

    }
}
