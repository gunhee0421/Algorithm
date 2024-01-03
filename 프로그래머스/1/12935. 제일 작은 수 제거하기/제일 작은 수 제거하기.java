import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == min) {}
            else{
                list.add(arr[i]);
            }
        }
        if(!list.isEmpty()){
            answer = new int[list.size()];
            for (int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            return answer;
        } else{
            return new int[]{-1};
        }
    }
}