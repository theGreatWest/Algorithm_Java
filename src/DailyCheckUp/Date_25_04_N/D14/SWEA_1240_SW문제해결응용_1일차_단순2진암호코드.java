package DailyCheckUp.Date_25_04_N.D14;

import java.util.*;
import java.io.*;

public class SWEA_1240_SW문제해결응용_1일차_단순2진암호코드 {
    static int n, m;
    static Map<String, Integer> map = new HashMap<>();
    static {
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        final int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            Stack<Integer> stack = new Stack<>()    ;
            for(int i=0; i<n; i++){
                String s = br.readLine();
                if(stack.isEmpty() && s.contains("1")) {
                    for(int j = 0; j <m; j++){
                        stack.push(s.charAt(j)-'0');
                    }
                }
            }

            // str.lastIndexOf("찾는값") 을 통해 마지막 index 를 찾아줄 수 있다.
            while(stack.peek()!=1){
                stack.pop();
            }

            int[] res = new int[8];
            int cnt = 0;
            while(cnt++<8){
                StringBuilder tmp = new StringBuilder();
                for(int i=0;i<7;i++){
                    tmp.append(stack.pop());
                }

                res[8 - cnt] = map.get(tmp.reverse().toString());
            }

            int r = 0, finalR=0;
            for(int i=0;i<8;i++){
                if(i%2==0) r += 3*res[i];
                else r += res[i];
                finalR += res[i];
            }
//            System.out.println(r);
//            System.out.println(finalR);

            sb.append("#").append(t).append(" ").append((r%10==0)?finalR:0).append("\n");
        }

        System.out.print(sb);
    }
}
