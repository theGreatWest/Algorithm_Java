package 자료구조.스택_큐;

import java.util.*;
import java.io.*;

public class 백준_12789_도키도키간식드리미 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(Integer.parseInt(st.nextToken()));
        }

        // process
        Stack<Integer> stay = new Stack<>();
        int ableNum = 1;
        while (!q.isEmpty()) {
            if (q.peek() != ableNum) {
                if(!stay.isEmpty() && stay.peek() == ableNum){
                    stay.pop();
                    ableNum++;
                }else stay.push(q.poll());
            } else {
                q.poll();
                ableNum++;
            }
        }

        while(!stay.isEmpty()){
            int currNum = stay.pop();
            if(currNum==ableNum) ableNum++;
            else break;
        }

        // output
        System.out.println((ableNum == n + 1) ? "Nice" : "Sad");
    }
}
