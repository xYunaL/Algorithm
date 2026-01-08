import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Mininum_Interval_Cover {

    class Interval implements Comparable<Interval> {
        int left;
        int right;

        public Interval(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
    
    // print the size of a minimum interval cover.
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());    // number of test case
        
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());    // number of intervals
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] left_ep = new int[n];    // left endpoints
            int[] right_ep = new int[n];   // right endpoints
            Interval[] intervals = new Interval[n]; // left+right endpoints

            for(int j=0; j<n; j++) left_ep[j] = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) right_ep[j] = Integer.parseInt(st.nextToken());
            for(int j=0; j<n; j++) intervals[j] = new Interval(left_ep[j], right_ep[j]);
            Arrays.sort(intervals);

        }
        
        br.close();
    }
}
