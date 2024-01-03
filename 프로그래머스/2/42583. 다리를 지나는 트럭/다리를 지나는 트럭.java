import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> list = new LinkedList<>();
        for (int i : truck_weights) {
            queue.add(i);
        }
        int sum = 0;
        while (!queue.isEmpty()) {
            answer++;
            if (list.size() == bridge_length) {
                sum -= list.peek();
                list.poll();
            }
            if (queue.peek() <= weight) {
                sum += queue.peek();
                if (sum <= weight) {
                    list.add(queue.poll());
                } else{
                    sum -= queue.peek();
                    list.add(0);
                }
            }
        }
        answer += bridge_length;
        return answer;
    }
}