package 그래프.유니온파인드;

import java.util.*;
import java.io.*;

public class 백준_1976_여행가자 {
    static int n, m;
    static int[] cities;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        cities = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            cities[i] = i;
        }

        for (int city = 1; city <= n; city++) {
            st = new StringTokenizer(br.readLine());
            for (int pairCity = 1; pairCity <= n; pairCity++) {
                int pair = Integer.parseInt(st.nextToken());
                if (pair == 1) union(city, pairCity);
            }
        }

        st = new StringTokenizer(br.readLine());
        int[] plannedCities = new int[m];
        for (int M = 0; M < m; M++) {
            plannedCities[M] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < m - 1; i++) {
            if(!isConnectedCity(plannedCities[i], plannedCities[i+1])){
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    // 연결된 제일 작은 번호 찾고 반환
    static int find(int name) {
        if (cities[name] == name) return name;
        return cities[name] = find(cities[name]);
    }

    // 같은 집합이 아니라면 두개의 도시 집합으로 연결
    static void union(int a, int b) {
        int big = Math.max(a, b);
        int small = Math.min(a, b);

        big = find(big);
        small = find(small);

        if (big != small) cities[big] = small;
    }

    // 같은 집합에 속해 있는지 판단
    static boolean isConnectedCity(int a, int b) {
        a = find(a);
        b = find(b);

        return a == b;
    }
}
