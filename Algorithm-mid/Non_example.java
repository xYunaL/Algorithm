import java.util.Scanner;
import java.util.Arrays;

public class Non_example {

    public static int binarysearchfirst(int[] L, int n, int q) {
        // 이진탐색으로 찾고자 하는 것이 l 이상, h 이하이다
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (L[mid] < q) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    public static int binarysearchlast(int[] L, int n, int q) {
        // 이진탐색으로 찾고자 하는 것이 l 이상, h 이하이다
        int l = 0;
        int h = n - 1;
        while (l <= h) {
            int mid = (l + h) / 2;
            if (L[mid] < q) {
                l = mid + 1;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] L = new int[n];
            int[] Q = new int[m];
            for(int j=0; j<n; j++) {
                L[j] = sc.nextInt();
            }
            // Sort the array L
            Arrays.sort(L);
            for(int j=0; j<m; j++) {
                Q[j] = sc.nextInt();
            }
            for(int j=0; j<m; j++) {
                int q = sc.nextInt();
                System.out.print(binarysearchlast(L, n, q) - binarysearchfirst(L, n, q) + " ");
            }
            System.out.println();
        }
        sc.close();
    }    
}
