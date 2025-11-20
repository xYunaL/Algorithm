import java.util.Scanner;
import java.util.Arrays;


public class NoN {
    public static int binsearchfirst(int[] L, int n, int q) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (L[mid] < q) low = mid + 1;
            else high = mid - 1;
        }
        return low;
    }

    public static int binsearchlast(int[] L, int n, int q) {
        int low = 0;
        int high = n-1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (L[mid] <= q) low = mid + 1;
            else high = mid - 1;
        }
        return high;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[] L = new int[n];
            for (int j = 0; j < n; j++) {
                L[j] = sc.nextInt();
            }
            Arrays.sort(L);
            for (int j = 0; j < m; j++) {
                int q = sc.nextInt();
                System.out.print(binsearchlast(L,n,q)-binsearchfirst(L,n,q)+1);
                System.out.print(' ');
            }
            System.out.println();
        }
        sc.close();
    }
}