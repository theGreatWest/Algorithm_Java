package DailyCheckUp.Date_25_04_N.D22;

import java.io.*;

public class SWEA_20019_회문의회문 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            sb.append("#").append(t).append(" ").append( palindrome(br.readLine()) ? "YES" : "NO").append("\n");
        }

        System.out.print(sb);
    }

    static boolean palindrome(String s){
        // S 가 회문인지
        if(!isPalindrome(s)) return false;

        // 처음 (len-1)/2 글자가 회문인지
        String tmp = s.substring(0, (s.length()-1)/2);
        if(!isPalindrome(tmp)) return false;

        // 마지막 (len-1)/2 글자가 회문인지
        tmp = s.substring(s.length()-((s.length()-1)/2));
        return isPalindrome(tmp);
    }

    static boolean isPalindrome(String str){
        StringBuilder res = new StringBuilder(str);
        return res.reverse().toString().equals(str);
    }
}
