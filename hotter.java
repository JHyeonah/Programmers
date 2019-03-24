import java.util.*;
import java.util.Arrays;
class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        int s1, s2;
        int times = 0, temp = 0;
        PriorityQueue<Integer> sq = new PriorityQueue<Integer>(scoville.length);

        for(int i=0; i<scoville.length; i++){
            sq.offer(scoville[i]);
        }
        
        while(sq.size() > 1){
            if(sq.peek() >= K){
                answer = times;
                break;
            }
            s1 = sq.poll();
            s2 = sq.poll();
            temp = s1 + s2*2;
            sq.offer(temp);
            times++;
        }
        
        if(sq.poll() >= K)
            answer = times;
        
        return answer;
    }
}