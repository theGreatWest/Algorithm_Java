package DailyCheckUp.Date_25_03_N.D23;

import java.io.*;

public class 백준_11328_Strfry {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String[] str = br.readLine().split(" ");

            if(str[0].equals(str[1])) {
                sb.append("Possible\n");
                continue;
            }

            if(str[0].length() != str[1].length()){
                sb.append("Impossible\n");
                continue;
            }

            int[] cnt = new int[26]; // - 97, - 'a'

            for(char c : str[0].toCharArray()){
                cnt[c - 'a']++;
            }

            boolean possible = true;
            for(char c : str[1].toCharArray()){
                int idx = c - 'a';

                if(cnt[idx]<=0){
                    possible = false;
                    break;
                }

                cnt[idx]--;
            }

            sb.append(possible ? "Possible" : "Impossible").append("\n");
        }

        System.out.print(sb);
    }
}
