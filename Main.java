import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            if(n > 0) {
                hanoi(n, 'A', 'B', 'C', sb);
            }
        }
        System.out.println(sb.toString());
    }

    /**
     * 하노이 재귀 함수
     * @param k    옮길 접시 개수
     * @param from 출발 기둥
     * @param aux  보조 기둥
     * @param to   도착 기둥
     * @param sb  출력 버퍼
     */
    public static void hanoi(int k, char from, char aux, char to, StringBuilder sb) {
        if(k == 0) return;
        // k-1개를 from -> aux 로 이동
        hanoi(k-1, from, to, aux, sb);
        // 경로 기록 저장
        sb.append(from).append(' ').append(to).append(' ').append(k).append('\n');
        // aux에 있는 k-1를 to로 이동
        hanoi(k-1, aux, from, to, sb);
    }
}
