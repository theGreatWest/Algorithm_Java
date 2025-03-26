package DailyCheckUp.Date_25_03_N.D26;

import java.util.*;
import java.io.*;

public class 백준_7568_덩치 {
//    // Solution 2. 우선순위 큐 이용 -> 개별 비교가 정확하기 때문에 우선순위 큐를 이용한 방식은 맞지 않다.
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int n = Integer.parseInt(br.readLine());
//
//        PriorityQueue<Person> pq = new PriorityQueue<>();
//        Person[] person = new Person[n];
//        for(int i=0;i<n;i++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            Person p = new Person(i, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
//            pq.offer(p);
//            person[i] = p;
//        }
//
//        String[] res = new String[n];
//        Person prev = pq.poll();
//        int tot = 1, compO = 1;
//        res[prev.idx] = "1";
//
//        while(!pq.isEmpty()){
//            Person curr = pq.poll();
//
//            tot++;
//
//            if(prev.weight > curr.weight && prev.height > curr.height) {
//                res[curr.idx] = String.valueOf(tot);
//                compO = tot;
//            } else res[curr.idx] = String.valueOf(compO);
//
//            prev = curr;
//        }
//
//        System.out.println(String.join(" ", res));
//    }
//
//    static class Person implements Comparable<Person> {
//        int idx;
//        int weight;
//        int height;
//        int rank = 1; // 기본 등수를 1로 설정
//
//        public Person(int idx, int weight, int height) {
//            this.idx = idx;
//            this.weight = weight;
//            this.height = height;
//        }
//
//        @Override
//        public int compareTo(Person o) {
//            if(this.weight==o.weight) return o.height - this.height; // 몸무게가 같다면 키를 기준으로 높은 것부터 출력
//            return o.weight - this.weight; // 몸무게가 다르다면 몸무게 기준으로 높은 것부터 출력
//        }
//    }

// Solution 1. 완전 탐색 -> 비교
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        int[] res = new int[n];
        Arrays.fill(res, 1);

        for(int i=0;i<n;i++){
            int x1 = arr[i][0];
            int y1 = arr[i][1];

            for(int j=i+1; j<n; j++){
                int x2 = arr[j][0];
                int y2 = arr[j][1];

                if(x1>x2 && y1>y2) res[j]++;
                else if(x1<x2 && y1<y2) res[i]++;

                System.out.println(Arrays.toString(res));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int v : res){
            sb.append(v).append(" ");
        }
        System.out.println(sb);
    }
}
