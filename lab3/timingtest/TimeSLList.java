package timingtest;
import edu.princeton.cs.algs4.Stopwatch;
import net.sf.saxon.om.Item;

/**
 * Created by hug.
 */
public class TimeSLList {
    private static void printTimingTable(AList<Integer> Ns, AList<Double> times, AList<Integer> opCounts) {
        System.out.printf("%12s %12s %12s %12s\n", "N", "time (s)", "# ops", "microsec/op");
        System.out.printf("------------------------------------------------------------\n");
        for (int i = 0; i < Ns.size(); i += 1) {
            int N = Ns.get(i);
            double time = times.get(i);
            int opCount = opCounts.get(i);
            double timePerOp = time / opCount * 1e6;
            System.out.printf("%12d %12.2f %12d %12.2f\n", N, time, opCount, timePerOp);
        }
    }

    public static void main(String[] args) {
        timeGetLast();
    }

    public static void timeGetLast() {
        // TODO: YOUR CODE HERE
        AList<Integer> Ns = new AList<>();
        AList<Double> times = new AList<>();
        AList<Integer> opCounts = new AList<>();

        for (int n = 1000; n <= 64000; n = n * 2) {
            SLList<Integer> list = new SLList<>();

            for (int j = 0; j < n; j++) {
                list.addLast(j);
            }
            Stopwatch sw = new Stopwatch();

            int M = 1000;
            for (int k = 0; k < M; k++) {
                list.getLast();
            }

            double timeInSeconds = sw.elapsedTime();

            Ns.addLast(n);
            times.addLast(timeInSeconds);
            opCounts.addLast(M);
        }
        printTimingTable(Ns, times, opCounts);

    }
}
