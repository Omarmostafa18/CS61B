package gh2;

import deque.LinkedListDeque;

//Note: This file will not compile until you complete the Deque implementations
public class GuitarString {

    private static final int SR = 44100;      // Sampling Rate
    private static final double DECAY = .996; // energy decay factor

    /* Buffer for storing sound data. */
    private LinkedListDeque<Double> buffer;

    /* Create a guitar string of the given frequency.  */
    public GuitarString(double frequency) {


        double bufferCapacity =  Math.round(  SR / frequency);
        buffer = new LinkedListDeque<>();
        for (int i = 0; i < bufferCapacity; i++) {
            buffer.addFirst(0.0);
        }
        buffer.printDeque();
    }


    /* Pluck the guitar string by replacing the buffer with white noise. */
    public void pluck() {


        int size = buffer.size();
       for (int i = 0; i < size; i++) {
           buffer.removeFirst();
       }

        for (int i = 0; i < size; i++) {
            double r = Math.random() - 0.5;
            buffer.addLast(r);
        }

    }

    /* Advance the simulation one time step by performing one iteration of
     * the Karplus-Strong algorithm.
     */
    public void tic() {

        double firstItem = buffer.get(0);
        double secondItem = buffer.get(1);
        double newDouble = DECAY * 0.5 * (firstItem + secondItem);
        buffer.removeFirst();
        buffer.addLast(newDouble);
    }

    /* Return the double at the front of the buffer. */
    public double sample() {

        return  buffer.get(0).doubleValue();
    }


}


