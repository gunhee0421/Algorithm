import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i : scoville) {
            priorityQueue.offer(i);
        }
        while(priorityQueue.peek()<K){
            if (priorityQueue.size() == 1) {
                return -1;
            }
            int n = priorityQueue.remove();
            int m = priorityQueue.remove();
            int sc = n + m * 2;
            priorityQueue.offer(sc);
            answer++;
        }
        return answer;
    }
}