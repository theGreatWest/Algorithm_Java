package DailyCheckUp.Date_25_03_N.D17;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class 백준_2455_지능형기차 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int curr = 0, maxValue = Integer.MIN_VALUE;
        for(int i=0;i<4;i++){
            int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int bye = inputs[0], hi = inputs[1];

            curr -= (bye - hi);
            curr = Math.min(10000, curr);

            maxValue = Math.max(maxValue, curr);
        }

        System.out.println(maxValue);
    }
}
