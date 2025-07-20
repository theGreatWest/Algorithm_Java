package DailyCheckUp.Date_25_07_N.D20;

import java.util.*;

public class 프로그래머스_고득점Kit_DFSBFS_네트워크 {
    public int main(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int res = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                q.offer(i);
                visited[i] = true;

                while(!q.isEmpty()){
                    int currCtNum = q.poll();

                    for(int j=0;j<n;j++){
                        if(computers[currCtNum][j]==1 && !visited[j]){
                            q.offer(j);
                            visited[j] = true;
                        }
                    }
                }

                res++;
            }
        }

        return res;
    }
}
