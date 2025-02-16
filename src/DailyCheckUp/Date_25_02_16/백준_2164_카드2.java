package DailyCheckUp.Date_25_02_16;

import java.util.*;
import java.io.*;

public class 백준_2164_카드2 {
    public static void main(String[] args) throws IOException {
        // 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        br.close();

        // data 저장
        Deque<Integer> dq = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            dq.add(i);
        }

        // process
        while (dq.size() > 1) {
            // 제일 위의 숫자 버리기
            dq.poll();

            // 다음 숫자 저장한 후 맨 뒤로 이동
            int next = dq.poll();
            dq.add(next);
        }

        // output
        System.out.println(dq.poll());
    }
}
