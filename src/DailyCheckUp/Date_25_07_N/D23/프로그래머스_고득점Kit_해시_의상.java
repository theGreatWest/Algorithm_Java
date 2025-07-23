package DailyCheckUp.Date_25_07_N.D23;

import java.util.*;

public class 프로그래머스_고득점Kit_해시_의상 {
    public int solution(String[][] clothes) {
        // 카테고리별 수량 요약
        Map<String, Integer> map = new HashMap<>();
        for(String[] cs : clothes){
            String name = cs[0];
            String kind = cs[1];

            map.put(kind, map.getOrDefault(kind, 0)+1);
        }

//  기본적인 반복문(for문) 이용하기
        // int res = 1;
        // int[]  values = map.values().stream().mapToInt(Integer::intValue).toArray();
        // for(int value : values){
        //     res *= (value+1); // 해당 옷을 안 입는 경우까지 합쳐서 각 케이스에 +1한 다음 곱해주기
        // }

//  스트림 사용한 방법: .reduce() 사용하기
        int res = map.values().stream().mapToInt(Integer::intValue)
                .reduce(1, (result, item)-> result *= (item+1));
        // .reduce() : 스트림 내부의 모든 요소를 하나의 값으로 축약해서(합계, 곱, 최대값 등) 반환
        // result의 초기값이 1이고, 각 item을 누적해 준 값을 반환해준다.

        return --res; // 아무것도 안 입는 경우 제외해 주기

// DFS 이용하기
//         res = 0;
//         for(int selectNum=1; selectNum<=map.size(); selectNum++){
//             sc = new int[selectNum];
//             dfs(0, 0, selectNum);
//         }

//         return res;
    }

//  DFS: 겹치지 않게 조합 생성
//     void dfs(int saveIdx, int startIdx, int selectNum){
//         if(saveIdx>=selectNum){
//             int t = 1;
//             for(int i=0;i<sc.length; i++){
//                 t *= sc[i];
//             }
//             res+=t;
//             return;
//         }

//         for(int i=startIdx;i<values.length;i++){
//             sc[saveIdx] = values[i];
//             dfs(saveIdx+1, i+1, selectNum);
//         }
//     }
}
