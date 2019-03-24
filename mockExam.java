import java.lang.Math;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        
        ArrayList <Integer> arr = new ArrayList<>();
        int[][] pattern = {
            {1,2,3,4,5},
            {2,1,2,3,2,4,2,5},
            {3,3,1,1,2,2,4,4,5,5}
        };
        
        int[] hit = new int[3];
        
        for(int i = 0; i<answers.length; i++){
            if(pattern[0][i%5] == answers[i]){
                hit[0]++;
            }
            if(pattern[1][i%8] == answers[i]){
                hit[1]++;
            }
            if(pattern[2][i%10] == answers[i]){
                hit[2]++;
            }
        }
        
        int max = Math.max(hit[0],Math.max(hit[1],hit[2]));
        
        for(int j=0; j<hit.length; j++){
            if(max == hit[j])
                arr.add(j+1);
        }
        
        int[] answer = new int[arr.size()];
        
        for(int k=0; k<answer.length; k++){
            answer[k] = arr.get(k);
        }
        
        return answer;
    }
}