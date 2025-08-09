package DailyCheckUp.Date_25_08_N.D09;

import java.util.*;
import java.io.*;

public class 백준_8979_올림픽 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        List<Info> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.add(new Info(num, g, s, b));
        }
        Collections.sort(list);

        int grade = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i > 0) {
                Info prev = list.get(i - 1);
                Info curr = list.get(i);
                if (curr.gold != prev.gold || curr.silver != prev.silver || curr.bronze != prev.bronze) {
                    grade = i + 1;
                }
            }

            if (list.get(i).num == k) {
                System.out.println(grade);
                return;
            }
        }
    }

    static class Info implements Comparable<Info> {
        int num, gold, silver, bronze;

        public Info(int num, int gold, int silver, int bronze) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Info o) {
            if (this.gold == o.gold) {
                if (this.silver == o.silver) {
                    return o.bronze - this.bronze;
                }
                return o.silver - this.silver;
            }
            return o.gold - this.gold;
        }
    }
}