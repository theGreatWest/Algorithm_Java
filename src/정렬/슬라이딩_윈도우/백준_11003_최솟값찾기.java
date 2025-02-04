package 정렬.슬라이딩_윈도우;

import java.io.*;
import java.util.*;

public class 백준_11003_최솟값찾기 {
    private static int n, l;
    private static List<Integer> all = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Deque<Node> d = new LinkedList<>();

        n = Integer.parseInt(st.nextToken());
        l = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int now = Integer.parseInt(st.nextToken());

            while(!d.isEmpty() && d.getLast().value > now){
                d.removeLast();
            }

            d.add(new Node(i, now));
            if(d.getFirst().idx <= i-l) d.removeFirst();
            sb.append(d.getFirst().value).append(" ");
        }
        System.out.println(sb);
    }

    static class Node {
        public int idx;
        public int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}
