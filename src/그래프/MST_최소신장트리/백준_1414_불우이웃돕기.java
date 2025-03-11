package 그래프.MST_최소신장트리;

import java.util.*;
import java.io.*;

public class 백준_1414_불우이웃돕기 {
    static int n;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = i;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>();
        int totLeng = 0;
        for (int i = 0; i < n; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < n; j++) {
                int len = charToInt(st[j].charAt(0));
                totLeng+=len;
                if (len != 0) pq.offer(new Node(i, j, len));
            }
        }

        int edgeCount = 0, totLength = 0;
        while (!pq.isEmpty()) {
            Node current = pq.poll();
            int a = current.start, b = current.end;

            if(a == b) continue;

            int findA = find(a), findB = find(b);
            if(findA!=findB){
                totLength += current.length;
                arr[findB] = findA;
                edgeCount++;
            }

            if (edgeCount == n-1) break;
        }

        System.out.println((edgeCount == n-1) ? totLeng - totLength : -1);
    }

    static int find(int a){
        if(arr[a] == a) return a;

        return arr[a] = find(arr[a]);
    }

    static int charToInt(char c) {
        if(c == '0') return 0;
        if ((int)c >= 97) return c - 96;
        return c - 38;
    }

    static class Node implements Comparable<Node> {
        int start, end, length;

        public Node(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }
}
