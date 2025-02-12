package 탐색.이진탐색;

import java.io.*;
import java.util.*;

public class 백준_1920_수찾기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nArr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int target = Integer.parseInt(st.nextToken());

            int s = 0, e = n - 1;
            boolean contain = false;

            while (s <= e) {
                int mid = (s + e) / 2;

                if (target == nArr[mid]) {
                    contain = true;
                    break;
                } else if (target < nArr[mid]) e = mid - 1;
                else s = mid + 1;
            }
            bw.write((contain ? 1 : 0) + "\n");
        }
        bw.flush();
        br.close();
        bw.close();
    }
}
