package DailyCheckUp.Date_25_07_N.D16;

import java.util.*;

public class 프로그래머스_고득점Kit_스택큐_같은숫자는싫어 {
    public static void main(String[] args) {
        int[] arr = new int[100];
        List<Integer> ansList = new ArrayList<>();

        int prevValue = -1;
        for(int i=0;i<arr.length;i++){
            int currValue = arr[i];

            if(prevValue == currValue) continue;

            ansList.add(currValue);
            prevValue = currValue;
        }

        // int List -> int[]
        ansList.stream().mapToInt(Integer::intValue).toArray();
    }
}
