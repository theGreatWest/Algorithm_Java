package DailyCheckUp.Date_25_03_N.D21;

import java.io.*;
import java.util.*;

public class 백준_2501_약수구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

// List 를 이용 + Collections.sort() 를 이용하는 방법의 시간 복잡도가 더 낮았다.

// TreeSet 을 이용해 접근하는 방법
        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i=1;i<=Math.sqrt(n);i++){
            if(n%i==0){
                treeSet.add(i);
                treeSet.add(n/i);
            }
        }

        if(treeSet.size() < k) System.out.println(0);
        else {
// Array 로 변환 후, Index 이용해 접근하는 방법
            System.out.println(treeSet.toArray()[k-1]);
// Iterator<> 를 이용한 방법
//            int cnt = 0;
//            Iterator<Integer> iter = treeSet.iterator();
//
//            while(iter.hasNext()){
//                int value = iter.next();
//                cnt++;
//
//                if(cnt==k) {
//                    System.out.println(value);
//                    break;
//                }
//            }
        }
    }
}
