package baekjoon.Silver;

import java.io.*;

public class S3_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());    // Test Case 개수
        
        int[][] fiboList = new int[41][2];
        fiboList = fibonacci();

        for(int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());    // 0 <= N <= 40
            sb.append(fiboList[N][0]).append(" ").append(fiboList[N][1]);
            sb.append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static int[][] fibonacci() {
        int[][] fiboList = new int[41][2];
        for(int i=0; i<41; i++) {
            if(i==0) {
                fiboList[i][0] = 1;
                fiboList[i][1] = 0;
            } else if(i == 1) {
                fiboList[i][0] = 0;
                fiboList[i][1] = 1;
            } else {
                fiboList[i][0] = fiboList[i-1][0] + fiboList[i-2][0];
                fiboList[i][1] = fiboList[i-1][1] + fiboList[i-2][1];
            }
        }
        return fiboList;
    }
}