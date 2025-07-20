package DailyCheckUp.Date_25_07_N.D20;

import java.util.*;

public class 프로그래머스_고득점Kit_정렬_K번째수 {
    public int[] main(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length;i++){
            answer[i] = process(array, commands[i]);
        }

        return answer;
    }

    int process(int[] array, int[] command){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=command[0]-1; i<command[1]; i++){
            pq.offer(array[i]);
        }

        /*
            이 방법 말고, 아래와 같은 방법 사용 가능
            1. 배열 분리: Arrays.copyOfRange(배열, 시작IDX, 끝IDX+1);
            2. 배열 정렬: Arrays.sort(배열);
            3. 원하는 수 반환: 배열[반환IDX];
        */

        int value = -1;
        for(int i=0; i<command[2]; i++){
            value = pq.poll();
        }

        return value;
    }
}
