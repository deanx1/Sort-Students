/*
 * This program sorts students with a bubblesort and sorts classes filled by
 * with an insertionsort. It shows the time it takes to sort different student
 * groups with different sizes. There are also two methods available to check
 * if an array of students is sorted. One recursive the other by looping.
 */
package nl.hva.dmci.ict.se.datastructures;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import static nl.hva.dmci.ict.se.datastructures.StudentSorter.studentSort;
import static nl.hva.dmci.ict.se.datastructures.StudentSorter.sortByKlas;

/**
 *
 * @author Gebruiker
 */
public class MainClassStudents {

    public static void main(String[] args) {
        int studentAmount = 1;
        Student[] students = studentListGenerator(studentAmount);
        measureEfficiency();
    }

    private static Student[] studentListGenerator(int maxAmount) {
        String[] klassen = KlasGenerator.maakKlassen(maxAmount);
        Student[] students = new Student[maxAmount];
        for (int x = 0; x < maxAmount; x++) {
            students[x] = new Student(klassen[x]);
        }
        return students;
    }

    private static void printMarkFrequentie(Student[] list) {
        String[] frequentieList = new String[list.length];
        HashMap<Double, Integer> map = new HashMap<Double, Integer>();

        // For every student
        for (Student s : list) {
            // Check if the key value is not in the map, if so put a new one in
            if (!map.containsKey(s.getMark())) {
                map.put(s.getMark(), 1);

                //Update the hashmap by increasing the value by one
            } else {
                map.put(s.getMark(), map.get(s.getMark()) + 1);
            }
        }

        //print students
        for (Double key : map.keySet()) {

            System.out.println(key + ";" + map.get(key));
        }

    }
    
    // Checks if a list of students is ascending by looping through it.
    private static boolean isAscending(List<Student> list) {
        // If list smaller than 2 return true
        if (list.size() < 2) {
            return true;
        } else {
            // -1 so we dont go out of bounds
            for (int i = 0; i < list.size() - 1; i++) {
                Student current = list.get(i);
                Student next = list.get(i + 1);
                // Check if the current element is smaller than the next, if not return false
                if (current.compareTo(next) > 0) {
                    return false;
                }
            }
        }
        // If gone through the list without returning false return true
        return true;
    }

    public static <T extends Comparable<T>> boolean isStijgend(List<T> rijtje) {
        {
            // check if list size is alteast 2
            if (rijtje.size() < 2) {
                return false;
            }
            // compare the first two elements of the list
            int last = 0;
            int next = 1;
            int difference = rijtje.get(last).compareTo(rijtje.get(next));
            // if there are only 2 elements left in the array and next is bigger than last return true
            // this line prevents an ascending array with 2 elements left from incorrectly returning false
            if (rijtje.size() == 2) {
                if (difference <= 0) {
                    return true;
                }
            }
            // if the next element is smaller than the previous return false
            if (difference >= 1) {
                return false;
                // if the next element is bigger than the last one and the list size is bigger than 2
                //remove the first element of the list and call the method again
            } else if (next > last) {
                rijtje.remove(last);
                return isStijgend(rijtje);
            }
            return true;
        }
    }

    private static void measureEfficiency() {
        int[] studentsToGenerate = {500, 1000, 2000, 4000, 8000, 16000};
        // The current system time
        long timeStart = System.currentTimeMillis();
        long totalTime = 0;
        // Test the sorting with different student ammounts in a loop
        for (int i = 0; i < studentsToGenerate.length; i++) {
            Student[] studentsTestAmount = studentListGenerator(studentsToGenerate[i]);
            System.out.println("Measuring Efficiency with " + studentsToGenerate[i] + " students.");

            // Sorting by mark
            studentSort(studentsTestAmount);
            long sortTimeMark = (System.currentTimeMillis() - timeStart);
            System.out.println("Sorting by mark took:  " + sortTimeMark + "ms");
            totalTime += sortTimeMark;
            // Sorting classes by studentnumber
            sortByKlas(studentsTestAmount);
            long sortTimeClass = (System.currentTimeMillis() - timeStart);
            sortTimeClass = sortTimeClass - sortTimeMark;
            System.out.println("Sorting by class took: " + sortTimeClass + "ms\n");
            totalTime += sortTimeClass;
        }
        System.out.println("Total time:" + totalTime + "ms");
    }

}
