package DailyCheckUp.Date_25_03_N.D10;

import java.util.*;
import java.io.*;

public class 백준_6064_카잉달력_ing {
    static int M, N, x, y;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            M = tmp[0];
            N = tmp[1];
            x = tmp[2];
            y = tmp[3];

            int count = -1;
            for(int i=x;i<=lcm(M, N);i+=M){
                if(i%N == y%N){ // i%N == y 는 정확하지 않을 수 있다.
                    count = i;
                    break;
                }
            }

            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    static int gcd(int a, int b) {
        while (b != 0) {
            int tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//
//        StringBuilder sb = new StringBuilder();
//        while (T-- > 0) {
//            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            M = tmp[0];
//            N = tmp[1];
//            x = tmp[2];
//            y = tmp[3];
//
//            int year = -1; // 정답을 저장할 변수
//            for (int i = x; i <= M * N; i += M) { // x부터 시작해서 M씩 증가
//                if (i % N == y) { // y번째 해인지 확인하는 과정
//                    year = i;
//                    break;
//                }
//            }
//            /*
//                M 주기로 반복 -> i = x % M 을 만족
//                N 주기로 반복 -> j = y % N 을 만족
//
//                핵심 : x 부터 시작해서 M 씩 증가하는 숫자 중, y 와 같은 N 주기를 가지는 해를 찾자
//
//                1. x부터 시작해야 하므로, x % M == x 가 성립해야
//                2. 그러면서도 y % N == y 인 i 를 찾아야
//                3. 결국, x%M==x, y%M==y 둘 다 만족하는 숫자를 찾아야 하는 것
//                4. 아... 이해했어... 1부터 N, M까지 반복되고, 처음 시작하는 숫자가 1이기 때문에 그냥 계속 1~> 해주는거구나. 그 숫자에서 %N, %M 하면서 숫자를 확인하는거고..!!
//            */
//
//            sb.append(year).append("\n");
//        }
//
//        System.out.println(sb);
//    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder res = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//
//        while (T-- > 0) {
//            int[] tmp = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//            M = tmp[0];
//            N = tmp[1];
//            x = tmp[2];
//            y = tmp[3];
//
//            res.append(findYear()).append("\n");
//        }
//        System.out.print(res);
//    }
//
//    static int findYear() {
//        int lcm = lcm(M, N); // 최소공배수를 구해 탐색 범위를 제한한다.
//
//        for (int i = x; i <= lcm; i += M) { // x를 M씩 증가시키며 탐색
//            if (i % N == y % N) return i;
//        }
//
//        return -1;
//    }
//
//    static int lcm(int a, int b) {// 최소공배수
//        return a * (b / gcd(a, b)); // 최소공배수 = (a * b) / 최대공약수
//    }
//
//    static int gcd(int a, int b) { // 최대 공약수
//        while (b != 0) {
//            int tmp = a % b;
//            a = b;
//            b = tmp;
//        }
//        return a;
//    }
}
