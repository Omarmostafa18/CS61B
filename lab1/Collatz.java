/** Class that prints the Collatz sequence starting from a given number.
 *  @author YOUR NAME
 */
public class Collatz {

    /**
     * Returns the next number in the Collatz sequence.
     * If n is even, returns n / 2.
     * If n is odd, returns 3 * n + 1.
     * Assumes n is a positive integer.
     */
    public static int nextNumber(int n) {
        if (n % 2 == 0) {
            return n / 2;
        } else {
            return 3 * n + 1;
        }
    }

    public static void main(String[] args) {
        int n = 5;
        System.out.print(n + " ");
        while (n != 1) {
            n = nextNumber(n);
            System.out.print(n + " ");
        }
        System.out.println();
    }
}
