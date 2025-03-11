package DailyCheckUp.Date_25_03_11;

import java.io.*;
import java.util.*;

public class 백준_2146_다리만들기 {
    static final int[] di = {0, 0, -1, 1};
    static final int[] dj = {-1, 1, 0, 0};

    static int n, islandNum=1, minLength = Integer.MAX_VALUE;
    static int[][] map;
    static boolean[][] visited;
    static List<List<Node>> islands = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        // 지도 입력 받기
        map = new int[n][n];

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 섬 구분하기 + 섬인 좌표 모아보기
        visited = new boolean[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map[i][j] > 0 && !visited[i][j]){
                    List<Node> lands = new ArrayList<>();
                    separateIslands(i, j, lands);
                    islands.add(lands);
                    islandNum++;
                }
            }
        }

        // 다리의 최소 길이 구하기
        for(List<Node> island : islands){

            for(Node land : island){
                findMinLength(land, map[land.i][land.j]);
            }
        }

        // 결과 출력
        System.out.println(minLength);
    }

    static void findMinLength(Node node, int landNum){
        visited = new boolean[n][n];

        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(node.i, node.j, 0));

        while(!q.isEmpty()){
            Node curr = q.poll();

            for(int d=0;d<4;d++){
                int nextI = curr.i + di[d];
                int nextJ = curr.j + dj[d];

                if(!OOR(nextI, nextJ) && !visited[nextI][nextJ]){
                    int nextNum = map[nextI][nextJ];

                    if(nextNum==0){
                        q.offer(new Node(nextI, nextJ, curr.length+1));
                        visited[nextI][nextJ] = true;
                    }else if(nextNum!=landNum) minLength = Math.min(minLength, curr.length);
                }
            }
        }
    }

    static void separateIslands(int i, int j, List<Node> lands){
        Queue<Node> q = new LinkedList<>();
        Node first = new Node(i, j, 0);
        q.offer(first);
        visited[i][j] = true;
        map[i][j] = islandNum;
        lands.add(first);

        while(!q.isEmpty()){
            Node currNode = q.poll();

            for(int d=0;d<4;d++){
                int nextI = currNode.i + di[d];
                int nextJ = currNode.j + dj[d];

                if(!OOR(nextI, nextJ) && map[nextI][nextJ] > 0 && !visited[nextI][nextJ]){
                    visited[nextI][nextJ] = true;
                    map[nextI][nextJ] = islandNum;
                    Node next = new Node(nextI, nextJ, 0);
                    lands.add(next);
                    q.offer(next);
                }
            }
        }
    }

    static boolean OOR(int i, int j){
        return i<0 || j<0 || i>=n || j>=n;
    }

    static class Node {
        int i, j, length;

        public Node(int i, int j, int length) {
            this.i = i;
            this.j = j;
            this.length = length;
        }
    }



// Sol 1>
//    static final int[] di = {0, 0, -1, 1};
//    static final int[] dj = {-1, 1, 0, 0};
//
//    static int N, bridgeLength = Integer.MAX_VALUE;
//    static int[][] arr;
//    static boolean[][] visited;
//
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//        N = Integer.parseInt(br.readLine());
//
//        // 지도 입력받기
//        arr = new int[N][N];
//        for (int i = 0; i < N; i++) {
//            st = new StringTokenizer(br.readLine());
//            for (int j = 0; j < N; j++) {
//                arr[i][j] = Integer.parseInt(st.nextToken());
//            }
//        }
//
//        // 섬 분리하기 && 섬인 지점의 좌표 저장하기
//        visited = new boolean[N][N];
//
//        int num = 2;
//        List<List<Node>> islands = new ArrayList<>();
//
//        for (int i = 0; i < N; i++) {
//            for (int j = 0; j < N; j++) {
//                if (arr[i][j] == 1 && !visited[i][j]) {
//                    List<Node> tmpList = new ArrayList<>();
//                    bfs(i, j, num, tmpList);
//                    islands.add(tmpList);
//                    num++;
//                }
//            }
//        }
//
//        // 섬인 좌표에서 bfs 를 실행하여 최소 길이 업데이트하기
//        // 다른 섬에 도착하면(범위 벗어나지 않고, 자신의 섬 번호와 번호가 다른 섬)
//        // 각 섬에서 다리 길이 계산
//        // 여기 해야된다!
//        for (List<Node> island : islands) {
//            for (Node node : island) {
//                int i = node.i, j = node.j;
//                int currNum = arr[i][j];
//                bfs(currNum, i, j);
//            }
//        }
//
//        System.out.println(bridgeLength);
//    }
//
//    static void bfs(int compNum, int i, int j) {
//        visited = new boolean[N][N];
//        Queue<Node> q = new LinkedList<>();
//
//        Node first = new Node(i, j, 0);
//        q.offer(first);
//        visited[i][j] = true;
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//            int currI = curr.i, currJ = curr.j, currLen = curr.len;
////            System.out.println(curr.toString());
//
//            for (int d = 0; d < 4; d++) {
//                int nextI = currI + di[d];
//                int nextJ = currJ + dj[d];
//
//                if (!isOOR(nextI, nextJ)) {
//                    int nextNum = arr[nextI][nextJ];
//
//                    if (nextNum == compNum) continue;
//
//                    if (nextNum > 0) {
//                        bridgeLength = Math.min(bridgeLength, currLen);
//                        continue;
//                    }
//
//                    if (!visited[nextI][nextJ]) {
//                        Node next = new Node(nextI, nextJ, currLen + 1);
//                        q.offer(next);
//                        visited[nextI][nextJ] = true;
//                    }
//                }
//            }
//        }
//    }
//
//    static void bfs(int i, int j, int num, List<Node> tmpList) {
//        Queue<Node> q = new LinkedList<>();
//        Node first = new Node(i, j);
//        q.offer(first);
//        visited[i][j] = true;
//        arr[i][j] = num;
//        tmpList.add(first);
//
//        while (!q.isEmpty()) {
//            Node curr = q.poll();
//
//            for (int d = 0; d < 4; d++) {
//                int nI = curr.i + di[d];
//                int nJ = curr.j + dj[d];
//
//                if (!isOOR(nI, nJ) && arr[nI][nJ] == 1 && !visited[nI][nJ]) {
//                    Node next = new Node(nI, nJ);
//                    q.offer(next);
//                    visited[nI][nJ] = true;
//                    arr[nI][nJ] = num;
//                    tmpList.add(next);
//                }
//            }
//        }
//    }
//
//    static boolean isOOR(int i, int j) {
//        return i < 0 || j < 0 || i >= N || j >= N;
//    }
//
//    static class Node {
//        int i;
//        int j;
//        int len;
//
//        public Node(int i, int j) {
//            this.i = i;
//            this.j = j;
//        }
//
//        public Node(int i, int j, int len) {
//            this.i = i;
//            this.j = j;
//            this.len = len;
//        }
//    }
}
