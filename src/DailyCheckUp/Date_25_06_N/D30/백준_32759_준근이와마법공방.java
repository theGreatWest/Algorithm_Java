package DailyCheckUp.Date_25_06_N.D30;

import java.util.*;
import java.io.*;

public class 백준_32759_준근이와마법공방 {
    static final long P = 1000000007; // 모듈로 상수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long first = -100000, second = -100000; // 가장 큰, 두번째로 큰 값 저장할 변수; 가능한 가장 작은 값으로 초기화
        for (long a : Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray()) {
            if (a >= first) { // 첫번째로 큰 값 갱신
                second = first;
                first = a;
            } else if (a > second) second = a; // 두 번째로 큰 값 갱신
        }

        long newStone = 0L;
        for (int n = 0; n < N; n++) {
            newStone = first + second;

            if (newStone >= first) {
                second = first;
                first = newStone;
            } else if (newStone > second) second = newStone;

            // 왜 %= P 해주는가?
            // 마나 수치가 long 범위를 넘어가는 경우가 생길 수 있어(오버플로우), 모든 계산을 P로 나눈 나머지 값으로 저장/관리
            first %= P;
            second %= P;
        }

        // 왜 (newStone % mod + mod) % mod 해주는가?
        // 모듈로 연산
        // 일반적으로 음수를 양수로 바꾸기 위해 이런 방식 사용(결과를 0이상 P-1이하의 정수로 만들기 위해)
        // x = P(mod) * q + r 형태에서 r = x mod P 를 의미함
        // r = x mod P = ((x % P) + P) % P
        // 음수 보정이 되지 않기 때문에 (newStone + mod) % mod 방식은 사용하면 안 됨 <- 자바에선 x % P가 음수일 수 있기 때문에
        // (예시)
        //      (-3 % 5) == -3
        //      ((-3 % 5) + 5) % 5 == 2
        System.out.println((newStone % P + P) % P);
    }
}
