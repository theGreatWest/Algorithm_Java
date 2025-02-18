package 그래프.위상정렬;

import java.io.*;
import java.util.*;

public class 백준_1948_임계경로 {
    static int n, m, startCity, endCity;
    static List<int[]>[] adj, revAdj; // 인접리스트, 역방향 인접리스트
    static int[] time, indegree; // 도시간 시간, 진입 차수
    static int[][] cost; // 각 도시 간 도로 시간
    static boolean[] visited; // 역추적시 방문 체크
    static int meetTime; // 목적지까지 가는 최소 시간
    static int criticalRoadCount; // 1초도 쉬지 못하는 도로의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        adj = new ArrayList[n + 1]; // 인접리스트
        revAdj = new ArrayList[n + 1]; // 역방향 인접리스트
        time = new int[n + 1]; // 각 도시까지 가는 최소 시간
        indegree = new int[n + 1]; // 진입 차수
        cost = new int[n + 1][n + 1]; // 도시간 도로 시간
        visited = new boolean[n + 1]; // 방문 체크

        for (int i = 1; i <= n; i++) {
            adj[i] = new ArrayList<>();
            revAdj[i] = new ArrayList<>();
        }

        // 도로 정보 입력
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            adj[start].add(new int[]{end, t});
            indegree[end]++;
            cost[start][end] = t;

            revAdj[end].add(new int[]{start, t}); // 역추적 방향 그래프
        }

        st = new StringTokenizer(br.readLine());
        startCity = Integer.parseInt(st.nextToken());
        endCity = Integer.parseInt(st.nextToken());

        // 위상 정렬을 통한 최단 시간 계산
        meetTime = topologicalSort(startCity);

        // 1초도 쉬지 못하는 도로 수 구하기
        countCriticalRoads(startCity, endCity);

        // 출력
        System.out.println(meetTime);
        System.out.println(criticalRoadCount);
    }

    // 위상 정렬을 통한 최단 시간 계산
    static int topologicalSort(int startCity) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(startCity);
        time[startCity] = 0;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int[] next : adj[current]) {
                int nextCity = next[0];
                int travelTime = next[1];

                time[nextCity] = Math.min(time[nextCity], time[current] + travelTime);
//
//                if (time[nextCity] < time[current] + travelTime) {
//                    time[nextCity] = time[current] + travelTime;
//                }

                if (--indegree[nextCity] == 0) {
                    q.offer(nextCity);
                }
            }
        }

        return time[endCity]; // 최종 목적지까지 가는 최소 시간
    }

    // 역추적을 통해 1초도 쉬지 못하는 도로 수 구하기
    static void countCriticalRoads(int startCity, int endCity) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(endCity);
        visited[endCity] = true;

        while (!q.isEmpty()) {
            int current = q.poll();
            for (int[] prev : revAdj[current]) { // 역방향 인접 시=리스트 탐색
                int prevCity = prev[0];
                int travelTime = prev[1];

                // 만약 이 도로가 최단 경로에 포함된다면
                if (time[current] == time[prevCity] + travelTime) {
                    // 이 도로는 최단 경로를 구성하는 도로이므로 카운트
                    criticalRoadCount++;

                    if (!visited[prevCity]) {
                        visited[prevCity] = true;
                        q.offer(prevCity);
                    }
                }
            }
        }
    }
}