package DailyCheckUp.Date_25_07_N.D03;

import java.io.*;
import java.math.BigInteger;

public class 백준_1914_하노이탑 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // 2^n 은 64이상일 때, long 범위를 넘어서 오차 발생
        // ==> BigInter : 데이터 크기 제한 없음. 속도는 느리지만 제한 없이 큰 수 다루기 가능
        // BigInter.valueOf(2) : 기본 타입을 BigInter 객체로 변환
        // BigInter.valueOf(n).pow(r) : n의 r제곱 구하기
        // subtract(BigInteger val) : 두 BigInter 값의 뺄셈 수행
        // BigInter.ONE : 상수로 1 의미
        System.out.println(BigInteger.valueOf(2).pow(n).subtract(BigInteger.ONE));
        if (n <= 20) {
            move(n, 1, 3, 2);
            bw.flush(); // StringBuilder 사용 시 메모리 초과/시간 초과가 난다면 BufferedWriter 사용할 것
        }
    }

    static void move(int n, int from, int to, int via) throws IOException {
        if (n == 1) {
            bw.write(from+" "+to+"\n");
        } else {
            move(n - 1, from, via, to); // 타겟 원판 -> 임시 기둥
            bw.write(from+" "+to+"\n");
            move(n - 1, via, to, from); // 타켓 원판 -> 목적지
        }
    }
}
