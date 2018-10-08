package com.company;

import com.company.Name;

import java.util.Map;

public class Student{

    private Name name;

    private int groupNumber;

    private Map<Subjects,Integer> marks;

    public Student(String fName, String lName, int number, Map<Subjects,Integer> marks) {
        name = new Name(fName, lName);
        this.groupNumber = number;
        this.marks = marks;
    }

    public String toString() {
        return name.toString() + "group: " + groupNumber + "marks" + "\n" + marksToString();
    }

    public String marksToString(){
        StringBuffer marksStream = new StringBuffer();
        for(Map.Entry<Subjects, Integer> entry : marks.entrySet()){
            marksStream.append(entry.getKey().value)
                    .append(" ")
                    .append(entry.getValue())
                    .append("; ");
        }
        return marksStream.toString();
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public Name getName() {
        return name;
    }

    public void setGroupNumber(int number) {
        this.groupNumber = number;
    }

    public Map<Subjects, Integer> getMarks() {
        return marks;
    }

    public void setMarks(Map<Subjects, Integer> marks) {
        this.marks = marks;
    }

    public double averageMark(){

        int sum = 0;

        for(Map.Entry<Subjects, Integer> entry : marks.entrySet()){
            sum += entry.getValue();
        }
        return sum/marks.size();
    }

    public boolean isNerd(){
        return averageMark() >= 9;
    }

    public boolean isOutsider(){
        for (Map.Entry<Subjects, Integer> entry: marks.entrySet()){
            if(entry.getValue() == 2) {
                return true;
            }
        }
        return false;
    }
}
