/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nl.hva.dmci.ict.se.datastructures;

import nl.hva.dmci.ict.se.datastructures.LinkedList.SuperKlas;
import java.util.LinkedList;
import nl.hva.dmci.ict.se.datastructures.LinkedList.OwnLinkedListImp;
import nl.hva.dmci.ict.se.datastructures.LinkedList.SuperKlasOud;

/**
 *
 * @author Dean
 */
public class Klas extends OwnLinkedListImp<Student> implements Comparable<Klas> {

    private String name;

    public Klas(String name) {
        this.name = name;
    }

    // Adds an element at the right place in the list so the list remeans sorted
    public void addStudent(Student s) {
        // If klass is empty add new student
        if (isEmpty()) {
            add(s);
        } else {
            // Loop through the list,
            for (int i = 0; i < this.size(); i++) {
                Student current = get(i);
                //  If s is bigger than current looping student add student at that spot
                if (s.compareId(current) < 0) {
                    add(i, s);
                    // Break out of the loop after adding a student
                    break;
                    // If none of elements are bigger add student at the end
                } else if (i == this.size() - 1) {
                    add(s);
                    // Break out of the loop after adding a student
                    break;
                }
            }
        }
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(Klas o) {
        return name.compareTo(o.getName());
    }

}
