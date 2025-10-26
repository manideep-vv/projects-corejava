package org.example.streams;

import org.example.pojo.CollegeStudent;
import org.example.pojo.DeptName;
import org.example.pojo.Student;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Collectors_GroupingDemo {
    public static void main(String[] args) {
//        groupingWith1ParamFunction();
//        groupingWith2ParamFunctionAndCollector();
        groupByDept();
    }

    public static void groupingWith1ParamFunction() {
        //Here we are grouping by gender - only 2 groups named female and male will be formed
        print(StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(e -> e.getGender())));
        print(StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(Student::getGender)));
//Collectors.summingInt()
    }
    public static void groupingWith2ParamFunctionAndCollector() {
        //Here we are grouping by gender - only 2 groups named female and male will be formed
        print("grouping gender"+StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(Student::getGender,Collectors.toList())));
        print("grouping gender"+StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(Student::getGender)));
        //The below will group the records by gender and provides value as count of notebooks gender{female=33, male=47}
        print("grouping gender"+StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(Student::getGender, Collectors.summingInt(e->e.getNoteBooks()))));
        Map<String, Long> groupAndCount = StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(e -> e.getGender(), Collectors.counting()));
//        Collectors.filtering();
        //The below will group the records by gender and provides value as sum of their gpa gender{female=11.3, male=11.5}
        print("grouping gender"+StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(Student::getGender,Collectors.summingDouble(Student::getGpa))));
print("male highest notebooks and female highest notebooks-->"+
        StudentDataBase.getAllStudentsAsStream().collect(
                Collectors.groupingBy(Student::getGender,Collectors.maxBy(Comparator.comparing(Student::getNoteBooks))))
        );
        Map<Integer, Optional<Student>> collect = StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(Student::getGradeLevel,
                Collectors.maxBy(Comparator.comparing(Student::getGpa))
        ));
        print("Top gpa in each grade"+ collect);
        //Instead of collecting into optional, if u want direct employee object then use collectingAndThen
        Map<Integer, Student> collect1 = StudentDataBase.getAllStudentsAsStream().collect(Collectors.groupingBy(
                Student::getGradeLevel, Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)
        ));
        System.out.println("collectors.groupby collecting and then"+collect1);

//Collectors.summingInt()
    }

    public static void groupByDept() {
        //group by dept
        Map<Enum, List<CollegeStudent>> collect = CollegeStudent.getCollegeStudents().collect(Collectors.groupingBy(CollegeStudent::getDeptName));
        System.out.println(collect);
        //groupby dept and print who has highest marks in each dept
        Map<DeptName, Optional<CollegeStudent>> highestMarksGroupByDept = CollegeStudent.getCollegeStudents().collect(Collectors.groupingBy(
                CollegeStudent::getDeptName,
                Collectors.maxBy(Comparator.comparing(CollegeStudent::getMarks))
        ));
        System.out.println("highestMarksGroupByDept-->"+highestMarksGroupByDept);
        //groupby dept and i want each again groupby gender and i want who is highest in male and who is highest in females
        //gorupby dept and gender
        Map<DeptName, Map<String, Optional<CollegeStudent>>> groupByDeptGender = CollegeStudent.getCollegeStudents().collect(Collectors.groupingBy( // Function, collector
                CollegeStudent::getDeptName,// Function
                Collectors.groupingBy( // collector
                        CollegeStudent::getGender, //Function
                        Collectors.maxBy(Comparator.comparing(CollegeStudent::getMarks)) //Collector
                )

        ));
        System.out.println("groupByDeptGender"+groupByDeptGender);
    }


    public static void print(Object o) {
        System.out.println(o);
    }
}

