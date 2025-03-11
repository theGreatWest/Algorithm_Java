package DailyCheckUp.Date_25_02_N.D26;

import java.util.*;
import java.io.*;

public class 백준_13305_주유소 {
    /* 처음 제출한 코드

    < Sol 1 > 우선순위 큐를 이용한 방법
    오일 가격을 기준으로 오름차순 반환하는 우선순위 큐를 이용한다.

            static int n;
            static long totDist;
            static long[] dists;

            public static void main(String[] args) throws IOException {
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                n = Integer.parseInt(br.readLine());

                dists = new long[n + 1];
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int i = 2; i <= n; i++) {
                    long dist = Long.parseLong(st.nextToken());
                    dists[i] = dist;
                    totDist += dist;
                }
                dists[1] = totDist;
                for(int i=2;i<=n;i++){
                    totDist -= dists[i];
                    dists[i] = totDist;
                }

                PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2)->Long.compare(o1[1], o2[1])); // {도시번호, 오일가격}: 오일 가격이 낮은 순서로 poll
                st = new StringTokenizer(br.readLine());
                long n1Cost = 0;
                for(int i=1;i<=n;i++){
                    long tmp = Long.parseLong(st.nextToken());
                    if(i==1) n1Cost = tmp;
                    pq.offer(new long[]{(long)i, tmp});
                }

                long purchaseDist = 0, minCity = Long.MAX_VALUE, minCost = 0;
                while(!pq.isEmpty()){
                    long[] tmp = pq.poll();
                    int currCity = (int)tmp[0];
                    long currCost = tmp[1];

                    if(currCity < minCity && (dists[currCity] - purchaseDist) != 0){
                        minCity = currCity;
                        long currDist = dists[currCity] - purchaseDist;
                        purchaseDist += currDist;
                        minCost += currDist * currCost;
                    }
                }
                long restDist = dists[1] - purchaseDist;
                if(restDist!=0) minCost += restDist * n1Cost;

                System.out.println(minCost);
            }

    */
/* 다른 사람 코드1 (공부용)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        // 오 이거 너무 좋다!
        int []load = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int []gasFee = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        long ans = 0;
        long minFee = gasFee[0];
        long needGasDistance = 0;

        // 이전 값이 다음 값보다 클 때 누적해온 값들을 처리하는 로직
        // dp 를 이용한 것 같은데 너무 좋은 풀이다! 이런 식의 로직을 익혀놓자! <== 길이 하나만 있고, 순서가 정해져 있을 때 최소 금액(비용) 문제
        for(int i = 0; i<N-1; i++){
            if(minFee > gasFee[i]){
                ans += needGasDistance * minFee;
                needGasDistance = 0;
                minFee = gasFee[i];
            }
            needGasDistance += load[i];
        }
        ans += needGasDistance * minFee;

        System.out.println(ans);
    }
 */
// 다른 사람 코드2 (공부용)
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long price = 0;

        long[] distance = new long[N];
        long[] cities = new long[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N-1 ; i++) {
            distance[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i <N; i++) {
            cities[i] = Integer.parseInt(st.nextToken());
        }

        // 최소 금액을 갱신하며 가는 방법!
        // 이렇게 쉽게 생각할 수 있구나... 많이 배웠다.
        long minGas = Integer.MAX_VALUE;
        for (int i = 0; i < N ; i++) {
            minGas = Math.min(minGas,cities[i]);
            price += minGas*distance[i];
        }

        System.out.println(price);
    }
}
