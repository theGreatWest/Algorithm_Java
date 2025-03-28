package DailyCheckUp.Date_25_03_N.D28;

import java.util.*;
import java.io.*;

public class 백준_14891_톱니바퀴 {
// Solution 2. Char 배열 활용
    static char[][] wheels = new char[4][8]; // 톱니바퀴 저장
    static int[] direction = new int[4]; // 회전 방향 저장

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니바퀴 상태 입력
        for (int i = 0; i < 4; i++) {
            wheels[i] = br.readLine().toCharArray();
        }

        int k = Integer.parseInt(br.readLine()); // 회전 횟수
        while (k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int d = Integer.parseInt(st.nextToken());

            Arrays.fill(direction, 0); // 방향 초기화
            direction[idx] = d; // 회전 시작 톱니 지정

            // 왼쪽 톱니들 확인
            for (int i = idx; i > 0; i--) {
                if (wheels[i][6] != wheels[i - 1][2]) {
                    direction[i - 1] = -direction[i]; // 반대 방향 회전
                } else break;
            }

            // 오른쪽 톱니들 확인
            for (int i = idx; i < 3; i++) {
                if (wheels[i][2] != wheels[i + 1][6]) {
                    direction[i + 1] = -direction[i];
                } else break;
            }

            // 모든 톱니 회전 적용
            for (int i = 0; i < 4; i++) {
                if (direction[i] != 0) rotate(i, direction[i]);
            }
        }

        // 점수 계산
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += (wheels[i][0] - '0') * (1 << i);
        }
        System.out.println(sum);

    }

    static void rotate(int idx, int d) {
        if (d == 1) { // 시계 방향 회전
            char temp = wheels[idx][7];
            System.arraycopy(wheels[idx], 0, wheels[idx], 1, 7);
            wheels[idx][0] = temp;
        } else { // 반시계 방향 회전
            char temp = wheels[idx][0];
            System.arraycopy(wheels[idx], 1, wheels[idx], 0, 7);
            wheels[idx][7] = temp;
        }
    }

// Solution 1. LinkedList 활용
//    static LinkedList<Integer>[] lists;
//    static int list0_2, list1_6, list1_2, list2_6, list2_2, list3_6;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        // 12시 방향부터 시계 방향으로 0번 -> 7번
//        // N: 0점, S: 1점
//        lists = new LinkedList[4];
//        for (int i = 0; i < 4; i++) {
//            lists[i] = new LinkedList<>();
//            for(int v : Arrays.stream(br.readLine().split("")).mapToInt(Integer::parseInt).toArray()){
//                lists[i].offer(v);
//            }
//        }
//
//        int k = Integer.parseInt(br.readLine()); // 회전 횟수
//        for (int i = 0; i < k; i++) {
//            list0_2 = lists[0].get(2);
//            list1_6 = lists[1].get(6);
//            list1_2 = lists[1].get(2);
//            list2_6 = lists[2].get(6);
//            list2_2 = lists[2].get(2);
//            list3_6 = lists[3].get(6);
//
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int listIdx = Integer.parseInt(st.nextToken()) - 1;
//            int d = Integer.parseInt(st.nextToken()); // 1: 시계 방향, -1: 반시계 방향
//
//            if(d==1) rotate(listIdx);
//            else rotateRev(listIdx);
//        }
//
//        int sum = 0;
//        for(int i=0;i<4;i++){
////            sum += lists[i].peek() * (int)Math.pow(2, i); // 2의 거듭 제곱 : 비트연산 => ( 1 << i )
//            sum += lists[i].peek() * ( 1 << i ); // 2의 거듭 제곱 : 비트연산 => ( 1 << i )
//        }
//        System.out.println(sum);
//    }
//
//    static void rotate(int listIdx) {
//        d1(lists[listIdx]);
//
//        switch (listIdx) {
//            case 0:
//                if(list0_2!=list1_6) {
//                    dRev(lists[1]);
//                    if(list1_2!=list2_6) {
//                        d1(lists[2]);
//                        if(list2_2!=list3_6) dRev(lists[3]);
//                    }
//                }
//                break;
//            case 1:
//                if(list0_2!=list1_6) dRev(lists[0]);
//                if(list1_2!=list2_6) {
//                    dRev(lists[2]);
//                    if(list2_2!=list3_6) d1(lists[3]);
//                }
//                break;
//            case 2:
//                if(list2_2!=list3_6) dRev(lists[3]);
//                if(list2_6!=list1_2) {
//                    dRev(lists[1]);
//                    if(list1_6!=list0_2) d1(lists[0]);
//                }
//                break;
//            case 3:
//                if(list3_6!=list2_2) {
//                    dRev(lists[2]);
//                    if(list2_6!=list1_2) {
//                        d1(lists[1]);
//                        if(list1_6!=list0_2) dRev(lists[0]);
//                    }
//                }
//                break;
//        }
//    }
//
//    static void rotateRev(int listIdx) {
//        dRev(lists[listIdx]);
//
//        switch (listIdx) {
//            case 0:
//                if(list0_2!=list1_6) {
//                    d1(lists[1]);
//                    if(list1_2!=list2_6) {
//                        dRev(lists[2]);
//                        if(list2_2!=list3_6) d1(lists[3]);
//                    }
//                }
//                break;
//            case 1:
//                if(list0_2!=list1_6) d1(lists[0]);
//                if(list1_2!=list2_6) {
//                    d1(lists[2]);
//                    if(list2_2!=list3_6) dRev(lists[3]);
//                }
//                break;
//            case 2:
//                if(list2_2!=list3_6) d1(lists[3]);
//                if(list2_6!=list1_2) {
//                    d1(lists[1]);
//                    if(list1_6!=list0_2) dRev(lists[0]);
//                }
//                break;
//            case 3:
//                if(list3_6!=list2_2) {
//                    d1(lists[2]);
//                    if(list2_6!=list1_2) {
//                        dRev(lists[1]);
//                        if(list1_6!=list0_2) d1(lists[0]);
//                    }
//                }
//                break;
//        }
//    }
//
//    static void d1(LinkedList<Integer> list){
//        list.offerFirst(list.pollLast());
//    }
//
//    static void dRev(LinkedList<Integer> list){
//        list.offerLast(list.pollFirst());
//    }
}
