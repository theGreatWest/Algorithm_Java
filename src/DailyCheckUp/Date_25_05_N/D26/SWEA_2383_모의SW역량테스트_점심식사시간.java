package DailyCheckUp.Date_25_05_N.D26;

import java.io.*;
import java.util.*;

public class SWEA_2383_모의SW역량테스트_점심식사시간 {
    static int N, res;
    static int[][] room;
    static List<int[]> person, stair;
    static int[] useStairNum;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());

            person = new ArrayList<>();
            stair = new ArrayList<>();
            room = new int[N][N];
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    room[i][j] = Integer.parseInt(st.nextToken());

                    if (room[i][j] == 1) person.add(new int[]{i, j});
                    else if (room[i][j] > 1) stair.add(new int[]{i, j, room[i][j]});
                }
            }

            // 각 사람이 이용할 계단을 dfs로 완전 탐색 - 백트래킹
            res = Integer.MAX_VALUE;
            useStairNum = new int[person.size()];
            dfs(0);


            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static void dfs(int idx) {
        if (idx == person.size()) {
            lunch();
            return;
        }

        int nextIdx = idx + 1;

        // 0번 계단 선택할 때
        useStairNum[idx] = 0;
        dfs(nextIdx);

        // 1번 계단 선택할 때
        useStairNum[idx] = 1;
        dfs(nextIdx);
    }

    static void lunch() {
        PriorityQueue<Set> pq = new PriorityQueue<>();
        for (int pi = 0; pi < useStairNum.length; pi++) {
            pq.offer(new Set(pi, useStairNum[pi]));
        }

        Queue<Set> s0 = new LinkedList<>();
        Queue<Set> s0wait = new LinkedList<>();

        Queue<Set> s1 = new LinkedList<>();
        Queue<Set> s1wait = new LinkedList<>();

        for (int min = 1; min <= 100; min++) {
            if (pq.isEmpty()
                    && s0.isEmpty() && s0wait.isEmpty()
                    && s1.isEmpty() && s1wait.isEmpty()) {
                res = Math.min(res, min);
                break;
            }

            // 해당 시간에 이용 시간이 끝나는 사람이 있는 경우
            while (!s0.isEmpty()) {
                Set curr = s0.peek();
                if (curr.endTime == min) {
                    s0.poll();
                } else break;
            }
            while (s0.size() < 3 && !s0wait.isEmpty()) {
                Set curr = s0wait.poll();
                s0.offer(new Set(curr.pNum, curr.sNum, min));
            }
            while (!s1.isEmpty()) {
                Set curr = s1.peek();
                if (curr.endTime == min) {
                    s1.poll();
                } else break;
            }
            while (s1.size() < 3 && !s1wait.isEmpty()) {
                Set curr = s1wait.poll();
                s1.offer(new Set(curr.pNum, curr.sNum, min));
            }

            // 해당 시간에 계단에 도착하는 사람이 있을 경우
            while (!pq.isEmpty()) {
                Set curr = pq.peek();

                if (curr.arrivedTime == min) {
                    curr = pq.poll();
                    if (curr.sNum == 0) {
                        if (s0.size() < 3) s0.offer(curr);
                        else s0wait.offer(curr);
                    } else {
                        if (s1.size() < 3) s1.offer(curr);
                        else s1wait.offer(curr);
                    }
                } else break;
            }
        }
    }

    static class Set implements Comparable<Set> {
        int pNum;
        int sNum;
        int arrivedTime;
        int endTime;

        public Set(int pNum, int sNum) {
            this.pNum = pNum;
            this.sNum = sNum;

            this.arrivedTime = getArrivedTime();
            this.endTime = this.arrivedTime + stair.get(sNum)[2];
        }

        public Set(int pNum, int sNum, int startMin) {
            this.pNum = pNum;
            this.sNum = sNum;
            this.endTime = startMin + stair.get(sNum)[2];
        }

        int getArrivedTime() {
            int[] p = person.get(pNum);
            int[] s = stair.get(sNum);
            return Math.abs(p[0] - s[0]) + Math.abs(p[1] - s[1]);
        }

        @Override
        public int compareTo(Set o) { // 도착 시간이 빠른 순서
            return this.arrivedTime - o.arrivedTime;
        }
    }
}
