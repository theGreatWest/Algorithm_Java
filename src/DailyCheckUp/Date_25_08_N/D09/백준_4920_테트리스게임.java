package DailyCheckUp.Date_25_08_N.D09;

import java.util.*;
import java.io.*;

public class 백준_4920_테트리스게임 {
    static final List<Case> cases = new ArrayList<>();
    static {
        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{0,2}, new int[]{0,3}));
        cases.add(new Case(new int[]{0,0}, new int[]{1,0}, new int[]{2,0}, new int[]{3,0}));

        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{1,0}, new int[]{1,1}));

        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{1,1}, new int[]{1,2}));
        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{-1,1}, new int[]{1,0}));

        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{0,2}, new int[]{1,2}));
        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{-1,1}, new int[]{-2,1}));
        cases.add(new Case(new int[]{0,0}, new int[]{1,0}, new int[]{1,1}, new int[]{1,2}));
        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{1,0}, new int[]{2,0}));

        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{0,2}, new int[]{1,1}));
        cases.add(new Case(new int[]{0,0}, new int[]{1,0}, new int[]{2,0}, new int[]{1,1}));
        cases.add(new Case(new int[]{0,0}, new int[]{-1,1}, new int[]{0,1}, new int[]{0,2}));
        cases.add(new Case(new int[]{0,0}, new int[]{0,1}, new int[]{-1,1}, new int[]{1,1}));
    }

    static int n;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int caseNum = 1;
        while(true){
            String line = br.readLine().trim();
            if(line == null || line.equals("0")) {
                break;
            }
            n = Integer.parseInt(line);

            arr = new int[n][n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine().trim());
                for(int j=0; j<n; j++){
                    arr[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int res = Integer.MIN_VALUE;

            for(int i = 0; i < cases.size(); i++){
                res = Math.max(res, calculateMaxSum(i));
            }

            sb.append(caseNum++).append(". ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    static int calculateMaxSum(int caseNum) {
        Case c = cases.get(caseNum);
        int minRow = 0, maxRow = 0, minCol = 0, maxCol = 0;

        // 해당 로직 반드시 기억하기
        // 상대 좌표 {},{},{},{},... 전체 중 가장 작은/큰 숫자 구하기
        // for (int i = -minRow; i <= n - 1 - maxRow; i++) {
        //    for (int j = -minCol; j <= n - 1 - maxCol; j++) {
        for (int[] box : c.boxes) {
            minRow = Math.min(minRow, box[0]);
            maxRow = Math.max(maxRow, box[0]);
            minCol = Math.min(minCol, box[1]);
            maxCol = Math.max(maxCol, box[1]);
        }

        int maxSum = Integer.MIN_VALUE;

        for (int i = -minRow; i <= n - 1 - maxRow; i++) {
            for (int j = -minCol; j <= n - 1 - maxCol; j++) {
                int sum = 0;

                for (int[] box : c.boxes) {
                    sum += arr[i + box[0]][j + box[1]];
                }

                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    static class Case {
        int[][] boxes;
        public Case(int[]... boxes) {
            this.boxes = boxes;
        }
    }
}