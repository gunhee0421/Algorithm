import java.util.*;

class Solution {
    public Queue<Integer> solution(int[] progresses, int[] speeds) {
        ArrayList<Integer> timerList = new ArrayList<>();
        Queue<Integer> answer = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int time = (int) Math.ceil((double) ((100 - progresses[i]) / (float)speeds[i]));
            timerList.add(time);
        }
        // 7 2 9               max값이 변경될때 값을 큐에 넣어준다
        // 5 10 1 1 20 1
        int i = 0, max = timerList.get(i), count=0;
        while (!timerList.isEmpty()) {
            if (timerList.get(i) > max) {
                max = timerList.get(i);
                answer.add(count);
                timerList.remove(i);
                count = 1;
            } else {
                count++;
                timerList.remove(i);
            }
        }
        answer.add(count);

        return answer;
    }
}