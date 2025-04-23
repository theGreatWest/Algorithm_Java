package DailyCheckUp.Date_25_04_N.D23.모의고사;

import java.util.*;
import java.io.*;

public class SWEA_1873_상호의배틀필드 {
    static final Map<Character, int[]> orderToDirection = new HashMap<>();
    static {
        orderToDirection.put('U', new int[]{-1, 0});
        orderToDirection.put('D', new int[]{1, 0});
        orderToDirection.put('L', new int[]{0, -1});
        orderToDirection.put('R', new int[]{0, 1});
    }
    static final Map<Character, Character> readDirectionToOrder = new HashMap<>();
    static {
        readDirectionToOrder.put('^', 'U');
        readDirectionToOrder.put('v', 'D');
        readDirectionToOrder.put('<', 'L');
        readDirectionToOrder.put('>', 'R');
    }

    static int H, W, N;
    static char[][] map;
    static int currI, currJ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken()); // 높이(세로), i
            W = Integer.parseInt(st.nextToken()); // 너비(가로), j

            map = new char[H][W];
            for(int i=0;i<H;i++){
                String input = br.readLine();
                for(int j=0;j<W;j++){
                    map[i][j] = input.charAt(j);
                    if("^<v>".contains(String.valueOf(map[i][j]))){
                        currI = i;
                        currJ = j;
                    }
                }
            }

            N = Integer.parseInt(br.readLine());
            String orders = br.readLine();
            for(int i=0;i<N;i++){
                char order = orders.charAt(i);
                if(order=='S') shoot();
                else{
                    changeCurrDir(order);
                    move();
                }
            }

            sb.append("#").append(t).append(" ").append(printMap());
        }

        System.out.print(sb);
    }

    static void move(){
        int[] dir = orderToDirection.get(readDirectionToOrder.get(map[currI][currJ]));
        int di = dir[0];
        int dj = dir[1];

        int ni = currI + di;
        int nj = currJ + dj;

        if(!oor(ni, nj) && map[ni][nj]=='.'){
            map[ni][nj] = map[currI][currJ];
            map[currI][currJ] = '.';
            currI = ni;
            currJ = nj;
        }
    }

    static void changeCurrDir(char order){
        if(order=='U') map[currI][currJ] = '^';
        else if(order=='D') map[currI][currJ] = 'v';
        else if(order=='L') map[currI][currJ] = '<';
        else  map[currI][currJ] = '>';
    }

    static void shoot(){
        int[] dir = orderToDirection.get(readDirectionToOrder.get(map[currI][currJ]));
        int di = dir[0];
        int dj = dir[1];

        int ni = currI;
        int nj = currJ;
        while(true){
            ni += di;
            nj += dj;

            if(oor(ni, nj) || map[ni][nj]=='#') break;
            else if(map[ni][nj]=='*'){
                map[ni][nj] = '.';
                break;
            }
        }
    }

    static boolean oor(int i, int j){
        return i<0 || j<0 || i>=H || j>=W;
    }

    static String printMap(){
        StringBuilder res = new StringBuilder();
        for(int i=0;i<H;i++){
            for(int j=0;j<W;j++){
                res.append(map[i][j]);
            }
            res.append("\n");
        }
        return res.toString();
    }
}
