package baekjoon.Silver;

import java.util.*;
import java.io.*;

public class S1_1124 {
    public static void main(String[] args) throws Exception {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 2 ≤ A ≤ B ≤ 100,000
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        
        // 1. 소인수의 개수를 저장할 배열
        int[] factorCount = new int[B+1];
        // 2. 소수 여부를 저장할 배열 (에라토스테네스의 체)
        boolean[] isNotPrime = new boolean[B+1];
        isNotPrime[0] = isNotPrime[1] = true;

        // 에라토스테네스의 체 + 소인수 개수 누적
        for (int i=2; i<=B; i++) {
            if(!isNotPrime[i]) { // i가 소인수라면
                // i의 배수들에 대해 소인수 개수를 추가함
                for(int j=i; j<= B; j +=i) {
                    isNotPrime[j] = (j != i);
                    // 핵심: j를 i로 나누어 떨어질 때까지 나누며 개수 카운트
                    int temp = j;
                    while(temp % i == 0) {
                        factorCount[j]++;
                        temp /= i;
                    }
                }
            }
        }
        int underPrimeCount = 0;
        for(int i=A; i<=B; i++) {
            // factorCount[i]가 소수이면 언더프라임!
            if(!isNotPrime[factorCount[i]]) {
                underPrimeCount++;
            }
        }
        System.out.println(underPrimeCount);
        br.close();
    }
    
}
