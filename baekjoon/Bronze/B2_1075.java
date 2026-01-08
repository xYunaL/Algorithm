package baekjoon.Bronze;

import java.io.*;

public class B2_1075 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 100 <= N <= 2,000,000,000
        int F = Integer.parseInt(br.readLine()); // F <= 100

        int A = (N/100) * 100;
        int B = (A/F) * F;
        while(B<A){
            B += F;
        }
        String answer = B+"";
		System.out.println(answer.substring(answer.length()-2));
        br.close();
    }
}