package baekjoon.Bronze;

import java.io.*;

// 1. 먼저 주어진 수가 10보다 작다면 앞에 0을 붙여 두 자리 수로 만들고
// 2. 각 자리의 숫자를 더한다
// 3. 주어진 수의 가장 오른쪽 자리 수와 앞에서 구한 합의 가장 오른쪽 자리 수를 이어 붙이면 끝

public class B1_1110 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());    // 0 < N < 99
        int cycle=0;
        int oldNum=N;
        int newNum=0;

        if(N==0) cycle=1;

        newNum = ((oldNum%10)*10) + (((oldNum/10) + (oldNum%10))%10);
        if(N != newNum) cycle++;

        while(N != newNum) {
            oldNum = newNum;
            newNum = ((oldNum%10)*10) + (((oldNum/10) + (oldNum%10))%10);
            cycle++;
        }

        System.out.println(cycle);
        br.close();
    }
}
