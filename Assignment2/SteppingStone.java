package Assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SteppingStone {

    // {1, 3, 4} 칸씩 점프할 수 있을 때 n번째 돌까지 가는 방법 수
    // MOD를 사용하여 출력
    static final int MOD = 25919;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // First line input 't': 테스트 케이스 개수
        int t = Integer.parseInt(br.readLine().trim());
        int[] q = new int[t];
        int maxN = 0;
        
        // 입력을 모두 모아 최대 n을 파악
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            q[i] = n;
            if (n > maxN) maxN = n;
        }

        // DP 전처리: 0..maxN
        int[] dp = new int[Math.max(1, maxN+1)];
        dp[0] = 1;

        for(int i=1; i<=maxN; i++) {
            int val = dp[i-1];  // i-1
            if (i >= 3) {                 // i-3
                val += dp[i - 3];
                if (val >= MOD) val -= MOD;
            }
            if (i >= 4) {                 // i-4
                val += dp[i - 4];
                if (val >= MOD) val -= MOD;
            }
            dp[i] = val;
        }
        StringBuilder sb = new StringBuilder();
        for (int n : q) sb.append(dp[n]).append('\n');
        System.out.print(sb);
        br.close();
    }
}
