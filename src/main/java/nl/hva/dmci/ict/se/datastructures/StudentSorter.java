/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author Dean
 */
public class StudentSorter {

    // Bubblesort for students by mark. lower marks first. If marks are the same sorted by studentnumber
    public static void studentSort(Comparable[] list) {
        System.out.println("Grade sort started");
        int length = list.length;
        boolean sorted = false;
        int loopCount = 0;
        do {
            int swapCount = 0;
            // Loopcount increases efficiency
            // as the highest elements bubble to the right and don't need to be checked anymore.

            // -1 so you dont go out of bounds. You dont need to check the last element           
            for (int i = 0; i < list.length - 1 - loopCount; i++) {
                Comparable current = list[i];
                Comparable next = list[i + 1];
                // Check if next > current if so swap
                if (current.compareTo(next) > 0) {
                    Comparable temp = current;
                    list[i] = next;
                    list[i + 1] = temp;
                    swapCount++;
                }
            }
            loopCount++;
            // If there are no more swaps the array must be sorted.
            if (swapCount == 0) {
                sorted = true;
            }
        } while (!sorted);
        System.out.println("Grade sort ended");
    }
 
    public static void sortByKlas(Student[] list) {
        System.out.println("Class sort started");
        Klassen klasses = new Klassen();
        HashMap<String, Integer> indexMap = new HashMap<String, Integer>();
        int currentIndex = 0;

        // For every student add them to a klas
        for (Student s : list) {
            // Add new klas if it does not exist
            if (!indexMap.containsKey(s.getKlas())) {
                indexMap.put(s.getKlas(), currentIndex);
                // New klas
                Klas klas = new Klas(s.getKlas());
                // Add student to klas
                klas.addStudent(s);
                // Add the klas to klasses
                klasses.addKlas(klas);
            } else {
                // Get the index of the existing Klas and add the student
                for (int i = 0; i < klasses.size(); i++) {
                    if (klasses.get(i).getName().equals(s.getKlas())) {
                        klasses.get(i).addStudent(s);
                        break;
                    }
                }
            }
        }
        System.out.println("Class sort ended");
    }

}
