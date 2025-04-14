package DailyCheckUp.Date_25_04_N.D14;

import java.util.*;
import java.io.*;

public class SWEA_1234_SW문제해결기본_10일차_비밀번호 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 2; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            String[] arr = st.nextToken().split("");

//  Stack 을 활용한 코드
            Stack<String> stack = new Stack<>();
            for (String s : arr) {
                if (!stack.isEmpty() && s.equals(stack.peek())) stack.pop();
                else stack.push(s);
            }

            StringBuilder tmp = new StringBuilder();
            while (!stack.isEmpty()){
                tmp.append(stack.pop());
            }
            sb.append("#").append(t).append(" ").append(tmp.reverse()).append("\n");

//  그리디 코드
//            while(true){
//                boolean find = false;
//                for(int i=0;i<arr.length-1;i++){
//                    int r = i+1;
//                    if(arr[i].equals(arr[r])){
//                        find = true;
//                        arr[i] = "";
//                        arr[r] = "";
//                        break;
//                    }
//                }
//                if(!find) break;
//                arr = String.join("", arr).split("");
//            }
//            sb.append("#").append(t).append(" ").append(String.join("", arr)).append("\n");
        }

        System.out.print(sb);
    }
}
