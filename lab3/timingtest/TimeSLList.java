package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

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
        AList Ns = new AList();
        AList times = new AList();
        AList opcounts = new AList();
        int ce = 1000;
        for(int i = 1; i <= 8; ++i){
            if(i == 1){
                Ns.addLast(ce);
            }
            else{
                int temp = (int) Ns.getLast();
                Ns.addLast(temp * 2);
            }
        }
        int m = 900;
        for(int i = 0; i < 8; ++i){
            int size = (int) Ns.get(i);
            SLList temp = new SLList();
            for(int k = 1; k <= size; ++k){
                temp.addLast(k);
            }
            Stopwatch sw = new Stopwatch();
            for(int k = 1; k <= m; ++k){
                int tt = (int) temp.getLast();
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opcounts.addLast(size);
        }
        printTimingTable(Ns,  times,  opcounts);
    }

}
