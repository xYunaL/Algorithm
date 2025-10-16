package Assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // First line input 't': 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine().trim());
        for(int i=0; i<t; i++) {
            
            int n = Integer.parseInt(br.readLine().trim());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] list = new int[n];

            for(int j=0; j<n; j++) {
                list[j] = Integer.parseInt(st.nextToken());
            }

            // LIS
            int[] tails = new int[n];
            int len = 0;
            for(int x: list) {
                int lo = 0, hi = len;
                while(lo<hi) {
                    int mid = (lo+hi) >>> 1;
                    if(tails[mid] < x) lo = mid + 1;
                    else hi = mid;
                }
                tails[lo] = x;
                if(lo == len) len++;
            }
            sb.append(len).append('\n');
        }
        System.out.print(sb);
    }
}
