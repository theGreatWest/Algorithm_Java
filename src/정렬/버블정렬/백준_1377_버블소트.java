package 정렬.버블정렬;

import java.util.*;
import java.io.*;

public class 백준_1377_버블소트 {
    // 왜 왼쪽으로 가장 많이 이동한 값을 찾아야 되는지 모르겠다.
    // 아... 해결!!
    // 왼쪽 -> 오른쪽 : 한 번의 For 루프 당 n번 가능
    // 오른쪽 -> 왼쪽 : 한 번의 For 루프 당 1번 가능
    // 이런 이유로 왼쪽으로 이동한 횟수 중 가장 큰 값을 구하는구나..!!

    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        // process
        Map<Integer, Integer> origin = idx(arr);
        Arrays.sort(arr);
        Map<Integer, Integer> sorted = idx(arr);

        int max = Integer.MIN_VALUE;
        for(int value : origin.keySet()){
            int num = origin.get(value) - sorted.get(value);
            if(num > max) max = num;
        }

        // output
        System.out.println(++max);
    }

    static Map<Integer, Integer> idx(int[] arr){
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++){
            map.put(arr[i], i);
        }
        return map;
    }
}
