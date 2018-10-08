package com.company;
import com.company.Student;

import java.util.ArrayList;
import java.util.List;

public class Group {

    private int number;

    private List<Student> students;

    public Group(int number, List<Student> students) {
        this.number = number;
        this.students = students;
    }

    public Group() {
        students = new ArrayList<>();
    }

    public double averageGroupMark(){
        return students.stream().mapToDouble(Student::averageMark).sum() / students.size();
    }

    public int nerdsNumber(){
        int counter = 0;
        for (Student student : students) {
            if (student.isNerd()) {
                counter++;
            }
        }
        return counter;
    }

    public int outsidersNumber(){
        int counter = 0;
        for (Student student : students) {
            if (student.isOutsider()) {
                counter++;
            }
        }
        return counter;
    }

    public String averageMarkOfEach(){
        StringBuffer averageMarkOfEachStudent = new StringBuffer();
        for(Student student : students){
            averageMarkOfEachStudent.append(student.getName().toString())
                    .append(" ")
                    .append(student.averageMark())
                    .append("\n");
        }
        return averageMarkOfEachStudent.toString();
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }


}

