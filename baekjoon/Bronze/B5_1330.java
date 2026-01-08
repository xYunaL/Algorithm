package baekjoon.Bronze;

import java.util.*;
import java.io.*;

public class B5_1330 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int first = Integer.parseInt(st.nextToken());
        int second = Integer.parseInt(st.nextToken());
        if (first>second) System.out.println(">");
        else if (first<second) System.out.println("<");
        else System.out.println("==");
        br.close();
    }
}
