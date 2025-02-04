package 자료구조.스택_큐;

import java.io.*;
import java.util.*;

public class 백준_2164_카드2 {
    public static void main(String[] args) throws IOException {
        // input
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        // process
        LinkedList<Integer> cards = new LinkedList<>();
        for(int i=1;i<=n;i++){
            cards.add(i);
        }

        while(cards.size() >=2){
            cards.removeFirst();
            cards.add(cards.poll());
        }

        System.out.println(cards.poll());
    }
}
