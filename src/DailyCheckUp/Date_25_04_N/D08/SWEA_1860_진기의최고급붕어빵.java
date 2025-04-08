package DailyCheckUp.Date_25_04_N.D08;

import java.util.*;
import java.io.*;

public class SWEA_1860_진기의최고급붕어빵 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            // 데이터 전체를 전부 정렬해서 한 번에 처리하는 경우 -> Arrays.sort()
            //      역순 정렬
            //      배열 : Arrays.sort(arr, Collections.reverseOrder());
            //          단, Integer[]처럼 Wrapper 클래스 배열이어야 한다.
            //          int[] 역순 정렬
            //          - Integer[] boxed = Arrays.stream(arr).boxed().toArray(Integer[]::new);
            //          - Arrays.sort(boxed, Collections.reverseOrder());
            //          - arr = Arrays.stream(boxed).mapToInt(Integer::intValue).toArray();
            //      리스트 : list.sort(Collections.reverseOrder()); || Collections.sort(list, Collections.reverseOrder());
            // 필요한 만큼만 정렬 순서대로 꺼내서 처리할 경우 -> Priority Queue
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int i=0;i<N;i++){
                pq.offer(Integer.parseInt(st.nextToken()));
            }

            boolean possible = true;
            int makeSec = 1;
            int totNum = 0;
            while(!pq.isEmpty()){
                int arriveSec = pq.poll();

//                for(int currSec=makeSec; currSec<=arriveSec; currSec++){
//                    if(currSec%M==0) totNum+=K;
//                }
                int produced = (arriveSec / M) - ((makeSec) / M);
                totNum += produced * K;

                if(totNum==0){
                    possible = false;
                    break;
                }

                totNum--;
                makeSec = arriveSec;
            }

            sb.append("#").append(t).append(" ").append((possible) ? "Possible" : "Impossible").append("\n");
        }

        System.out.print(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for(int t=1;t<=T;t++){
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(st.nextToken());
//            int M = Integer.parseInt(st.nextToken());
//            int K = Integer.parseInt(st.nextToken());
//
//            st = new StringTokenizer(br.readLine());
//            PriorityQueue<Integer> pq = new PriorityQueue<>();
//            for(int i=0;i<N;i++){
//                pq.offer(Integer.parseInt(st.nextToken()));
//            }
//
//            int[] dp = new int[11112];
//            int currSec = 1;
//            boolean possible = true;
//            while(!pq.isEmpty()){
//                int arriveSec = pq.poll();
//                for(int i=currSec;i<=arriveSec;i++){
//                    dp[i] = dp[i-1] + ((i%M==0) ? K : 0);
//                }
//                if(dp[arriveSec]==0) {
//                    possible = false;
//                    break;
//                }
//                dp[arriveSec]--;
//                currSec = arriveSec + 1;
//            }
//
//            sb.append("#").append(t).append(" ").append((possible) ? "Possible" : "Impossible").append("\n");
//        }
//
//        System.out.print(sb);
//    }
}
