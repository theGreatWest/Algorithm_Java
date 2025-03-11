package DailyCheckUp.Date_25_02_N.D23;

import java.io.*;

public class 백준_14584_암호해독 {
    static String code;
    static int n;
    static String[] words;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        code = br.readLine();

        n = Integer.parseInt(br.readLine());
        int[] shift = null;
        words = new String[n];
        for(int i=0;i<n;i++){
            String word = br.readLine();

            words[i] = word;

            int[] result = findRule(word);

            if(result!=null) {
                shift = result;
                break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(char c : code.toCharArray()){
            int s = Math.min(shift[0], shift[1]);
            int b = Math.max(shift[0], shift[1]);

            int tmp = c + s;

            if(tmp < 123) sb.append((char)(tmp));
            else sb.append((char)(c - b));
        }
        System.out.write(sb.toString().getBytes());
    }

    static int[] findRule(String word){
        int codeLen = code.length();
        int wordLen = word.length();

        for(int i=0;i<=codeLen - wordLen;i++){
            String subStr = code.substring(i, i+wordLen);

            int shift1 = Math.abs(subStr.charAt(0) - word.charAt(0));
            int shift2 = 26 - shift1;
            int cnt = 1;
            for(int t=1;t<wordLen;t++){
//                int tmp = Math.abs(subStr.charAt(t) - word.charAt(t));
                int tmp = getShift(subStr.charAt(t), word.charAt(t));

                if(tmp==shift1 || tmp==shift2) cnt++;
            }

            if(cnt == wordLen) return new int[]{shift1, shift2};
        }

        return null;
    }

    // ✅ 알파벳 순환을 고려한 getShift() 함수 추가
    // z -> a 순서로 순환하는 특징을 고려한 식
    // 이동된 아스키코드 값을 반환
    static int getShift(char a, char b) {
        return (b - a + 26) % 26;
    }

// chd 25 칸 오른쪽으로 전진 가능
// 원본 code 를 오른쪽으로 한 칸씩 shift 시킨 후, 단어 리스트의 단어 중 하나 이상이 원본 문장에 포함되는지 확인
// 포함하는 문장이 정답 문장 이므로 반목문 탈출 후 출력
    static void otherSolution(){
        // 이동
        int move = 0;
        boolean result = true;
        StringBuilder sb = new StringBuilder();

        while(move<=25 && result) {
            // 1칸씩 이동
            for(int index=0; index<code.length(); index++) {
                int value = code.charAt(index)-'a'+1;
                if(value>25) value -= 26;
                sb.setCharAt(index,(char)(value+'a'));
            }

            // 이동된 문자열 저장
            code = sb.toString();

            // 문자열 속 단어 확인
            for(int index=0; index<n; index++) {
                if(code.contains(words[index])) {
                    result = false;
                    break;
                }
            }

            // 이동 수 증가
            move++;
        }
    }
}
