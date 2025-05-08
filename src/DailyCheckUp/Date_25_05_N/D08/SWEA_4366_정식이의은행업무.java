package DailyCheckUp.Date_25_05_N.D08;

import java.util.*;
import java.io.*;

public class SWEA_4366_정식이의은행업무 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();

        int TC = Integer.parseInt(br.readLine());
        for(int tc=1;tc<=TC;tc++){
            String[] two = br.readLine().split("");
            Set<Integer> case2 = new HashSet<>();
            for(int i=0;i<two.length;i++){
                String origin = two[i];
                two[i] = origin.equals("0") ? "1" : "0";
//                case2.add(nToTen(two, true));
                case2.add(nToTen2(two, true));
                two[i] = origin;
            }

            String[] three = br.readLine().split("");
            Set<Integer> case3 = new HashSet<>();
            for(int i=0;i<three.length;i++){
                String origin = three[i];
                for(int j=0;j<3;j++){
                    if(origin.equals(Integer.toString(j))) continue;

                    three[i] = Integer.toString(j);
//                    case3.add(nToTen(three, false));
                    case3.add(nToTen2(three, false));
                }
                three[i] = origin;
            }

            res.append("#").append(tc).append(" ");
            for(int v2 : case2){
                if(case3.contains(v2)){
                    res.append(v2);
                    break;
                }
            }
            res.append("\n");
        }

        System.out.print(res);
    }

    static int nToTen(String[] arr, boolean version){
        int ver = (version) ? 2 : 3; // true: 2진수, false: 3진수
        int dec = 0;
        int sum = 0;
        for(int i=arr.length-1; i>=0; i--){
            sum += Integer.parseInt(arr[i]) * (int)Math.pow(ver, dec++);
        }
        return sum;
    }

    // 누적 곱 방식: 오...!
    // 지금까지 만든 숫자에 진법 곱하고, 다음 수 더하기
    // a × 3^2 + b × 3^1 + c × 3^0
    // ---> ((a × 3 + b) × 3 + c)
    static int nToTen2(String[] arr, boolean isBinary) {
        int base = isBinary ? 2 : 3;
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * base + Integer.parseInt(arr[i]);
        }
        return result;
    }
}
