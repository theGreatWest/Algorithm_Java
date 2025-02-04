package 자료구조.투포인터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class 백준_1253_좋다 {
    private static int n;
    private static List<Long> ns = new ArrayList<>();

    public static void main(String[] args) {
        input();
        process();
    }

    private static void input() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                long tmp = Long.parseLong(st.nextToken());
                ns.add(tmp);
            }
        } catch (IOException e) {/*pass*/}
    }

    private static void process() {
        Collections.sort(ns);
        int result = 0;
        for (int keyIdx = 0; keyIdx < n; keyIdx++) {
            int idx1 = 0, idx2 = n - 1;
            long find = ns.get(keyIdx);

            while (idx1 < idx2) {
                long sum = ns.get(idx1) + ns.get(idx2);
                if(sum==find){
                    if(idx1!=keyIdx && idx2!=keyIdx){
                        result++;
                        break;
                    }else if(idx1==keyIdx){
                        idx1++;
                    }else if(idx2==keyIdx){
                        idx2--;
                    }
                }else if(sum>find) idx2--;
                else idx1++;
            }
        }
        System.out.println(result);
    }
}


/*
9
-3 -2 -1 1 2 5 7 8 9
* */