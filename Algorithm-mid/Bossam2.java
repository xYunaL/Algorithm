import java.util.Scanner;

public class Bossam2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] des = new int[n];
            int maxdes = 1;
            for (int j = 0; j < n; j++) {
                des[j] = sc.nextInt();
                if (maxdes < des[j]) maxdes = des[j];
            }
            int amount = sc.nextInt();
            int l = 1;
            int h = maxdes;
            while (l <= h) {
                int mid = (l + h) / 2;
                int pieces = 0;
                for (int j = 0; j < n; j++) {
                    if (mid > des[j]) pieces += des[j];
                    else pieces += mid;
                    if (pieces > amount) break;
                }
                if (pieces > amount) h = mid - 1;
                else l = mid + 1;
            }
            System.out.println(h);
        }
        sc.close();
    }
}