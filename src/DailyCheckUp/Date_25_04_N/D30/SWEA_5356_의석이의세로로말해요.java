package DailyCheckUp.Date_25_04_N.D30;

import java.io.*;

public class SWEA_5356_의석이의세로로말해요 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            String[] tmp = new String[5];
            int maxLen = 0;
            for(int i=0;i<5;i++){
                tmp[i] = br.readLine();
                if(tmp[i].length() > maxLen) maxLen = tmp[i].length();
            }

            String[][] words = new String[5][maxLen];
            for(int i=0;i<5;i++){
                int j=0;
                for(String s : tmp[i].split("")){
                    words[i][j++] = s;
                }
            }

            sb.append("#").append(t).append(" ");
            for(int j=0;j<maxLen;j++){
                StringBuilder res = new StringBuilder();
                for(int i=0; i<5;i++){
                    if(words[i][j]!=null) res.append(words[i][j]);
                }
                sb.append(res);
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
