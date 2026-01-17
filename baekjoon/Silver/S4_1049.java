package baekjoon.Silver;

import java.util.*;
import java.io.*;

public class S4_1049 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());    // 끊어진 기타줄 N개
        int M = Integer.parseInt(st.nextToken());    // 기타줄 브랜드 M개

        // 초기값을 최댓값(1000)보다 조금 더 큰 수나 Integer.MAX_VALUE로 설정
        int minPack = 1001; 
        int minUnit = 1001;

        // 1. 입력과 동시에 최솟값 찾기 (O(M))
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int pack = Integer.parseInt(st.nextToken());
            int unit = Integer.parseInt(st.nextToken());

            minPack = Math.min(minPack, pack);
            minUnit = Math.min(minUnit, unit);
        }

        minPack = Math.min(minPack, minUnit * 6);

        int costMix = (N / 6) * minPack + (N % 6) * minUnit;
        int costAllPack = ((N/6) + 1) * minPack;

        int result = Math.min(costMix, costAllPack);

        // 기타줄을 적어도 N개 사기 위해 필요한 돈의 최솟값을 출력
        System.out.println(result);
        br.close();
    }
}