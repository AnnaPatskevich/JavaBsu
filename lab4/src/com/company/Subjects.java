package com.company;
public enum Subjects {

    GA("geometryAndAlgebra"), MA("mathAnalysis"), PROG("programming");
    String value;

    Subjects(String value) {
        this.value = value;
    }
}