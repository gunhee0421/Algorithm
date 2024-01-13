import java.util.*;

class Solution {
    public List<Integer> solution(int[] array, int[][] commands) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answer=new ArrayList<>();
        
        int count=0;
        while(answer.size()!=commands.length){
            for(int i=commands[count][0]; i<=commands[count][1]; i++){
                list.add(array[i-1]);
            }
            Collections.sort(list);
            answer.add(list.get(commands[count][2]-1));
            count++;
            list.clear();
        }
        
        return answer;
    }
}