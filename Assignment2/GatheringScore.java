package Assignment2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GatheringScore {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder out = new StringBuilder();

        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // n, m
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[] dp = new long[m];
            long[] row = new long[m];

            // ---- 첫 번째 행 처리 ----
            fillRow(br, row, m);
            dp[0] = row[0];
            for (int j = 1; j < m; j++) dp[j] = dp[j - 1] + row[j];

            // ---- 나머지 행 처리 ----
            for (int i = 1; i < n; i++) {
                fillRow(br, row, m);
                dp[0] = dp[0] + row[0]; // 첫 열: 위에서만 내려올 수 있음
                for (int j = 1; j < m; j++) {
                    dp[j] = Math.max(dp[j], dp[j - 1]) + row[j];
                }
            }

            out.append(dp[m - 1]).append('\n');
        }

        System.out.print(out);
    }

    // m개의 숫자가 모두 채워질 때까지 안전하게 읽기 (공백/개행 자유)
    private static void fillRow(BufferedReader br, long[] row, int m) throws Exception {
        int filled = 0;
        while (filled < m) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && filled < m) {
                row[filled++] = Long.parseLong(st.nextToken());
            }
        }
    }
}