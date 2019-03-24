class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, target, 0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int n){
        if(n == numbers.length){
            int sum = 0;
            for(int i=0; i<numbers.length; i++){
                sum += numbers[i];
            }
            if(sum == target)
                answer++;
        }else{
            numbers[n] *= 1;
            dfs(numbers, target, n+1);
            
            numbers[n] *= -1;
            dfs(numbers, target, n+1);
        }
    }
}