package 자료구조.스택_큐;

import java.util.*;
import java.io.*;

public class 백준_11286_절댓값힙 {
    public static LinkedList<Integer> repo = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // process
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> {
            int absO1 = Math.abs(o1);
            int absO2 = Math.abs(o2);

            if(absO1==absO2)  return o1 - o2;
            else return absO1 - absO2;
        });
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++){
            int x = Integer.parseInt(br.readLine());
            if(x==0) sb.append((pq.isEmpty())?0:pq.poll()).append("\n");
            else pq.add(x);
        }
        System.out.println(sb);
    }
}
