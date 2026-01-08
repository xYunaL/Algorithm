package baekjoon.Bronze;

import java.io.*;

public class B5_9498 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        String alpabet;

        if(90<=score && score<=100) alpabet = "A";
        else if(80<=score && score<=89 ) alpabet = "B";
        else if(70<=score && score<=79 ) alpabet = "C";
        else if(60<=score && score<=69 ) alpabet = "D";
        else alpabet = "F";
        
        System.out.println(alpabet);
        br.close();
    }
}