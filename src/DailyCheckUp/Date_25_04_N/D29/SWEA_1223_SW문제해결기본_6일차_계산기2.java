package DailyCheckUp.Date_25_04_N.D29;

import java.util.*;
import java.io.*;

public class SWEA_1223_SW문제해결기본_6일차_계산기2 {
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

    // 중위 -> 후위 표기식 변경
    static String infixToPostfix(String formula) {
        Stack<Character> operators = new Stack<>();
        StringBuilder res = new StringBuilder();

        for(char c : formula.toCharArray()){
            if(Character.isDigit(c)) res.append(c);
            else{
                while(!operators.isEmpty() && priority(operators.peek()) >= priority(c)){
                    res.append(operators.pop());
                }
                operators.push(c);
            }
        }

        while (!operators.isEmpty()) {
            res.append(operators.pop());
        }

        return res.toString();
    }

    // 후위 표기식 계산
    static int calculationPostfix(String formula) {
        Stack<Integer> digits = new Stack<>();

        for (char c : formula.toCharArray()) {
            if (Character.isDigit(c)) digits.push(c - '0');
            else {
                int a = digits.pop();
                int b = digits.pop();

                if (c == '+') digits.push(b + a);
                else if (c == '*') digits.push(b * a);
            }
        }

        return digits.pop();
    }

    // 전위 표기식 계산식
    static int calculationPrefix(String formula) {
        Stack<Integer> digits = new Stack<>();

        char[] cs = formula.toCharArray();
        for (int i = cs.length - 1; i >= 0; i--) {
            if (Character.isDigit(cs[i])) digits.push(cs[i] - '0');
            else {
                int a = digits.pop();
                int b = digits.pop();

                if (cs[i] == '+') digits.push(a + b);
                else if (cs[i] == '*') digits.push(a * b);
            }
        }

        return digits.pop();
    }

    // 중위 표기식 계산
    static int calculationInfix(String formula){
        Stack<Integer> digits = new Stack<>();
        Stack<Character> operators = new Stack<>();

        for(char c : formula.toCharArray()){
            if(Character.isDigit(c)) digits.push(c-'0');
            else{ // 연산자일 경우
                // 연산자 stack 이 비어있지 않아야.
                // 연산자 stack 안에, 현재 연산자보다 우선순위가 높은 연산자가 존재한다면 계산을 먼저 해준다.
                while(!operators.isEmpty() && priority(operators.peek()) >= priority(c)){
                    compute(digits, operators.pop());
                }
                operators.push(c);
            }
        }

        while(!operators.isEmpty()){
            char currentOperator = operators.pop();
            compute(digits, currentOperator);
        }

        return digits.pop();
    }

    static void compute(Stack<Integer> digits, char operator){
        int a = digits.pop();
        int b = digits.pop();

        if(operator=='+') digits.push(a+b);
        else if(operator=='*') digits.push(a*b);
    }

    static int priority(char operator){
        if(operator=='*') return 2;
        if(operator=='+') return 1;
        return 0;
    }
}
