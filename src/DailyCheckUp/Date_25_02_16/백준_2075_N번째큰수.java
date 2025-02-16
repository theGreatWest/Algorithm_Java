package DailyCheckUp.Date_25_02_16;

import java.io.*;
import java.util.*;

public class 백준_2075_N번째큰수 {
    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

// Sol 1 > 메모리 초과
//        arr = new int[n][n];
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//        br.close();

//        // 첫 번째 열의 숫자 모두 가져오기
//        List<Integer> list = new ArrayList<>();
//        for (int i = 0; i < n; i++) {
//            list.add(arr[i][0]);
//        }
//
//        // 첫번째 열과 두번째~마지막 열을 비교 + 시작 인덱스 조정하며 삽입 정렬
//        for (int j = 1; j < n; j++) {
//            int startIdx = 0;
//            for (int i = 0; i < n; i++) {
//                int current = arr[i][j];
//
//                for (int l = startIdx; l < list.size(); l++) {
//                    if(current <= list.get(l)) {
//                        list.add(l, current);
//                        startIdx = l;
//                        break;
//                    }
//                }
//            }
//        }
//        list.sort(Collections.reverseOrder());
//
//        System.out.println(list.get(n-1));
//  Sol 2 > 메모리 초과
//        int[] tmp = new int[100000001];
//        for (int i = 0; i < n; i++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < n; j++) {
//                int value = Integer.parseInt(st.nextToken());
//                tmp[value]++;
//            }
//        }
//        br.close();
//
//        int cnt = 0, i = 100000000;
//        while (true) {
//            if (tmp[i] != 0) cnt++;
//
//            if (cnt == n) {
//                System.out.println(i);
//                break;
//            }
//            i--;
//        }
//  Sol 3 > 우선순위 큐 사용
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                pq.offer(Long.parseLong(st.nextToken()));
                if(pq.size()>n) pq.poll();
            }
        }
        br.close();

        System.out.println(pq.poll());
    }
}
