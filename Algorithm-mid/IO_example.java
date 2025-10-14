import java.util.Scanner;

public class IO_example {

    // public static int countopers(int n, int i, int[] opers, int T) {
    //     // i: 지금까지 사용한 연산자의 개수
    //     if(n-1 == i) {
    //         int res = 0;
    //         int curnum = 1;
    //         int curop = 1;
    //         for(int j=0; j<n-1; j++) {
    //             if(opers[j] == 0) curnum = curnum *10 +j +2;
    //             else {

    //             }
    //         }

    //     }
    //     else {
    //         int res = 0;
    //         opers[i] = 0; // +
    //         res += countopers(n, i+1, opers, T);
    //         opers[i] = 1; // -
    //         res += countopers(n, i+1, opers, T);
    //         opers[i] = -1; // (concatenate)
    //         res += countopers(n, i+1, opers, T);
    //         return res;
    //     }
    // }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i=0; i<t; i++) {
            int n = sc.nextInt();
            int T = sc.nextInt();
            int[] opers = new int[n-1];
            // System.out.println(countopers(n, 0, opers, T));
        }
    
    
    }
    
}
