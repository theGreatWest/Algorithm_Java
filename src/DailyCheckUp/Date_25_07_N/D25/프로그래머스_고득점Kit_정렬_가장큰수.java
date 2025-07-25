package DailyCheckUp.Date_25_07_N.D25;

import java.util.*;

public class 프로그래머스_고득점Kit_정렬_가장큰수 {
    public String solution(int[] numbers) {
        // 정렬 1> PriorityQueue + 내부 class
        PriorityQueue<SortedValue> pq = new PriorityQueue<>();
        for (int n : numbers) {
            pq.offer(new SortedValue(Integer.toString(n)));
        }

        // 정렬 2> PriorityQueue + 람다식
        PriorityQueue<String> pq2 = new PriorityQueue<>((o1, o2) -> {
            return Integer.compare(Integer.parseInt(o2), Integer.parseInt(o1));
        });

        // 정렬 2> List + 람다식
        List<Integer> list = new ArrayList<>();
        list.sort((a, b) -> {
            return b - a;
        });

        // 정렬 3> Array + Comparator<>() {} 메서드
        String[] array = new String[100];
        Arrays.sort(array, new Comparator<>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.parseInt(o2) - Integer.parseInt(o1);
            }
        });

        // 정렬 3> Array + 람다식
        Arrays.sort(array, (o1, o2) -> {
            return Integer.parseInt(o2) - Integer.parseInt(o1);
        });

        // 정렬 2> Array + Collections.reversOrder();
        Arrays.sort(array, Collections.reverseOrder());


        StringBuilder res = new StringBuilder();
        while (!pq.isEmpty()) {
            SortedValue sv = pq.poll();

            res.append(sv.value);
        }

        String resValue = res.toString();
        return (resValue.charAt(0) == '0') ? "0" : res.toString();
    }

    class SortedValue implements Comparable<SortedValue> {
        String value;

        public SortedValue(String value) {
            this.value = value;
        }

        @Override
        public int compareTo(SortedValue o) {
            int case1 = Integer.parseInt(this.value + o.value);
            int case2 = Integer.parseInt(o.value + this.value);

            return case2 - case1;
        }
    }
}
