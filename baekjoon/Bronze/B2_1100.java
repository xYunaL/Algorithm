package baekjoon.Bronze;

import java.io.*;

// 하얀 칸 위에 말이 몇 개 있는지 출력하는 프로그램
public class B2_1100 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count=0;

        for(int i=0; i<8; i++) {

            String line = br.readLine();
            char[] chars = line.toCharArray();

            for(int j=0; j<8; j++) {
                if((i+j) % 2 == 0) {
                    // white
                    if(chars[j] == 'F') count++;
                }
            }
        }
        System.out.println(count);
        br.close();
    }
}