package DailyCheckUp.Date_25_04_N.D10;

import java.util.*;
import java.io.*;

public class SWEA_1225_암호생성기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int t=1;t<=10;t++){
            int tc = Integer.parseInt(br.readLine());
            
            Deque<String> code = new ArrayDeque<>();
            for(String s : br.readLine().split(" ")){
                code.offer(s);
            }

            int m = 1;
            while(true){
                int front = Integer.parseInt(code.pollFirst());

                if(m>5) m = 1;
                front -= m;

                if(front <= 0) {
                    code.offer("0");
                    break;
                }

                code.offer(Integer.toString(front));
                m++;
            }

            sb.append("#").append(tc).append(" ").append(String.join(" ", code)).append("\n");
        }

        System.out.print(sb);
    }
}
