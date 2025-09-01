package 코딩테스트.기업코테준비;

import java.util.*;
import java.io.*;

// https://www.codetree.ai/ko/frequent-problems/samsung-sw/problems/codetrees-gambit/description

public class 코드트리_갬빗 {
    static final int[] dx = {-1,-1,0,1,1,1,0,-1};
    static final int[] dy = {0,1,1,1,0,-1,-1,-1};

    static int H, W, N, K, A, B;
    static Item[] items;
    static Item[][] map;
    static List<Integer> whiteIdx, blackIdx;

    public static void main(String[] args) throws IOException {
// 기물 정보 입력 및 저장
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken()); // 행의 개수
        W = Integer.parseInt(st.nextToken()); // 열의 개수
        N = Integer.parseInt(st.nextToken()); // 흰색과 검정색 킹 기물의 수(각각 N개씩 올라가 있음)
        K = Integer.parseInt(st.nextToken()); // 턴의 수: 한 턴에 모든 기물이 움직여야
        A = Integer.parseInt(st.nextToken()); // 자기 팀의 킹 기물을 밀칠 때 주는 대미지
        B = Integer.parseInt(st.nextToken()); // 상대 팀의 킹 기물을 밀칠 때 주는 대미지
        // 폰은 각 색상별로 1개씩

        map = new Item[H][W];
        items = new Item[2*N + 2]; // 주어지는 기물의 순서대로 각 턴에 움직여야
        whiteIdx = new ArrayList<>(); // 흰색 기물들의 인덱스 저장
        blackIdx = new ArrayList<>(); // 검은색 기물들의 인덱스 저장
        for(int i=0; i<2*N+2; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken(); // 기물의 이름
            int h = Integer.parseInt(st.nextToken()); // 기물의 행
            int w = Integer.parseInt(st.nextToken()); // 기물의 열

            Item item = new Item(name, h, w);

            char tmp = name.charAt(0);
            if(Character.toUpperCase(tmp) == tmp) {
                whiteIdx.add(i);
                item.color = true;
            }else {
                blackIdx.add(i);
                item.color = false;
            }

            items[i] = item;
            map[h][w] = item;
        }

        // 흰색 킹 기물들과 흰색 폰의 방향 선호도 저장
        int idx = 0;
        for(String pref : br.readLine().split(" ")){
            items[whiteIdx.get(idx++)].dir = Arrays.stream(pref.split("")).mapToInt(Integer::parseInt).toArray();
        }

        // 검은색 킹 기물들과 검은색 폰의 방향 선호도
        idx = 0;
        for(String pref : br.readLine().split(" ")){
            items[blackIdx.get(idx++)].dir = Arrays.stream(pref.split("")).mapToInt(Integer::parseInt).toArray();
        }

        // 흰색 킹 기물들의 체력 1 -> N
        idx = 0;
        for(int stam : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()){
            items[whiteIdx.get(idx++)].stamina = stam;
        }

        // 검은색 킹 기물들의 체력 1 -> N
        idx = 0;
        for(int stam : Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()){
            items[blackIdx.get(idx++)].stamina = stam;
        }

// >> 삭제 예정: 기물 정보 확인
        for(Item item : items){
            item.print();
        }

// 프로세스
        // 한 턴은 모든 기물이 움직여야 끝
        // 킹의 체력이 1보다 작아지면 파괴
        // 킹: Kn (흰색은 대문자, 검은색은 소문자)
        // 폰: P
        // 폰이 승진 -> 모든 상대방 킹 기물들에게 대미지(해당 폰과 킹 기물 사이의 거리) -> 게임 종료
        // 승진한 흰색 폰은 Q, 승진한 검은색 폰은 q로 표시
        // 킹
        for(int k=0; k<K; k++){
            for(Item item : items){ // 각 턴에 모든 기물이 움직이도록 설계
                char ik = item.name.charAt(0);

                if(ik=='K' || ik=='k'){ // 킹이라면
                    // 한 칸 전진할 방향 설정
                    // 자신의 폰과 상대의 영역 사이의 거리가 가장 작은
                    // 그런 곳이 여러개 -> 폰의 최종 위치의 행 번호가 가장 작은
                    // 그런 곳이 없다면 -> 방향 선호도가 높은 곳으로 움직이기
                    // 움직이는 위치에 아무 것도 없다면, 킹이 그 위치로 이동
                    // 움직이는 위치에 어떤 기물이 존재, 기물 밀치기(연쇄적으로 작용 가능) == while()문
                    // 밀쳐진 기물은 밀친 기물이 이동하는 방향 그대로 한 칸 이동
                    // 기물이 가는 위치에 아무 기물도 존재하지 않거나, 밀쳐진 기물이 체스판 밖으로 밀려나갈 때까지 반복
                    // 킹 기물은 상대방의 폰을 절대 밀쳐서는 안 됨
                    // 자기 팀의 킹 밀침 -> 밀쳐진 킹은 A의 대미지
                    // 상대 팀의 킹 밀침 -> ''' B의 대미지
                    // 상대방의 폰을 밀치거나 || 자기 팀의 폰이 체스판 밖으로 나가게 되는 경우 ==> 밀치는 행동 X + 밀친 킹 파괴

                }else{ // 폰이라면
                    // 그룹 판별: 인접+같은 색이라면 같은 그룹 -> dfs로 그룹 판별
                    List<Item> group = new ArrayList<>();
                    dfs(item, group, new boolean[H][W]);

                    // 움직이려는 폰이 속한 그룹에서, 기물의 수가 5 이상이라면 자리 바꾸기(선택) 가능.
                    // 자리 바꿀 기물 선택 기준
                    // 폰과 승진할 수 있는 위치 사이의 거리가 가장 작아지는 기물 선택
                    // 그런 기물이 여러개라면, 해당 폰과 같은 팀의 모든 킹들과의 거리의 합이 가장 작아지는 기물 선택
                    // 그런한 기물 또한 여러개, 열 번호가 가장 작은 기물 선택
                    if(group.size() >= 5){

                    }
                }
            }
        }
    }

    // 데미지 측정
    static int dmg(int i1, int j1, int i2, int j2){
        return (int)(Math.pow((i1-i2), 2) + Math.pow((j1-j2), 2));
    }

    // 승진 여부 판단
    static boolean isPrm(Item item){
        return false;
    }

    // 범위 유효성 판단
    static boolean isValidPos(int i, int j){
        return i>=0 && i<H && j>=0 && j<W;
    }

    // 그룹 판별
    static void dfs(Item item, List<Item> group, boolean[][] visited){
        visited[item.i][item.j] = true;
        group.add(item);

        for(int d : item.dir){
            int ni = item.i + dx[d];
            int nj = item.j + dy[d];

            if(isValidPos(ni, nj) && map[ni][nj].color==item.color && !visited[ni][nj]){
                dfs(map[ni][nj], group, visited);
            }
        }
    }

    static class Item {
        String name;
        int i;
        int j;
        int stamina = 0;
        int[] dir = null;
        boolean color; // white: true, black: false

        public Item(String name, int i, int j){
            this.name = name;
            this.i = i;
            this.j = j;
        }

        public void print(){
            System.out.println(name+", "+i+", "+j+", "+stamina+", "+Arrays.toString(dir));
        }
    }
}
