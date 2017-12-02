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
 * @author Gebruiker
 */
public class Klassen extends OwnLinkedListImp<Klas> {

    // Adds a klas at the right place in klasses so it remains sorted
    public void addKlas(Klas k) {
        // If klass is empty add new Klas
        if (isEmpty()) {
            add(k);
        } else {
            // Loop through the list,
            for (int i = 0; i < this.size(); i++) {
                Klas current = get(i);
                //  If k is bigger than current looping Klas and add Klas at that spot
                if (k.compareTo(current) < 0) {
                    add(i, k);
                    // Break out of the loop after adding a Klas
                    break;
                    // If none of elements are bigger add s at the end
                } else if (i == this.size() - 1) {
                    add(k);
                    // Break out of the loop after adding a Klas
                    break;
                }
            }
        }
    }

}
