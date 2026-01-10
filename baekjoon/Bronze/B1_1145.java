package baekjoon.Bronze;

import java.util.*;
import java.io.*;

// 다섯 개의 자연수 (n<=100, 서로 다른 수)
// 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수는?
// 5C3 경우(10가지)의 최소공배수를 모두 구해서 가장 작은거 출력
public class B1_1145 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] list = new int[5];
        for(int i=0; i<list.length; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }

        int[] answer = new int[10];
        int count = 0;

        for(int i=0; i<5; i++) {
            for(int j=0; j<5; j++) {
                if((i!=j) && (i<j)) {
                    for(int k=0; k<5; k++) {
                        if((j!=k) && (j<k)) {
                            answer[count] = lcm(list[i], list[j], list[k]);
                            count++;
                        }
                    }
                }
            }
        }
        Arrays.sort(answer);
        System.out.println(answer[0]);
        br.close();
    }

    private static int lcm(int a, int b, int c) {
        int temp = a*b / gcd(a, b);
        return temp*c / gcd(temp, c);
    }

    private static int gcd(int a, int b) {
        while(b!=0) {
            int temp = b;
            b = a%b;
            a = temp;
        }
        return a;
    }
    
}
