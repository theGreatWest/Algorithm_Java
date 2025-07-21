package DailyCheckUp.Date_25_07_N.D21;

import java.util.*;

public class 프로그래머스_고득점Kit_해시_폰켓몬 {
    public int main(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int kind : nums) {
            map.put(kind, map.getOrDefault(kind, 0) + 1);
        }

        return Math.min(map.size(), nums.length / 2);
    }
}
