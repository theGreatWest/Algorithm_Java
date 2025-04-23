package DailyCheckUp.Date_25_04_N.D23.모의고사;

import java.util.*;
import java.io.*;

public class SWEA_1225_SW문제해결기본_7일차_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 2;
        for (int t = 1; t <= T; t++) {
            // 감소할 때, 0보다 작아지면 0으로 유지 && 프로그램 종료
            // -1 ~ -5 하고 뒤로 넘기는 것이 한 사이클
            int caseNum = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            Deque<Integer> d = new ArrayDeque<>();
            for(int i=0;i<8;i++){
                d.offer(Integer.parseInt(st.nextToken()));
            }

            boolean end = false;
            while(!end){
                for(int i=1;i<=5;i++){
                    int firstValue = d.poll();
                    firstValue = Math.max(0, firstValue-i);
                    d.offer(firstValue);
                    if(firstValue==0){
                        end=true;
                        break;
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(print(d)).append("\n");
        }

        System.out.print(sb);
    }

    static String print(Deque<Integer> d){
        StringBuilder res = new StringBuilder();
        while(!d.isEmpty()){
            res.append(d.poll()).append(" ");
        }
        return res.toString();
    }
}
