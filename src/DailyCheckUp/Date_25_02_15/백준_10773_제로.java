package DailyCheckUp.Date_25_02_15;

import java.util.*;
import java.io.*;

public class 백준_10773_제로 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<k;i++){
            int tmp = Integer.parseInt(br.readLine());
            if(tmp==0 && !stack.isEmpty()) stack.pop();
            else stack.push(tmp);
        }

        long sum = 0;
        while(!stack.isEmpty()){
            sum += stack.pop();
        }

        System.out.println(sum);
    }
}
