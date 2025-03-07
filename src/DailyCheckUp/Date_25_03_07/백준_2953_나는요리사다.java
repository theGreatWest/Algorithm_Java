package DailyCheckUp.Date_25_03_07;

import java.util.*;
import java.io.*;

public class 백준_2953_나는요리사다 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int bestIdx = 0, bestScore = 0;
        for(int t=1;t<=5;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sumScore = 0;
            for(int i=0;i<4;i++){
                sumScore += Integer.parseInt(st.nextToken());
            }
            if(sumScore > bestScore){
                bestIdx = t;
                bestScore = sumScore;
            }
        }

        System.out.println(bestIdx+" "+bestScore);
    }
}
