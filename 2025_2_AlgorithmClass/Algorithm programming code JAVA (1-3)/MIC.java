import java.util.Scanner;
import java.util.Arrays;


class Interval implements Comparable<Interval> {
    int start;
    int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval p) {
        return this.start - p.start;
    }
}

public class MIC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int rep = 0; rep < t; rep++) {
            int n = sc.nextInt();
            int[] starts = new int[n];
            int[] ends = new int[n];
            Interval[] intervals = new Interval[n];
            for (int i = 0; i < n; i++) starts[i] = sc.nextInt();
            for (int i = 0; i < n; i++) ends[i] = sc.nextInt();
            for (int i = 0; i < n; i++) intervals[i] = new Interval(starts[i], ends[i]);
            Arrays.sort(intervals);
            int cur = intervals[0].start;
            int cnt = 0;
            int i = 0;
            while (i < n) {
                cur = Math.max(cur, intervals[i].start);
                int reach = cur;
                while (i < n && intervals[i].start <= cur) {
                    reach = Math.max(reach, intervals[i].end);
                    i += 1;
                }
                if (cur != reach) cnt += 1;
                cur = reach;
            }
            System.out.println(cnt);
        }
    }
}