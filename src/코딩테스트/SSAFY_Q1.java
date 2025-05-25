package 코딩테스트;

import java.util.*;
import java.io.*;

// 문제1
// N명의 사용자가 있는 앱이 있다.
//회사는 모든 사용자에게 동일한 수의 광고를 보여줄 것이다.
//각 i번째 사용자는 앱의 광고 수가 A[i]개 이하이면 무료 버전을 사용하고, 회사는 각 무료 사용자가 시청하는 광고 하나당 B원의 광고비를 받는다.
//광고 수가 A[i]개를 초과하면 P원을 내고 유료 버전을 사용한다.
//회사가 얻을 수 있는 최대 이익을 구하라.
//모든 사용자에게는 동일한 수의 광고가 게시됨에 주의하라.
//
//아래 입력 예의 첫 번째 테스트 케이스의 경우, 다음과 같이 확인 할 수 있다.
//광고가 1개인 경우 : 무료 광고 수입 6원, 유료 버전 수입 0원이므로 총 수익이 6원이다.
//광고가 2개인 경우 : 무료 광고 수입 12원, 유료 버전 수입 0원이므로 총 수익이 12원이다.
//광고가 3개인 경우 : 무료 광고 수입 12원, 유료 버전 수입 6원이므로 총 수익이 18원이다.
//광고가 4개인 경우 : 무료 광고 수입  8원, 유료 버전 수입 12원이므로 총 수익이 20원이다.
//광고가 5개인 경우 : 무료 광고 수입  0원, 유료 버전 수입 18원이므로 총 수익이 18원이다.
//따라서 최대 이익은 20원이다.
//
//[제약사항]
//1.	N은 3 이상 500 이하이다. (3 ≤ N ≤ 500)
//2.	P와 B는 1 이상 60 이하의 정수이다.
//3.	A[i]의 값은 1 이상 100 이하의 정수이다.
//
//[입력]
//가장 첫 줄에는 테스트 케이스의 총 수가 주어진다.
//그 다음 줄부터 각 테스트 케이스가 주어지며, 각 테스트 케이스는 2줄로 구성된다.
//각 테스트 케이스의 첫 줄에는 N, P, B의 값이 주어진다.
//다음 줄에 A[i]의 값들이 주어진다.
//
//[출력]
//출력의 각 줄은 최대 이익을 출력한다.

public class SSAFY_Q1 {

    static int N, P, B;
    static int[] A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken() );
            P = Integer.parseInt(st.nextToken() );
            B = Integer.parseInt(st.nextToken() );
            A = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            long res = 0;
            for(int adNum=1; adNum<=101; adNum++){
                // ad의 수가 A[i]개 이하 -> 무료 - 광고 하나당 B원
                // ad의 수가 A[i]개 초과 -> 유료 - P원
                long tmp = 0;
                for(int i = 0; i <N; i++){
                    tmp += ( (adNum<=A[i]) ? adNum*(long)B : P );
                }

                res = Math.max(res, tmp);
            }

            System.out.println("#"+t+" "+res);
        }
    }

}
