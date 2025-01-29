package deque;
import java.util.Iterator;

//         0 1  2 3 4 5 6 7
// items: [6 9 -1 2 0 0 0 0 ...]
// size: 5

/* Invariants:
 addLast: The next item we want to add, will go into position size
 getLast: The item we want to return is in position size - 1
 size: The number of items in the list should be size.
 Logical Last element : items[(nextLast - 1 + items.length) % items.length]
 Logical First element : items[(nextFirst + 1 + items.length) % items.length]
 LogicalIndex = (nextFirst + 1 + index) % items.length;



*/


public class ArrayDeque<T> implements  Iterable<T> {
    private  T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;
    private static final int INT_SIZE = 8;

    public ArrayDeque() {
        items = (T[]) new Object[INT_SIZE];
        size = 0;
        nextFirst = 4;
        nextLast = 5;

    }


    public void addFirst(T item) {
        if (size == items.length){
            resizeUP(len()*2);

        }
        items[nextFirst] = item;
        nextFirst = (nextFirst-1+items.length) % (items.length);
        size++;
    }

    public void addLast(T item) {
        if (size == items.length){
            resizeUP(len()*2);
        }
        items[nextLast] = item;
        nextLast = (nextLast + 1) % (items.length) ;
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        if(isEmpty()) {System.out.println("null");}
        else{
            for(T item : this){
                System.out.print(item + " ");
            }
        }
        System.out.println();

    }

    public int len(){
        return items.length;
    }


    public T removeFirst() {
        T returnItem = items[(nextFirst + 1 + items.length) % items.length];

        if (size == 0){
            return null;
        }
        if (size >= 1){
            items[(nextFirst + 1 + items.length) % items.length] = null ;
            nextFirst = (nextFirst + 1 + items.length) % items.length;
            size--;
        }
        if (factorclac()){
            resizeDown(len()/2);
        }
        return returnItem;
    }

    public T removeLast(){
        T returnItem = items[(nextLast - 1 + items.length) % items.length] ;

        if (size == 0){
            return null;
        }
        if (size >= 1){
            items[(nextLast - 1 + items.length) % items.length] = null;
            nextLast = (nextLast - 1 + items.length) % items.length;
            size--;
        }
        if (factorclac()){
            resizeDown(len()/2);
        }
        return returnItem;
    }

    public T get(int index) {
        T LogicalIndex = items[(nextFirst + 1 + index) % items.length];
        if (size <= 0){
            return null;
        }
        return  LogicalIndex ;
    }

    public Iterator<T> iterator(){
        return new CustomIterator();
    }
    private class CustomIterator implements Iterator<T> {
        private int itemPosition;
        public CustomIterator() {
            itemPosition = 0;

        }

        @Override
        public boolean hasNext() {
            return itemPosition < len();
        }

        @Override
        public T next() {

            return get(itemPosition++);
        }
    }



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

        ArrayDeque<T> otherDeque = (ArrayDeque <T>) o;

        if (this.len() != otherDeque.size()) {
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

    private void resizeUP(int capacity){
            T [] newList =  (T[]) new Object[capacity];
            int j = 0;
            for (int i = 0 ; i<items.length; i++){
                newList[i] = get(j);
                j++;
            }
            items = newList;
            nextFirst = items.length - 1;
            nextLast = size ;
    }

    public boolean factorclac(){
        double factor = 0.25;
        double Percentage  = factor * items.length;
        return size <= Percentage;
    }

    private void resizeDown(int capacity) {
        T[] resizeList = (T[]) new Object[capacity];
        int j = 0;
        for (int i = 0; i < size; i++) {
            resizeList[i] = get(j);
            j++;
        }
        items = resizeList;
        nextFirst = items.length - 1;
        nextLast = size;
    }

    //test

    public static void main(String[] args) {
        ArrayDeque <String> deque = new ArrayDeque<>();

        deque.addLast("a");
        deque.addLast("b");
        deque.addFirst("c");
        deque.addLast("d");








        System.out.println("Size: " + deque.size()); // Expected: 3

        System.out.println(deque.get(0));
        System.out.println(deque.removeFirst());

        System.out.println(deque.removeLast());

        System.out.println(deque.get(2));
        System.out.println(deque.removeFirst());









    }








}
