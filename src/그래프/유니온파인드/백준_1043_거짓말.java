package 그래프.유니온파인드;

import java.util.*;
import java.io.*;

public class 백준_1043_거짓말 {
    static int[] ps;
    static List<int[]> pts = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int persons = Integer.parseInt(st.nextToken()), parties = Integer.parseInt(st.nextToken());

        // 파티 참석자 배열
        ps = new int[persons + 1];
        for (int i = 1; i <= persons; i++) {
            ps[i] = i;
        }

//        System.out.println("전 > "+Arrays.toString(ps));

        // 진실을 아는 참석자 번호 저장
        st = new StringTokenizer(br.readLine());
        int knowTruth = Integer.parseInt(st.nextToken());
        if (knowTruth == 0) { // 진실을 아는 사람들이 없으면 모든 파티에서 과장 가능
            System.out.println(parties);
            return;
        }
        // 진실을 아는 사람의 번호 저장
        List<Integer> knowTruths = new ArrayList<>();
        for (int i = 0; i < knowTruth; i++) {
            knowTruths.add(Integer.parseInt(st.nextToken()));
        }

        // 파티 참석자들 연결 관계 파악
        // 어떤 두 사람이 다른 파티에 참석해도, 제 3자와 각각이 함께 파티에 참석했다면 두 명도 연결되어 있다고 본다.
        // 연결 관계 저장 후, 루트 노드가 진실을 알고 있는 참석자들에 포함되면 거짓말 X
        for (int i = 0; i < parties; i++) {
            st = new StringTokenizer(br.readLine());
            int attend = Integer.parseInt(st.nextToken());

            // 파티 참석자들 저장
            int[] sameParty = new int[attend];
            for (int j = 0; j < attend; j++) {
                sameParty[j] = Integer.parseInt(st.nextToken());
            }
            pts.add(sameParty);

            // 같은 파티 참석하는 사람들 연결
            for (int j = 0; j < attend - 1; j++) {
                union(sameParty[j], sameParty[j + 1]);
            }
        }

//        System.out.println("후 > "+Arrays.toString(ps));

        int count = 0;
        for(int[] sameParty : pts){
            boolean lie = true;
            for(int p : sameParty){
                if(!lie) break;

                for(int t : knowTruths){
                    if(isConnected(p, t)){
                        lie = false;
                        break;
                    }
                }
            }
            if(lie) count++;
        }

        System.out.println(count);
    }

    static int find(int personNum) {
        if (ps[personNum] == personNum) return personNum;
        return ps[personNum] = find(ps[personNum]);
    }

    static void union(int a, int b) {
        int p1 = Math.max(a, b);
        int p2 = Math.min(a, b);

        p1 = find(p1);
        p2 = find(p2);

        if (p1 != p2) ps[p1] = p2;
    }

    static boolean isConnected(int p1, int p2) {
        p1 = find(p1);
        p2 = find(p2);

        return p1 == p2;
    }
}
