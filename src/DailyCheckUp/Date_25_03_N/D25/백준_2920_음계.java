package DailyCheckUp.Date_25_03_N.D25;

import java.util.*;
import java.io.*;

public class 백준_2920_음계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        boolean asc = true, desc = true;
        for(int i=1;i<=8;i++){
            int inputValue = inputs[i-1];

            if(inputValue != i) asc = false;
            if(inputValue != (9 - i)) desc = false;
        }

        if(asc) System.out.println("ascending");
        else if(desc) System.out.println("descending");
        else System.out.println("mixed");
    }

//
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String[] inputs = br.readLine().split(" ");
//
//        String original = String.join("", inputs);
//
//        Arrays.sort(inputs);
//        String asc = String.join("", inputs);
//
//        Arrays.sort(inputs, Comparator.reverseOrder());
//        String desc = String.join("", inputs);
//
//        if(original.equals(asc)) System.out.println("ascending");
//        else if(original.equals(desc)) System.out.println("descending");
//        else System.out.println("mixed");
//    }
}
