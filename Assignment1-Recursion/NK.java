import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NK {
    static final long MOD = 25919L;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long n = Long.parseLong(st.nextToken());
            long k = Long.parseLong(st.nextToken());
            sb.append(modPow(n % MOD, k)).append('\n');
        }
        System.out.println(sb.toString());
    }

    // 거듭제곱: (base^exp) % MOD
    private static long modPow(long base, long exp) {
        if (exp == 0) return 1L;
        long result = 1L;
        long b = base % MOD;
        long e = exp;

        while(e > 0) {
            // exp가 홀수이면, result에 base 곱하기
            if((e & 1L) == 1L) {
                result = (result * b) % MOD;
            }
            // base 제곱
            b = (b * b) % MOD;
            // exp를 반으로 줄이기
            e >>= 1;
        }
        return result;
    }
}

// '모듈로(modulo)'는 컴퓨터 과학 및 수학에서 어떤 숫자를 
// 다른 숫자로 나눈 나머지(remainder)를 구하는 연산을 의미하며, 
// '나머지 연산'이라고도 합니다.

/**
 * Input Example
 * 3
 * 2 3
 * 100 0
 * 1000 250918
 * 
 * Output Example
 * 8
 * 1
 * 3422
 */