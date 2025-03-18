package DailyCheckUp.Date_25_03_N.D18;

import java.io.*;
import java.util.*;

public class 백준_1620_나는야포켓몬마스터이다솜 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());

        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            String name = br.readLine();
            map.put(Integer.toString(i), name);
            map.put(name, Integer.toString(i));
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(map.get(br.readLine())).append("\n");
        }

        System.out.print(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//        int n = Integer.parseInt(st.nextToken()), m = Integer.parseInt(st.nextToken());
//
//        Map<Integer, String> numToName = new HashMap<>();
//        Map<String, Integer> nameToNum = new HashMap<>();
//        for (int i = 1; i <= n; i++) {
//            String name = br.readLine();
//            numToName.put(i, name);
//            nameToNum.put(name, i);
//        }
//
//        StringBuilder sb = new StringBuilder();
//        for(int i=0;i<m;i++){
//            String input = br.readLine();
//            try {
//                int num = Integer.parseInt(input);
//                sb.append(numToName.get(num));
//            }catch (Exception e){
//                sb.append(nameToNum.get(input));
//            }
//            sb.append("\n");
//        }
//
//        System.out.print(sb);
//    }
}
