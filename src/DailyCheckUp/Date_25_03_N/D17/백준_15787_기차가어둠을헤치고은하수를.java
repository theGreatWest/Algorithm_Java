package DailyCheckUp.Date_25_03_N.D17;

import java.util.*;
import java.io.*;

public class 백준_15787_기차가어둠을헤치고은하수를 {
    static int n, m;
    static List<String>[] trains;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        trains = new LinkedList[n+1]; // 1~n : 기차 번호, 각 좌석 20개 나열
        for(int i=1;i<=n;i++){
            trains[i] = new LinkedList<>();
            for(int j=0;j<20;j++){
                trains[i].add("0");
            }
        }

        for(int o=0;o<m;o++){
            st = new StringTokenizer(br.readLine());
            int order = Integer.parseInt(st.nextToken());
            if(order == 1){
                int i = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken())-1;
                if(trains[i].get(x).equals("0")) trains[i].set(x, "1");

            }else if(order == 2){
                int i = Integer.parseInt(st.nextToken()), x = Integer.parseInt(st.nextToken())-1;
                if(trains[i].get(x).equals("1")) trains[i].set(x, "0");

            }else if(order == 3){
                int i = Integer.parseInt(st.nextToken());
                trains[i].add(0,"0");
                trains[i].remove(trains[i].size()-1);

            }else{
                int i = Integer.parseInt(st.nextToken());
                trains[i].add("0");
                trains[i].remove(0);

            }
        }

//        List<String> lists = new ArrayList<>();
//        int cnt=0;
//        for(int i=1;i<=n;i++){
//            String str = String.join("", trains[i]);
//            if(!lists.contains(str)) {
//                lists.add(str);
//                cnt++;
//            }
//        }
//        System.out.println(cnt);

        // 아.. 다른 사람은 이걸 HashSet 으로 만들었구나..!
        // 앞으로 중복을 검사하는 것은 Set 을 이용하자 💪🏻
        Set<String> sets = new HashSet<>();
        for(int i=1;i<=n;i++){
            sets.add(String.join("", trains[i]));
        }
        System.out.println(sets.size());
    }
}
