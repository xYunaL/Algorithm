import java.util.Scanner;
import java.util.Arrays;

//  implement an algorithm to compute the maximum limit ℓ so that every person gets at least ℓ amount of bossam.
public class BossamE {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        // number of test case
        int t = sc.nextInt();
        for (int test_case = 0; test_case < t; test_case++) {
            // number n of people coming (3 ≤ n ≤ 10, 000)
            int n = sc.nextInt();
            // n desired amounts m1, ... , mn of the people (1 ≤ mi ≤ 100, 000)
            int[] L = new int[n];
            for(int i=0; i<n; i++) {
                L[i] = sc.nextInt();
            }   
            Arrays.sort(L);
            // total amount T of bossam (n ≤ T ≤ 1, 000, 000, 000).
            int T = sc.nextInt();
    



            // print the maximum desired amount.
            System.out.println();        
        }
    
        sc.close();
    }
}
