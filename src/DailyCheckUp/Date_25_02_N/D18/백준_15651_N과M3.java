package DailyCheckUp.Date_25_02_N.D18;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_15651_N과M3 {
    static int n, m;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        br.close();

        dfs(new int[m], 0);

        System.out.print(sb);
    }

    static void dfs(int[] values, int idx){
        if(idx==m){
            for(int i=0;i<m;i++){
                sb.append(values[i]).append(" ");
            }
            sb.append("\n");
            return;
        }

        for(int i=1;i<=n;i++){
            values[idx] = i;
            dfs(values, idx+1);
        }
    }
}
