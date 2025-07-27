package DailyCheckUp.Date_25_07_N.D27;

import java.util.*;

public class 프로그래머스_고득점Kit_DFSBFS_단어변환 {
    public int solution(String begin, String target, String[] words){
        List<String> wordsList = new ArrayList<>();
        for(String w : words){
            wordsList.add(w);
        }

        return bfs(begin, target, words);
    }

    public int bfs(String begin, String target, String[] words){
        Map<String, Boolean> visited = new HashMap<>();
        for(String word : words){
            visited.put(word, false);
        }
        visited.put(begin, true);

        Queue<Word> q = new LinkedList<>();
        q.offer(new Word(begin, 0));

        while(!q.isEmpty()){
            Word curr = q.poll();

            if(curr.word.equals(target)){
                return curr.cnt;
            }

            List<String> validWords = getValidWords(curr.word, words, visited);
            for(String word : validWords){
                visited.replace(word, true);
                q.offer(new Word(word, curr.cnt+1));
            }
        }

        return 0;
    }

    public ArrayList<String> getValidWords(String currStr, String[] words, Map<String, Boolean> visited){
        ArrayList<String> validWords = new ArrayList<>();

        for(String comp : words){
            if(currStr.equals(comp) || currStr.length() != comp.length() || visited.get(comp)) continue;

            int count = 0;
            for(int i=0; i<currStr.length(); i++){
                char v1 = currStr.charAt(i);
                char v2 = comp.charAt(i);

                if(v1!=v2) count++;
            }
            if(count==1) validWords.add(comp);
        }

        return validWords;
    }

    class Word{
        String word;
        int cnt;

        public Word(String word, int cnt){
            this.word = word;
            this.cnt = cnt;
        }
    }
}
