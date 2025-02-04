package 자료구조.스택_큐;

import java.util.*;
import java.io.*;

public class 백준_17298_오큰수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Integer> s = new Stack<>();
        while (st.hasMoreTokens()) {
            int value = Integer.parseInt(st.nextToken());
            s.push(value);
        }

        List<String> res = new ArrayList<>();
        Stack<Integer> comp = new Stack<>();
        while (!s.isEmpty()) {
            int now = s.pop();

            while (!comp.isEmpty() && now >= comp.peek()) {
                    comp.pop();
                }

            if(comp.isEmpty()) res.add(Integer.toString(-1));
            else res.add(Integer.toString(comp.peek()));

            comp.push(now);
        }
        Collections.reverse(res);
        System.out.println(String.join(" ",res));
    }
}
