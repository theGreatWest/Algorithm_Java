package DailyCheckUp.Date_25_07_N.D22;

import java.util.*;

// str1.startWith(str2) : str1이 str2로 시작하는지 체크
// Arrays.asList(arr) : arr을 List로 변환

public class 프로그래머스_고득점Kit_해시_전화번호목록 {
    public boolean solution(String[] phone_book) {
        Set<String> set = new HashSet<>(Arrays.asList(phone_book));

        for (String phone : phone_book) {
            for (int i = 1; i < phone.length(); i++) {
                String prefix = phone.substring(0, i);
                if (set.contains(prefix)) {
                    return false;
                }
            }
        }

        return true;
    }
}
