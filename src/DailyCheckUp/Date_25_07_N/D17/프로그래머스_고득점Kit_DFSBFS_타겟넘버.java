package DailyCheckUp.Date_25_07_N.D17;

public class 프로그래머스_고득점Kit_DFSBFS_타겟넘버 {
    static int ans, res=0;
    static int[] nums;

    public static void main(String[] args) {
        int[] numbers = new int[100];
        int target = 100;

//  DFS를 이용한 풀이
        nums = numbers;
        ans = target;

        dfs(0, 0);

        System.out.println(res);

//  Queue를 이용한 풀이
//         Queue<Integer> q = new LinkedList<>();
//         q.offer(numbers[0]);
//         q.offer(-1*numbers[0]);

//         for(int i=1; i<numbers.length; i++){
//             int value = numbers[i];
//             int qSize = q.size();

//             for(int n=0; n<qSize; n++){
//                 int qValue = q.poll();

//                 q.offer(qValue - value);
//                 q.offer(qValue + value);
//             }
//         }

//         int res = 0;
//         while(!q.isEmpty()){
//             if(q.poll()==target) res++;
//         }

//         return res;
    }

    static void dfs(int idx, int value){
        if(idx >= nums.length){
            if(value == ans) res++;
            return;
        }

        int nextIdx = idx + 1;
        dfs(nextIdx, value + nums[idx]);
        dfs(nextIdx, value - nums[idx]);
    }
}
