import java.util.*;

class Document{
    int idx;
    int priority;
    public Document(int idx, int priority){
        this.idx = idx;
        this.priority = priority;
    }
}
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 1;
        LinkedList<Document> list = new LinkedList<>();
   
        for(int i=0; i<priorities.length; i++){
            list.add(new Document(i, priorities[i]));
        }
        
        Document first = null;
        
        while(list.size()>0){
            first = list.getFirst();
            for(int j=0; j<list.size(); j++){
                if(first.priority < list.get(j).priority){
                    list.removeFirst();
                    list.addLast(first);
                    break;
                }
                if(j == list.size()-1 ){
                    if(first.idx == location) return answer;
                    list.removeFirst();
                    answer++;
                }
            }
        }
  
        return answer;
    }
}