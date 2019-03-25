import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int numLost = 0;
        
        int[] all = new int[n];
        Arrays.fill(all, 1);
        
        for(int i=0; i<reserve.length; i++){
            all[reserve[i]-1] += 1;
        }
        
        for(int j=0; j<lost.length; j++){
            all[lost[j]-1] -= 1;
            if(all[lost[j]-1] == 0)
                numLost++;
        }
        
        for(int k=0; k<all.length; k++){
            if(all[k] == 0){
                if(k != 0 && all[k-1] == 2){
                    all[k] += 1;
                    all[k-1] -= 1;
                    numLost -= 1;
                }else if(k != all.length-1 && all[k+1] == 2){
                    all[k] += 1;
                    all[k+1] -= 1;
                    numLost -=1;
                }
            }
        }
        answer = n - numLost;
        return answer;
    }
}