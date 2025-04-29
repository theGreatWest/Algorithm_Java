package DailyCheckUp.Date_25_04_N.D29;

import java.util.*;
import java.io.*;

public class SWEA_4013_모의SW역량테스트_특이한자석 {
    static int K;
    static List<Integer>[] magnetic;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());

            magnetic = new ArrayList[5];
            for(int i=1;i<=4;i++){
                magnetic[i] = new ArrayList<>();
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j=0;j<8;j++){
                    magnetic[i].add(j, Integer.parseInt(st.nextToken()));
                }
            }

            for(int i=0;i<K;i++){
                int[] inputs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                int magneticNum = inputs[0];
                int direction = inputs[1];

                int[] rotate = new int[3]; // 각각 1,2 / 2,3 / 3,4 의 회전 여부 저장
                int a=1,b=2;
                for(int m = 0; m <3; m++){
                    rotate[m] = (magnetic[a].get(2)!=magnetic[b].get(6)) ? 1 : 0;
                    a++;
                    b++;
                }

                rotate(magneticNum, direction); // 해당 자석 움직이기
                // 이외의 자석 움직이기
                int left = magneticNum-1;
                int leftDir = direction*(-1);
                while(left>0){
                    a = left;
                    b = left+1;
                    int m = (a+b)/2-1;

                    if(rotate[m]==0) break;

                    rotate(left, leftDir);
                    left--;
                    leftDir *= -1;
                }

                int right = magneticNum+1;
                int rightDir = direction*(-1);
                while(right<=4){
                    a = right-1;
                    b = right;
                    int m = (a+b)/2-1;

                    if(rotate[m]==0) break;

                    rotate(right, rightDir);
                    right++;
                    rightDir *= -1;
                }
            }

            int score = 0;
            for(int i=1;i<=4;i++){
                score += magnetic[i].get(0) * (int)Math.pow(2,i-1);
            }

            sb.append("#").append(t).append(" ").append(score).append("\n");
        }

        System.out.print(sb);
    }

    // 1:시계방향, -1:반시계방향
    static void rotate(int magneticNum, int direction){
        if(direction==1){
            int value = magnetic[magneticNum].get(7);
            magnetic[magneticNum].remove(7);
            magnetic[magneticNum].add(0,value);
            return;
        }

        int value = magnetic[magneticNum].get(0);
        magnetic[magneticNum].remove(0);
        magnetic[magneticNum].add(value);
    }
}
