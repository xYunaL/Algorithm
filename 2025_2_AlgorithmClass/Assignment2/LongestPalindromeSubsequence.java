package Assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class LongestPalindromeSubsequence {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine().trim(); // S는 영문자로만 구성 (공백 없음 가정)

            int[] dp = new int[n]; // dp[j] = LPS length for S[i..j]
            for (int i = n - 1; i >= 0; i--) {
                dp[i] = 1;        // 길이 1: 자기 자신만으로 팰린드롬
                int prev = 0;     // 이전 행의 dp[j-1] (S[i+1..j-1] LPS)
                for (int j = i + 1; j < n; j++) {
                    int temp = dp[j]; // 다음 j에서 prev로 쓰기 위해 백업
                    if (s.charAt(i) == s.charAt(j)) {
                        dp[j] = prev + 2;
                    } else {
                        dp[j] = Math.max(dp[j], dp[j - 1]);
                    }
                    prev = temp;
                }
            }
            out.append(dp[n - 1]).append('\n'); // S[0..n-1]의 LPS 길이
        }

        System.out.print(out);
    }
}
