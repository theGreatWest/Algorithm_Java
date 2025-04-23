package DailyCheckUp.Date_25_04_N.D23;

import java.util.*;
import java.io.*;

public class SWEA_1257_SW문제해결응용_6일차_K번째문자열 {
    static int K, len;
    static String input;

    // 문자열을 직접 다루는 구현 문제는 디버깅이 중요해서 안정성 확보가 더 중요

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());
            input = br.readLine();
            len = input.length(); // 불필요한 코드

            Set<String> set = new HashSet<>(); // TreeSet 을 사용했다면 정렬과 중복 제거 동시에 가능!
            TreeSet<String> treeSet = new TreeSet<>();
            for (int i = 0; i < len; i++) {
                for (int end = i + 1; end <= len; end++) {
                    set.add(input.substring(i, end));
                    treeSet.add(input.substring(i, end));
                }
            }

            System.out.println(treeSet);

            sb.append("#").append(t).append(" ");
            if(set.size() < K) sb.append("none");
            else{
//                List<String> list = new ArrayList<>(set);
//                Collections.sort(list);
//                sb.append(list.get(K - 1));
                String res = "";
                Iterator<String> it = treeSet.iterator();
                for(int k=0;k<K;k++){
                    res = it.next();
                }
                sb.append(res);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
