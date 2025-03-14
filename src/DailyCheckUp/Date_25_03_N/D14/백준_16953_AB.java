package DailyCheckUp.Date_25_03_N.D14;

import java.io.*;
import java.util.*;

public class 백준_16953_AB {
// BFS 역순을 이용한 방법
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long A = inputs[0], B = inputs[1];

        boolean[] visited = new boolean[(int)(B+1)];
        Queue<Node> q = new LinkedList<>();

        q.offer(new Node(B, 0));
        visited[(int)B] = true;
        long find = -1;
        while(!q.isEmpty()){
            Node curr = q.poll();

            if(curr.n == A){
                find = curr.depth;
                break;
            }

            List<Long> tmp = new ArrayList<>();
            if(curr.n % 2 == 0) tmp.add(curr.n / 2);
            if((curr.n-1)%10 == 0) tmp.add((curr.n-1)/10);

            for(long next : tmp){
                if(next > 0 && !visited[(int)next]){
                    q.offer(new Node(next, curr.depth + 1));
                    visited[(int)next] = true;
                }
            }
        }

        System.out.println((find==-1) ? -1 : find + 1);
    }


//// BFS 를 이용한 방법
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        long[] inputs = Arrays.stream(br.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
//        long A = inputs[0], B = inputs[1];
//
//        Deque<Node> d = new ArrayDeque<>();
//        boolean[] visited = new boolean[(int)(B+1)];
//        d.offer(new Node(A, 0));
//        visited[(int)A] = true;
//        long ans = -1;
//
//        while(!d.isEmpty()){
//            Node curr = d.poll();
//
//            if(curr.n == B){
//                ans = curr.depth;
//                break;
//            }
//
//             for(long next : new long[]{curr.n*2, (curr.n*10 + 1)}){
//                 if(next<=B && !visited[(int)next]) {
//                     d.offer(new Node(next, curr.depth+1));
//                     visited[(int)next] = true;
//                 }
//             }
//        }
//
//        System.out.println((ans==-1) ? -1 : ++ans);
//    }

    static class Node {
        long n;
        long depth;

        public Node(long n, long depth) {
            this.n = n;
            this.depth = depth;
        }
    }
}
