package DailyCheckUp.Date_25_04_N.D08;

import java.io.*;

public class SWEA_1289_원재의메모리복구하기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=1;t<=T;t++){
            String input = br.readLine();

            int curr = 0, res = 0;
            for(int i=0;i<input.length();i++){
                int inputIValue = input.charAt(i)-'0';
                if(inputIValue != curr){
                    curr = (curr+1)%2;
                    res++;
                }
            }

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder();
//
//        int T = Integer.parseInt(br.readLine());
//        for(int t=1;t<=T;t++){
//            String input = br.readLine();
//            int n = input.length(), res = 0;
//            String make = "";
//            for(int r=0;r<n;r++){
//                make += "0";
//            }
//
//            for(int i=0;i<n;i++){
//                int makeValue = Integer.parseInt(Character.toString(make.charAt(i)));
//                int inputValue = Integer.parseInt(Character.toString(input.charAt(i)));
//
//                if(makeValue != inputValue){
//                    res++;
//                    make = make.substring(0, i);
//                    if(makeValue==1 && inputValue==0){
//                        for(int r=0;r<n-i;r++){
//                            make += "0";
//                        }
//                    }else {
//                        for(int r=0;r<n-i;r++){
//                            make += "1";
//                        }
//                    }
//                }
////                System.out.println("make = " + make);
//            }
//
//            sb.append("#").append(t).append(" ").append(res).append("\n");
//        }
//
//        System.out.print(sb);
//    }
}
