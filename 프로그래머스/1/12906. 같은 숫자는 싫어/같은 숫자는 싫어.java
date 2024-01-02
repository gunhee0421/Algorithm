import java.util.*;

class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i : arr) {
            if(queue.isEmpty()){
                queue.add(i);
            } else{
                if (!queue.contains(i)) {
                    queue.add(i);
                    arrayList.add(queue.poll());
                }
            }
        }
        if (!queue.isEmpty()) {
            arrayList.add(queue.poll());
        }
        int[] answer = new int[arrayList.size()];
        for (int i =0; i<answer.length; i++) {
            answer[i] = arrayList.get(i);
        }
        return answer;
    }
}