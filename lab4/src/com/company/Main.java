package com.company;
//import com.company.Student;

import java.util.*;

public class Main {

    static List<Group> groups = new ArrayList<>();

    public static void addStudentToGroup(Student student, List<Group> groups){
        for(Group group : groups){
            if(student.getGroupNumber() == group.getNumber()) {
                group.getStudents().add(student);
                return;
            }
        }
        List<Student> newStudents = new ArrayList<>();
        newStudents.add(student);
        groups.add(new Group(student.getGroupNumber(), newStudents));
    }

    public static void main(String[] args) {

        Boolean exit = false;

        Scanner sc = new Scanner(System.in);

        while (!exit) {

            Map<Subjects, Integer> marks = new HashMap<Subjects, Integer>();

            System.out.println("Enter student's group: ");
            int group = sc.nextInt();

            System.out.println("Enter student's first name and last name");
            String fName = sc.next();
            String lName = sc.next();

            Student student = new Student (fName, lName, group , marks);

            System.out.println("Enter your mark for " + Subjects.GA.value + " : ");
            marks.put(Subjects.GA, sc.nextInt());

            System.out.println("Enter your mark for " + Subjects.MA.value + " : ");
            marks.put(Subjects.MA, sc.nextInt());

            System.out.println("Enter your mark for " + Subjects.PROG.value + " : ");
            marks.put(Subjects.PROG, sc.nextInt());

            addStudentToGroup(student, groups);

            System.out.println("Do you have any more student?(Y/N):");
            if (sc.next().equals("N"))
                exit = true;
        }

        System.out.println("Enter the number of group to analyse");
        int num = sc.nextInt();
        for(Group group: groups){
            if(group.getNumber() == num){
                System.out.println("Average score of the group: " + group.averageGroupMark());
                System.out.println("Amount of nerds: " + group.nerdsNumber());
                System.out.println("Amount of outsiders: " + group.outsidersNumber());
                System.out.println("Average mark of each student:\n" + group.averageMarkOfEach());
            }
        }

    }
}

