package 그래프.유니온파인드;

import java.util.*;
import java.io.*;

public class 백준_1717_집합의표현 {
    static int n, m;
    static int[] arr;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        // [합집합] 연산 & [두 원소가 같은 집합에 포함]되어 있는지 확인
        // 완전 [ 유니온 파인드 ] 문제

        // 0 a b -> a가 들어있는 집합과 b가 들어있는 집합 합치기
        // 1 a b -> a와 b가 같은 집합에 들어있는지 확인하기

        // 배열 index == value 의 형태로 초기화
        arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for (int c = 0; c < m; c++) {
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (order == 0) {
                union(a, b);
            } else {
                sb.append(checkSame(a, b)).append("\n");
            }
        }
        System.out.print(sb);
    }

    // 집합 합치기
    static void union(int a, int b) {
        a = find(a);
        b = find(b);

        if (a != b) {
            arr[b] = a;
        }
    }

    // ⭐️ 같은 집합의 원소인지 확인
    static int find(int a) {
        if (arr[a] == a) {
            return a;
        } else {
            return arr[a] = find(arr[a]); // 재귀함수 형태로 구현
        }
    }

    // 같은 값인지 확인
    static String checkSame(int a, int b) {
        a = find(a);
        b = find(b);

        return (a == b) ? "YES" : "NO";
    }
}
