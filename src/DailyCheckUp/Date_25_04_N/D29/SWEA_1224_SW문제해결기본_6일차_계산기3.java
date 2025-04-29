package DailyCheckUp.Date_25_04_N.D29;

import java.util.*;
import java.io.*;

public class SWEA_1224_SW문제해결기본_6일차_계산기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = 10;
        for (int t = 1; t <= T; t++) {
            int n = Integer.parseInt(br.readLine());

            String postfix = infixToPostfix(br.readLine());
            int res = calculationPostfix(postfix);

            sb.append("#").append(t).append(" ").append(res).append("\n");
        }

        System.out.print(sb);
    }

    // 중위 -> 후위식 변경
    static String infixToPostfix(String formula) {
        Stack<Character> ops = new Stack<>();
        StringBuilder res = new StringBuilder();

        int i = 0;
        while (i < formula.length()) {
            char c = formula.charAt(i);

            if (Character.isDigit(c)) res.append(c - '0');
            else if (c == '(') {
                int endIdx = brackets(formula, ++i);
                res.append(infixToPostfix(formula.substring(i, endIdx)));
                i = endIdx + 1;
                continue;
            } else { // 연산자
                while (!ops.isEmpty() && priority(ops.peek()) >= priority(c)) {
                    res.append(ops.pop());
                }
                ops.push(c);
            }
            i++;
        }

        while (!ops.isEmpty()) {
            res.append(ops.pop());
        }

        return res.toString();
    }

    // 닫힘 인덱스 반환
    static int brackets(String formula, int startIdx) {
        int startBracketsNum = 0;
        for(int i=startIdx;i<formula.length();i++){
            char c = formula.charAt(i);

            if(c==')') {
                if (startBracketsNum == 0) return i;
                else startBracketsNum--;
            }

            if(c=='(') startBracketsNum++;
        }

        return -1;
    }

    static int calculationPostfix(String postfix){
        Stack<Integer> digits = new Stack<>();

        for(char c : postfix.toCharArray()){
            if(Character.isDigit(c)) digits.push(c-'0');
            else{ // 연산자
                compute(digits, c);
            }
        }

        return digits.pop();
    }

    static void compute(Stack<Integer> digits, char op){
        int b = digits.pop();
        int a = digits.pop();

        if(op=='+') digits.push(a+b);
        else if(op=='*') digits.push(a*b);
    }

    static int priority(char c) {
        if (c == '*' || c == '/') return 2;
        if (c == '+' || c == '-') return 1;
        return 0;
    }
}
