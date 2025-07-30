package DailyCheckUp.Date_25_07_N.D30;

import java.util.*;

public class 프로그래머스_고득점Kit_DFSBFS_여행경로 {
    static List<String[]> res = new ArrayList<>();
    static List<String> path = new ArrayList<>();
    static boolean[] used;

    public String[] solution(String[][] tickets) {
        used = new boolean[tickets.length];
        path.add("ICN");

        dfs("ICN", tickets, 0);

        // 알파벳 순 정렬
        res.sort((a, b) -> {
            for (int i = 0; i < a.length; i++) {
                int cmp = a[i].compareTo(b[i]);
                if (cmp != 0) return cmp;
            }
            return 0;
        });

        return res.get(0);
    }

    void dfs(String current, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            res.add(path.toArray(new String[0]));
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!used[i] && tickets[i][0].equals(current)) {
                used[i] = true;
                path.add(tickets[i][1]);
                dfs(tickets[i][1], tickets, depth + 1);
                used[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
