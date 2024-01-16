import java.util.*;

class Solution {
    public List<Integer> solution(int[] answers) {
        List<Integer> list = new ArrayList<>();
        List<Integer> answer= new ArrayList<>();
        
        int[][] player = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}
                         ,{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        
        int max=0, i=0;
        while(i<3){
            int j=0;
            int count=0;
            while(j<answers.length){
                if(answers[j]==player[i][j%player[i].length]){
                    count++;
                }
                j++;
            }
            list.add(count);
            max=Math.max(max, count);
            i++;
        }
        for(i=0; i<list.size(); i++){
            if(list.get(i)==max){
                answer.add(i+1);
            }
        }
        
        return answer;
    }
}