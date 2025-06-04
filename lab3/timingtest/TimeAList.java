package timingtest;
import edu.princeton.cs.algs4.Stopwatch;

/**
 * Created by hug.
 */
public class TimeAList {
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
        timeAListConstruction();
    }

    public static void timeAListConstruction() {
        AList Ns = new AList();
        AList times = new AList();
        AList opCounts = new AList();
        int ce = 1000;
        for(int i = 1; i <= 8; ++i){
            if(i == 1){
                Ns.addLast(ce);
            }
            else{
                int temp = (int) Ns.get(i - 2);
                Ns.addLast(temp * 2);
            }
        }
        for(int i = 0; i < 8; ++i){
            int size = (int) Ns.get(i);
            Stopwatch sw = new Stopwatch();
            AList temp = new AList();
            for(int k = 1; k <= size; ++k){
                temp.addLast(k);
            }
            double timeInSeconds = sw.elapsedTime();
            times.addLast(timeInSeconds);
            opCounts.addLast(size);
        }
        printTimingTable( Ns,  times,  opCounts);
    }
}
