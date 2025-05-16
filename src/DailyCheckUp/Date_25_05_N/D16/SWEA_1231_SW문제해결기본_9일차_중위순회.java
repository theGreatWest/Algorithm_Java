package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_1231_SW문제해결기본_9일차_중위순회 {
    static int N;
    static char[] arr;
    static List<Integer>[] info;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());

//            info = new ArrayList[N + 1];
//            for (int i = 1; i <= N; i++) {
//                info[i] = new ArrayList();
//            }

//            arr = new char[N + 1];
            nodes = new Node[N+1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int currNum = Integer.parseInt(st.nextToken());
                char currC = st.nextToken().charAt(0);
//                arr[currNum] = currC;
                nodes[currNum] = new Node(currC);

                if (st.hasMoreTokens()) {
//                    info[currNum].add(Integer.parseInt(st.nextToken()));
                    nodes[currNum].setLeft(Integer.parseInt(st.nextToken()));
                }
                if (st.hasMoreTokens()) {
//                    info[currNum].add(Integer.parseInt(st.nextToken()));
                    nodes[currNum].setRight(Integer.parseInt(st.nextToken()));
                }
            }

//            sb.append("#").append(t).append(" ").append(dfs(1)).append("\n");
            sb.append("#").append(t).append(" ").append(dfs2(1)).append("\n");
        }

        System.out.print(sb);
    }

    static String dfs2(int i){
        String left = (nodes[i].left == 0) ? "" : dfs2(nodes[i].left);
        String right = (nodes[i].right == 0) ? "" : dfs2(nodes[i].right);

        return  left + nodes[i].c + right;
    }

    static String dfs(int i) {
        String left = (!info[i].isEmpty()) ? dfs(info[i].get(0)) : "";
        String right = (info[i].size() >= 2) ? dfs(info[i].get(1)) : "";

        return left + arr[i] + right;
    }

    static class Node {
        char c;
        int left = 0;
        int right = 0;

        public Node(char c) {
            this.c = c;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }
}
