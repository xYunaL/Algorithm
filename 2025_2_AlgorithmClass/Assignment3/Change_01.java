package Assignment3;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 5만원, 1만원, 5천원, 1천원
// 최소 지폐 개수 계산 알고리즘
public class Change_01 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        int[] bills = {50000, 10000, 5000, 1000};
        
        for(int i=0; i<t; i++) {
            int money = Integer.parseInt(br.readLine());
            int count = 0;
            for(int bill: bills) {
                count += money/bill;    // 오만원부터 나눔
                money %= bill;          // 남은 금액
            }
            sb.append(count).append('\n');
        }
        System.out.println(sb);
        br.close();
    }
}
