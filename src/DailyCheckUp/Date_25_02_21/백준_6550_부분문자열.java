package DailyCheckUp.Date_25_02_21;

import java.io.*;

public class 백준_6550_부분문자열 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while((line = br.readLine()) != null){
            String[] tmp = line.split(" ");
            String s = tmp[0];
            String t = tmp[1];

            StringBuilder sb = new StringBuilder();
            int startIdx = 0;
            for (int i = 0; i < s.length(); i++) {
                char target = s.charAt(i);

                boolean find = false;
                while (!find && startIdx < t.length()) {
                    if (t.charAt(startIdx) == target) {
                        sb.append(target);
                        find = true;
                    }
                    startIdx++;
                }
            }

            System.out.println((s.equals(sb.toString()) ? "Yes" : "No"));
        }
    }


}
