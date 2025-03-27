package DailyCheckUp.Date_25_03_N.D27;

import java.io.*;
import java.util.*;

public class 백준_2597_줄자접기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double N = Double.parseDouble(br.readLine());

        double[][] points = new double[3][2];

        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            points[i][0] = Double.parseDouble(st.nextToken());
            points[i][1] = Double.parseDouble(st.nextToken());

            // 항상 작은 값이 앞에 오도록 정렬
            if (points[i][0] > points[i][1]) {
                double temp = points[i][0];
                points[i][0] = points[i][1];
                points[i][1] = temp;
            }
        }

        // 3번 접기
        for (int i = 0; i < 3; i++) {
            if (points[i][0] == points[i][1]) continue; // 이미 같은 위치면 패스

            double mid = (points[i][0] + points[i][1]) / 2.0;

            if (mid < N - mid) { // 오른쪽이 남는 경우
                for (int j = i + 1; j < 3; j++) {
                    if (points[j][0] < mid) points[j][0] = mid - points[j][0];
                    else points[j][0] -= mid;

                    if (points[j][1] < mid) points[j][1] = mid - points[j][1];
                    else points[j][1] -= mid;

                    // 항상 작은 값이 앞에 오도록 정렬
                    if (points[j][0] > points[j][1]) {
                        double temp = points[j][0];
                        points[j][0] = points[j][1];
                        points[j][1] = temp;
                    }
                }
                N = N - mid;
            } else { // 왼쪽이 남는 경우
                for (int j = i + 1; j < 3; j++) {
                    if (mid < points[j][0]) points[j][0] = mid - (points[j][0] - mid);
                    if (mid < points[j][1]) points[j][1] = mid - (points[j][1] - mid);

                    // 항상 작은 값이 앞에 오도록 정렬
                    if (points[j][0] > points[j][1]) {
                        double temp = points[j][0];
                        points[j][0] = points[j][1];
                        points[j][1] = temp;
                    }
                }
                N = mid;
            }
        }

        System.out.printf("%.1f\n", N);
    }
}