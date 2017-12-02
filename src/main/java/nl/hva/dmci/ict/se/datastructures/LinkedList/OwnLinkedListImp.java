package nl.hva.dmci.ict.se.datastructures.LinkedList;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A partially implemented Double Ended Queue Dean van Doorn
 *
 * @param <T>
 */
public class OwnLinkedListImp<T> implements OwnLinkedList<T>, Iterable<T> {

    private Node<T> left;
    private Node<T> right;
    private int itemCount;

    public OwnLinkedListImp() {
        left = right = null;
        itemCount = 0;
    }

    @Override
    public boolean isEmpty() {
        return itemCount == 0;
    }

    @Override
    public int size() {
        return itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public T get(int index) {
        // Start
        Node loopingNode = left;
        for (int i = 0; i < index; i++) {
            loopingNode = loopingNode.getNext();
            if (loopingNode == null) {
                throw new IndexOutOfBoundsException();
            }
        }
        return (T) loopingNode.getItem();
    }

    @Override
    public Iterator<T> iterator() {

        return new Iterator<T>() {

            // Starting Node
            private Node<T> current = left;

            // Check if there is a next element
            @Override
            public boolean hasNext() {
                return current != null;
            }

            // Return next element
            @Override
            public T next() {
                T item = current.getItem();
                current = current.getNext();
                return item;
            }
        };
    }

    @Override
    public void add(T item) {

        Node node = new Node(item);

        if (right == null) {
            left = node;
            right = node;
        } else {
            Node oldRight = right;
            right = node;
            right.setPrevious(oldRight);
            oldRight.setNext(right);
            // Set null just to be sure
            right.setNext(null);
        }
        itemCount++;
    }

    @Override
    public void add(int index, T item) {
        Node newNode = new Node(item);

        // Check if is added at the first index
        if (index == 0) {
            Node oldFirst = left;
            left = newNode;
            newNode.setNext(oldFirst);
            // Set null just to be sure
            newNode.setPrevious(null);
            oldFirst.setPrevious(newNode);
            itemCount++;
            // Check if is added at the last index
        } 
        else {

            Node loopingNode = left;
            int max = index - 1;
            // Looping through the LinkedList till you reach the desired position get 1 node before the index
            for (int i = 0; i < max; i++) {
                loopingNode = loopingNode.getNext();
            }
            // Check if null
            if (loopingNode == null) {
                throw new IllegalArgumentException("The node does not exist");
                // Add a new note on this place
            } else {
                // Set the next of the current node to 
                Node oneBeforeIndexNode = loopingNode;
                Node oldNodeOnIndex = oneBeforeIndexNode.getNext();
                oneBeforeIndexNode.setNext(newNode);
                newNode.setPrevious(oneBeforeIndexNode);
                newNode.setNext(oldNodeOnIndex);
                oldNodeOnIndex.setPrevious(newNode);
                itemCount++;
                //
            }
        }
    }
}
