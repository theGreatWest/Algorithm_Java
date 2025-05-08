package DailyCheckUp.Date_25_05_N.D08;

import java.io.*;

public class SWEA_1233_사칙연산유효성검사 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder res = new StringBuilder();

        int TC = 10;
        for (int tc = 1; tc <= TC; tc++) {
            int N = Integer.parseInt(br.readLine());
            boolean valid = true;

            for (int i = 0; i < N; i++) {
                String[] tmp = br.readLine().split(" ");
                if(valid){
                    if(tmp.length==4){
                        if (!isOp(tmp[1]) || !isChildren(tmp[0], tmp[2], tmp[3]))
                            valid = false;
                    }else if(tmp.length==2){
                        try{
                            Integer.parseInt(tmp[1]);
                        }catch (Exception e){
                            valid = false;
                        }
                    }else valid = false;
                }
            }

            res.append("#").append(tc).append(" ").append((valid) ? 1 : 0).append("\n");
        }

        System.out.print(res);
    }

    static boolean isOp(String op) {
        switch (op) {
            case "*":
            case "/":
            case "+":
                return true;
        }
        return op.equals("-");
    }

    static boolean isChildren(String parent, String left, String right) {
        int p = Integer.parseInt(parent);
        int l = Integer.parseInt(left);
        int r = Integer.parseInt(right);

        if (p * 2 != l) return false;
        return (r - l) == 1;
    }
}
