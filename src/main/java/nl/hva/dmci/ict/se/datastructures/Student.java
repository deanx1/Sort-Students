/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.Random;

/**
 *
 * @author Gebruiker
 */
public class Student implements Comparable<Student> {

    private static int nextStudentNummer = 50080001;
    private int studentNumber;
    private double mark;
    private String klas;
    private double min = 1.0;
    private double max = 9.1;

    public Student(String klas) {
        Random rand = new Random();
        this.mark = Math.floor((rand.nextDouble() * max + min) * 10.0) / 10.0;
        this.klas = klas;
        this.studentNumber = nextStudentNummer;
        nextStudentNummer++;
    }

    public int getStudentNumber() {
        return studentNumber;
    }

    public double getMark() {
        return mark;
    }

    public String getKlas() {
        return klas;
    }

    @Override
    public int compareTo(Student s) {
        if (mark < s.getMark()) {
            return -1;
        } else if (mark > s.getMark()) {
            return 1;
        }
        return 0;
    }

    public int compareId(Student s) {
        if (studentNumber < s.getStudentNumber()) {
            return -1;
        } else if (studentNumber > s.getStudentNumber()) {
            return 1;
        }
        return 0;
    }

}
