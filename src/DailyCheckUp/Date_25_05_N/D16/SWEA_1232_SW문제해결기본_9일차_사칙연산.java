package DailyCheckUp.Date_25_05_N.D16;

import java.util.*;
import java.io.*;

public class SWEA_1232_SW문제해결기본_9일차_사칙연산 {
    static int N;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= 10; t++) {
            N = Integer.parseInt(br.readLine());

            nodes = new Node[N + 1];
            for (int i = 1; i <= N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int nodeNum = Integer.parseInt(st.nextToken());
                String nodeValue = st.nextToken();

                nodes[nodeNum] = new Node(nodeValue);
                if (!nodes[nodeNum].isDigit) {
                    nodes[nodeNum].setLeftN(Integer.parseInt(st.nextToken()));
                    nodes[nodeNum].setRightN(Integer.parseInt(st.nextToken()));
                }
            }

            sb.append("#").append(t).append(" ").append(dfs(1)).append("\n");
        }

        System.out.print(sb);
    }

    static int dfs(int i) {
        return (nodes[i].isDigit)
                ? Integer.parseInt(nodes[i].value)
                : calculation(dfs(nodes[i].leftN), dfs(nodes[i].rightN), nodes[i].value);
    }

    static int calculation(int a, int b, String op) {
        if (op.equals("+")) return a + b;
        if (op.equals("-")) return a - b;
        if (op.equals("*")) return a * b;
        return a / b;
    }

    static class Node {
        boolean isDigit = false;

        String value;
        int leftN;
        int rightN;

        public Node(String value) {
            try {
                Integer.parseInt(value);
                isDigit = true;
            } catch (Exception e) {
            }

            this.value = value;
        }

        public void setLeftN(int leftN) {
            this.leftN = leftN;
        }

        public void setRightN(int rightN) {
            this.rightN = rightN;
        }
    }
}
