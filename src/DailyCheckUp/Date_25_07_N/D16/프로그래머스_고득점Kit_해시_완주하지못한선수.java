package DailyCheckUp.Date_25_07_N.D16;

import java.io.*;
import java.util.*;

public class 프로그래머스_고득점Kit_해시_완주하지못한선수 {
    public static void main(String[] args) throws IOException {
        String[] participant = new String[10];
        String[] completion = new String[9];

        Map<String, Integer> map = new HashMap<>();
        for (String name : participant) {
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        for (String name : completion) {
            map.replace(name, map.get(name) - 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) > 0) {
                System.out.println(name);
                break;
            }
        }
        System.out.println("None");
    }
}
