package DailyCheckUp.Date_25_05_N.D13;

import java.util.*;
import java.io.*;

public class SWEA_2115_모의SW역량테스트_벌꿀채취 {
// Solution 3> 탐색 중복 제거 + dfs(선택했을 때, 선택하지 않았을 때)
// 실행시간이 가장 짧았다.
    static int N, M, C;
    static int max;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            arr = new int[N][N];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = 0;
            for (int x = 0; x < N; x++) {
                for (int y = 0; y <= N - M; y++) {
                    int v1 = getHoney(x, y);

                    for (int j = y + M; j <= N - M; j++) {
                        int v2 = getHoney(x, j);
                        res = Math.max(res, v1 + v2);
                    }

                    for (int i = x + 1; i < N; i++) {
                        for (int j = 0; j <= N - M; j++) {
                            int v2 = getHoney(i, j);
                            res = Math.max(res, v1 + v2);
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static int getHoney(int x, int y) {
        int[] set = new int[M];
        int idx = 0;
        for (int k = 0; k < M; k++) {
            set[idx++] = arr[x][y + k];
        }
        max = 0;
        dfs(set, 0, 0, 0);
        return max;
    }

    static void dfs(int[] set, int i, int sum, int honey) {
        if (sum > C) return;

        if (i >= M) {
            max = Math.max(max, honey);
            return;
        }

        dfs(set, i + 1, sum + set[i], honey + (set[i] * set[i]));
        dfs(set, i + 1, sum, honey);
    }

// Solution 2> 전체 결과를 Map으로 저장 + dfs(선택했을 때, 선택하지 않았을 때)
//    static Map<String, Integer> cases;
//    static int N, M, C;
//    static int max;
//    static int[][] arr;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= T; t++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken());
//            M = Integer.parseInt(st.nextToken());
//            C = Integer.parseInt(st.nextToken());
//
//            arr = new int[N][N];
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            cases = new HashMap<>();
//            for (int x = 0; x < N; x++) {
//                for (int y = 0; y <= N - M; y++) {
//                    String setStr = x + "-" + y + "-" + (y + M - 1);
//                    int[] set = new int[M];
//                    int idx = 0;
//
//                    for (int k = 0; k < M; k++) {
//                        set[idx++] = arr[x][y + k];
//                    }
//
//                    max = 0;
//                    getHoney(0, 0, 0, set);
//
//                    cases.put(setStr, max);
//                }
//            }
//
//            int res = 0;
//            for(String s1 : cases.keySet()){
//                for(String s2: cases.keySet()){
//                    if(s1.equals(s2)) continue;
//
//                    String[] tmp1 = s1.split("-");
//                    String[] tmp2 = s2.split("-");
//                    if(tmp1[0].equals(tmp2[0])){
//                        boolean isSame = false;
//                        for(int i=Integer.parseInt(tmp1[1]); i<=Integer.parseInt(tmp1[2]); i++){
//                            if(i >= Integer.parseInt(tmp2[1]) && i<= Integer.parseInt(tmp2[2])){
//                                isSame = true;
//                                break;
//                            }
//                        }
//                        if(isSame) continue;
//                    }
//
//                    res = Math.max(res, cases.get(s1) + cases.get(s2));
//                }
//            }
//
//            sb.append("#").append(t).append(" ").append(res).append("\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    static void getHoney(int i, int sum, int honey, int[] set) {
//        if (sum > C) return;
//
//        if(i>=M){
//            max = Math.max(max, honey);
//            return;
//        }
//
//        // 해당 꿀을 선택할 때
//        getHoney(i+1, sum+set[i], honey+(set[i]*set[i]), set);
//
//        // 해당 꿀을 선택하지 않을 때
//        getHoney(i+1, sum, honey, set);
//    }

// Solution 1> dfs로 조합 만들어 계산
//    static int N, M, C, max, tmpLen, res;
//    static int[] tmpSet, set;
//    static int[][] arr, honey1, honey2;
//    static boolean[][] visited;
//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for (int t = 1; t <= T; t++) {
//            StringTokenizer st = new StringTokenizer(br.readLine());
//            N = Integer.parseInt(st.nextToken());
//            M = Integer.parseInt(st.nextToken());
//            C = Integer.parseInt(st.nextToken());
//
//            arr = new int[N][N];
//            for (int i = 0; i < N; i++) {
//                st = new StringTokenizer(br.readLine());
//                for (int j = 0; j < N; j++) {
//                    arr[i][j] = Integer.parseInt(st.nextToken());
//                }
//            }
//
//            res = 0;
//            for (int x = 0; x < N; x++) {
//                for (int y = 0; y <= N - M; y++) {
//                    int idx = 0;
//                    set = new int[M];
//                    visited = new boolean[N][N];
//
//                    for (int k = 0; k < M; k++) {
//                        set[idx++] = arr[x][y + k];
//                        visited[x][y + k] = true;
//                    }
//
//                    max = 0;
////                    getHoney();
//                    getHoney2(0,0,0,new int[M]);
//                    int h1 = max;
//
//                    for (int i = 0; i < N; i++) {
//                        for (int j = 0; j <= N - M; j++) {
//                            idx = 0;
//                            set = new int[M];
//                            boolean can = true;
//                            for (int k = 0; k < M; k++) {
//                                if(visited[i][j+k]) {
//                                    can = false;
//                                    break;
//                                }
//
//                                set[idx++] = arr[i][j + k];
//                            }
//
//                            if(can){
//                                max = 0;
////                                getHoney();
//                                getHoney2(0,0,0,new int[M]);
//                                int h2 = max;
//
//                                res = Math.max(res, h1 + h2);
//                            }
//                        }
//                    }
//                }
//            }
//
//            sb.append("#").append(t).append(" ").append(res).append("\n");
//        }
//
//        System.out.print(sb);
//    }
//
//    static void getHoney2(int i, int position, int sum, int[] tmp){
//        if(sum > C) return;
//
//        if(i>=M) {
//            int honey = 0;
//            for(int h : tmp){
//                honey += h * h;
//            }
//            max = Math.max(max, honey);
//            return;
//        }
//
//        // 해당 꿀을 선택할 때
//        int[] tt = Arrays.copyOf(tmp, tmp.length);
//        tt[position] = set[i];
//        getHoney2(i+1, sum+set[i], sum+set[i], tt);
//
//        // 해당 꿀을 선택하지 않을 때
//        getHoney2(i+1, position+1, sum, Arrays.copyOf(tmp, tmp.length));
//    }
//
////
////    static void getHoney() {
////        for (int len = 1; len <= M; len++) {
////            tmpLen = len;
////            tmpSet = new int[tmpLen];
////            honeyDFS(0, 0, 0);
////        }
////    }
////
////    static void honeyDFS(int idx, int position, int sum) {
////        if (position >= tmpLen) {
////            if (sum <= C) {
////                int tmp = 0;
////                for (int v : tmpSet) {
////                    tmp += v * v;
////                }
////                max = Math.max(max, tmp);
////            }
////            return;
////        }
////
////        for (int i = idx; i < M; i++) {
////            tmpSet[position] = set[i];
////            honeyDFS(i+1, position+1, sum+set[i]);
////        }
////    }

}
