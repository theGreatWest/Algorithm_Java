package DailyCheckUp.Date_25_03_N.D24;

import java.io.*;
import java.util.*;

public class 백준_2503_숫자야구 {
    static List<String> comp = new ArrayList<>();
//    static List<Integer> comp = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

//        bfs(); // BFS 를 사용해 완전 탐색을 진행하는 것의 수행 시간이 더 빠르다.

        for(int i=123;i<=987;i++){
            int v0 = i/100;
            int v1 = (i%100)/10;
            int v2 = i%10;

            if(v1==0 || v2==0) continue;

            if(v0!=v1 && v0!=v2 && v1!=v2) {
//                System.out.print(v0);
//                System.out.print(v1);
//                System.out.println(v2);
                comp.add(String.valueOf(i));
            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] arr = Arrays.stream(st.nextToken().split("")).mapToInt(Integer::parseInt).toArray();
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

//            List<String> res = new ArrayList<>();
//            for(String cp : comp){
//                int s = 0, b = 0;
//
//                for(int j=0;j<3;j++){
//                    if(Integer.parseInt(String.valueOf(cp.charAt(j))) == arr[j]) s++;
//                    else if(cp.contains(Integer.toString(arr[j]))) b++;
//                }
//
//                if(s==strike && b==ball) res.add(cp);
//            }
//            comp = new ArrayList<>(res);

            List<String> res = new ArrayList<>();
            for(String cp : comp){
                int s=0, b=0;

                int[] tmp = Arrays.stream(cp.split("")).mapToInt(Integer::parseInt).toArray();

                for(int j=0;j<3;j++){
                    int inputValue = arr[j];

                    if(inputValue==tmp[j]) s++;
                    else if(inputValue==tmp[0] || inputValue==tmp[1] || inputValue==tmp[2]) b++;
                }

                if(s==strike && b==ball) res.add(cp);
            }
            comp = new ArrayList<>(res);
        }

        System.out.println(comp.size());

    }

    static void bfs(){
        Queue<String> q = new LinkedList<>();
        for(int i=1;i<=9;i++){
            q.offer(Integer.toString(i));
        }

        while(!q.isEmpty()) {
            String curr = q.poll();

            if(curr.length() == 3){
                comp.add(curr);
                continue;
            }

            for(int i=1;i<=9;i++){
                if(curr.contains(Integer.toString(i))) continue;

                q.offer(curr+i);
            }
        }
    }
}
