package deque;

public interface Deque<T>{


    default boolean isEmpty() {
        return this.size() == 0;
    }

    int size();

    void printDeque();

    T removeFirst();

    T removeLast();

    T get(int x);

    void addLast(T item);

    void addFirst(T item);




}
