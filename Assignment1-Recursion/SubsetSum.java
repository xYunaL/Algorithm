import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class SubsetSum {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            long[] X = new long[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            long sumAll = 0;
            for (int i = 0; i < n; i++) {
                X[i] = Long.parseLong(st.nextToken());
                sumAll += X[i];
            }

            long target = Long.parseLong(br.readLine().trim());

            // 빠른 판정
            if (target == 0) { sb.append("YES\n"); continue; }   // 공집합 허용
            if (target < 0)  { sb.append("NO\n");  continue; }   // 양수들의 합으로 음수 불가
            if (sumAll < target) { sb.append("NO\n"); continue; } // 전체 합이 작으면 불가

            // Meet-in-the-Middle
            int mid = n / 2;
            long[] leftSums  = subsetSums(X, 0, mid);
            long[] rightSums = subsetSums(X, mid, n - mid);

            if (contains(leftSums, target) || contains(rightSums, target)) {
                sb.append("YES\n");
                continue;
            }

            Arrays.sort(rightSums);

            boolean found = false;
            for (long s : leftSums) {
                if (s > target) continue; // 오른쪽은 양수 합이므로 s>target이면 불가능
                long need = target - s;
                if (Arrays.binarySearch(rightSums, need) >= 0) {
                    found = true;
                    break;
                }
            }
            sb.append(found ? "YES\n" : "NO\n");
        }

        System.out.print(sb.toString());
    }

    // arr[start .. start+len-1]의 모든 부분집합 합 (크기 2^len)
    static long[] subsetSums(long[] arr, int start, int len) {
        int size = 1 << len;
        long[] sums = new long[size];
        // sums[0] = 0 (공집합)
        for (int mask = 1; mask < size; mask++) {
            int lsb = mask & -mask; // 최하위 set bit
            int bit = Integer.numberOfTrailingZeros(lsb);
            sums[mask] = sums[mask ^ lsb] + arr[start + bit];
        }
        return sums;
    }

    static boolean contains(long[] a, long target) {
        for (long v : a) if (v == target) return true;
        return false;
    }
}