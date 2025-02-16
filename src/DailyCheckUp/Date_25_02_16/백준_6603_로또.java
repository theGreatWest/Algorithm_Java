package DailyCheckUp.Date_25_02_16;

import java.util.*;
import java.io.*;

public class 백준_6603_로또 {
    static int k;
    static int[] list;
    // 내 코드에서 줄일 수 있는 부분
//    static List<Integer> tmp = new ArrayList<>();
//    static Set<String> res;
//    static boolean[] visited;
// 추가해야 할 부분
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if (k == 0) break;

            list = new int[k];
            for (int i = 0; i < k; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
//
//            visited = new boolean[k];
//            res = new HashSet<>();

            DFS(0, 0, new int[6]);

            bw.write("\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static void DFS(int count, int start, int[] selected) throws IOException {
        if (count == 6) { // 6개 선택 완료
//            List<Integer> r = new ArrayList<>(tmp)  ;
//            Collections.sort(r);
//
//            String s = "";
//            for(int n : r){
//                s+=n+" ";
//            }s+="\n";
//
//            res.add(s);

            for (int i = 0; i < 6; i++) {
                bw.write(selected[i] + " ");
            }
            bw.write("\n");

            return;
        }

        for (int i = start; i < k; i++) { // 중복 방지를 위해 start 부터 탐색
            selected[count] = list[i];
            DFS(count + 1, i + 1, selected); // 다음 숫자는 현재 선택한 숫자보다 큰 숫자만 선택
        }
    }
}
