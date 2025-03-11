package DailyCheckUp.Date_25_02_N.D23;

import java.util.*;
import java.io.*;

public class 백준_2493_탑 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=n;i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        Stack<Integer> stack = new Stack<>(); // index 저장
        // stack 보다 deque(ArrayDeque)을 사용하면 더 효과적 -> offerFirst, pollFirst 사용
        for(int i=1;i<=n;i++){
            while(!stack.isEmpty()){
                if(arr[stack.peek()] < arr[i]) stack.pop();
                else{
                    sb.append(stack.peek()).append(" ");
                    break;
                }
            }
            if(stack.isEmpty()) sb.append(0).append(" ");

            stack.push(i);
        }

        System.out.println(sb);
    }
}
