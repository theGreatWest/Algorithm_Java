package 자료구조.스택_큐;

import java.io.*;
import java.util.*;

public class 백준_1874_스택수열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            q.add(Integer.parseInt(br.readLine()));
        }
        int now = q.poll();
        Stack<Integer> s = new Stack<>();
        for(int i=1;i<=n;i++){
            s.push(i);
            res.append("+").append("\n");
            while(!s.isEmpty() && s.peek()==now){
                s.pop();
                res.append("-").append("\n");
                if(!q.isEmpty()) now = q.poll();
            }
        }
        System.out.println(s.isEmpty() ? res : "NO");
    }
}
