package deque;

import java.util.Iterator;

public class LinkedListDeque<T> implements  Iterable<T> {
    private class Node {
        Node prev;
        T item;
        Node next;

        public Node(Node p, T i, Node n) {
            this.prev = p;
            item = i;
            next = n;
        }
    }

    private int size;
    private final Node sentinel;

    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        size = 0;
    }

    public LinkedListDeque(T x) {
        sentinel = new Node(null, null, null);
        sentinel.next = new Node(sentinel, x, sentinel);
        size = 1;
    }

    public void addFirst(T item) {
        Node newNode = new Node(sentinel, item, sentinel.next);

        if (size == 0) {
            // When the list is empty, point both sentinel's next and prev to the newNode
            sentinel.next = newNode;
            sentinel.prev = newNode;
            newNode.next = sentinel;
            newNode.prev = sentinel;
        } else {
            // If the list is not empty, update the previous first node's prev pointer
            sentinel.next.prev = newNode;
            sentinel.next = newNode;
        }
        size++;
    }

    public void addLast(T item) {
        // Adds an item to the back of the deque
        Node newNode = new Node(sentinel.prev, item, sentinel);

        if (size == 0) {
            // When the list is empty, point both sentinel's next and prev to the newNode
            sentinel.next = newNode;
            sentinel.prev = newNode;
            newNode.next = sentinel;
            newNode.prev = sentinel;
        } else {
            // If the list is not empty, update the previous first node's prev pointer
            sentinel.prev = newNode;
            sentinel.prev.next = newNode;
            sentinel.prev.next = sentinel;
            sentinel.prev.prev.next = newNode;
        }
        size++;
    }

    public boolean isEmpty() {
        // Returns true if deque is empty, false otherwise
        return (size == 0);
    }

    public int size() {
        // Returns the number of items in the deque
        return size;
    }


    public void printDeque() {
        // Create the iterator once
        if (sentinel.next == null) {
            System.out.println("null");
        } else {
            for (T item : this) {
                System.out.print(item + " ");

            }
        }
        System.out.println();
    }

    public T removeFirst() {
        // Removes and returns the item at the front of the deque
        if (isEmpty()) {
            return null;
        }
        T returnItem = sentinel.next.item;
        if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        } else {
            sentinel.next = sentinel.next.next;
            sentinel.next.prev = sentinel;
        }
        size--;
        return returnItem;
    }


    public T removeLast() {
        // Removes and returns the item at the back of the deque
        if (isEmpty()) {
            return null;
        }
        T returnItem = sentinel.prev.item;
        if (size == 1) {
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        } else {
            sentinel.prev = sentinel.prev.prev;
            sentinel.prev.next = sentinel;
        }
        size--;
        return returnItem;
    }

    public T get(int index) {
        // Gets the item at the given index
        Node currentNode = sentinel.next;
        if (index >= size) {
            return null;
        }
        while (index > 0) {
            currentNode = currentNode.next;
            index--;
        }


        return currentNode.item;
    }


    public T getRecursive(int index) {
        return null;
    }

    public Iterator<T> iterator() {
        // Returns an iterator for the deque
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<T> {
        private int itemPosition;

        public CustomIterator() {
            itemPosition = 0;

        }

        @Override
        public boolean hasNext() {
            return itemPosition < size();
        }

        @Override
        public T next() {

            return get(itemPosition++);
        }
    }

    @Override
    public boolean equals(Object o) {
        // Returns whether or not the parameter o is equal to the Deque
        if (o == null) {
            return false;
        }
        if (this == o) {
            return true;
        }
        if (this.getClass() != o.getClass()) {
            return false;
        }

        LinkedListDeque<T> otherDeque = (LinkedListDeque<T>) o;

        if (this.size() != otherDeque.size()) {
            return false;
        }

        Iterator<T> thisIterator = this.iterator();
        Iterator<T> otherIterator = otherDeque.iterator();

        while (thisIterator.hasNext() && otherIterator.hasNext()) {
            T thisItem = thisIterator.next();
            T otherItem = otherIterator.next();

            if (!thisItem.equals(otherItem)) {
                return false;
            }
        }

        return true;
    }
}