package 자료구조.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_1904_주몽의명령 {
    private static int n;
    private static int m;
    private static int[] ns;

    public static void main(String[] args) {
        input();
//        process1();
        process2();
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());

            ns = new int[n];
            int i = 0;
            for (String s : br.readLine().split(" ")) {
                ns[i++] = Integer.parseInt(s);
            }
        } catch (IOException e) {/*pass*/}
    }

    private static void process1() {
        Arrays.sort(ns);

        int result = 0;
        for (int b = n - 1; b >= 0; b--) {
            if (b >= m) continue;
            for (int s = 0; s < b; s++) {
                int tmp = ns[s] + ns[b];
                if (tmp == m) {
                    result++;
                    break;
                } else if (tmp > m) break;
            }
        }
        System.out.println(result);
    }

    private static void process2() {
        Arrays.sort(ns);

        int startIdx = 0, endIdx = n - 1, cnt = 0;
        while (startIdx < endIdx) {
            int sum = ns[startIdx] + ns[endIdx];
            if(sum==m){
                cnt++;
                endIdx--;
                startIdx++;
            }else if(sum>m){
                 endIdx--;
            }else{
                startIdx++;
            }
        }
        System.out.println(cnt);
    }
}
