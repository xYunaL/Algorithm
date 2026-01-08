import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		// 상근이가 가지고 있는 카드
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		// HashMap 리사이징 방지를 위해 N*2로 크기 지정
		Map<Integer, Integer> countMap = new HashMap<>(N*2);
		
		for(int i=1; i<=N; i++) {
			int num = Integer.parseInt(st.nextToken());
			countMap.put(num, countMap.getOrDefault(num, 0)+1);
		}
		
		// 주어진 카드 M개
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i=0; i<M; i++) {
			int num = Integer.parseInt(st.nextToken());
			sb.append(countMap.getOrDefault(num, 0));
			if(i<M-1) {
				sb.append(' ');
			}
		}		
		System.out.print(sb.toString());
		br.close();
	}
}
