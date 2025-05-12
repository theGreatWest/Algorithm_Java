package DailyCheckUp.Date_25_05_N.D12;

import java.util.*;
import java.io.*;

public class SWEA_4130_모의SW역량테스트_특이한자석 {
    static int K;
    static List<Integer>[] info;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t <= T; t++) {
            K = Integer.parseInt(br.readLine());

            info = new ArrayList[5];
            for(int i=1;i<=4;i++){
                info[i] = new ArrayList();

                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j <8; j++){
                    info[i].add(Integer.parseInt(st.nextToken()));
                }
            }

            for(int k = 0; k <K; k++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                int num = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());

                int[] rInfo = new int[5];
                rInfo[num] = r;

                int ln = num;
                int lr = r;
                while(--ln >= 1){
                    int lv = info[ln].get(2);
                    int rv = info[ln+1].get(6);

                    if(lv == rv) break;

                    lr *= -1;
                    rInfo[ln] = lr;
                }
                ln = num;
                lr = r;
                while(++ln <=4){
                    int lv = info[ln-1].get(2);
                    int rv = info[ln].get(6);

                    if(lv == rv) break;

                    lr *= -1;
                    rInfo[ln] = lr;
                }

                for(int i=1;i<=4;i++){
                    rotate(rInfo[i], i);
                }
            }

            sb.append("#").append(t).append(" ").append(result()).append("\n");
        }

        System.out.print(sb);
    }

    static void rotate(int clockwise, int num){
        if(clockwise==1){
            int lastValue = info[num].get(7);
            info[num].remove(7);
            info[num].add(0, lastValue);
        }else if(clockwise==-1){
            int firstValue = info[num].get(0);
            info[num].remove(0);
            info[num].add(firstValue);
        }
    }

    static int result(){
        int res = 0;
        for(int i=1;i<=4;i++){
            res += info[i].get(0) * (int)Math.pow(2, (i-1));
        }
        return res;
    }
}
