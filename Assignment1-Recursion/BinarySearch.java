import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// #1-3. Binary Search
public class BinarySearch {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] L = new int[n];
            int[] Q = new int[m];

            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                L[j] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<m; j++) {
                Q[j] = Integer.parseInt(st.nextToken());
            }

            // 이진 탐색 수행
            for (int j=0; j<m; j++) {
                if (j > 0) sb.append(' ');
                int result = binarySearch(L, 0, n-1, Q[j]);
                sb.append(result);
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

    // 이진 탐색 재귀 함수
    // arr[lo..hi] 범위에서 key의 인덱스를 찾음 (없으면 -1)
    static int binarySearch(int[] arr, int lo, int hi, int key) {
        // 탐색 실패
        if (lo > hi) return -1;
        // 중간 인덱스 계산 (overflow 방지)
        int mid = lo + ((hi-lo) >>> 1);
        // 탐색 성공
        if(arr[mid] == key) return mid;
        // 왼쪽 부분 탐색
        else if(arr[mid] > key) return binarySearch(arr, lo, mid-1, key);
        // 오른쪽 부분 탐색
        else return binarySearch(arr, mid+1, hi, key);
    }
}

// Input Example
// 2
// 5 3
// 1 2 3 4 5
// -1 3 4
// 3 5
// 1 3 5
// 1 2 3 4 5

// Output Example
// -1 2 3
// 0 -1 1 -1 2

