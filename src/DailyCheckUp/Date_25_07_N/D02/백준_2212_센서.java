package DailyCheckUp.Date_25_07_N.D02;

import java.util.*;
import java.io.*;

public class 백준_2212_센서 {
    static int N, K;
    static List<Integer> sensors;

    public static void main(String[] args) throws IOException {
        input();

        int minDist = calcMinDist();

        System.out.println(minDist);
    }

    static void input() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); // N개의 센서
        K = Integer.parseInt(br.readLine()); // 최대 K개의 집중국 설치 가능

        // TreeSet: 중복 제거 + 오름차순 정렬
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeSet<Integer> sensorsPos = new TreeSet<>();
        for(int i=0;i<N;i++){
            sensorsPos.add(Integer.parseInt(st.nextToken()));
        }

        sensors = new ArrayList<>(sensorsPos);
    }

    static int calcMinDist(){
        // 인접한 센서간 거리를 내림차순으로 정렬
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int i=0;i<sensors.size()-1;i++){
            int sensor1 = sensors.get(i);
            int sensor2 = sensors.get(i+1);

            boolean sensor1Positive = sensor1 > 0;
            boolean sensor2Positive = sensor2 > 0;
            int dist = (sensor1Positive==sensor2Positive) ? Math.abs(sensor1-sensor2) : Math.abs(sensor1) + Math.abs(sensor2);

            pq.offer(dist);
        }

        // 가장 큰 거리 K-1개 만큼 삭제 == K개의 군집 만들기
        for(int k=0;k<K-1;k++){
            pq.poll();
        }

        // 남은 거리의 합 == 최소 거리
        int res = 0;
        while(!pq.isEmpty()){
            res += pq.poll();
        }

        return res;
    }
}
