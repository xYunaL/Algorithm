package baekjoon.Bronze;

import java.io.*;
import java.util.*;

// 개수 세기

public class B5_10807 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count=0;

        int[] list = new int[N];
        for(int i=0; i<N; i++) {
            list[i] = Integer.parseInt(st.nextToken());
        }
        int v = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++) {
            if(v == list[i]) count++;
        }
        System.out.println(count);
    }
}
