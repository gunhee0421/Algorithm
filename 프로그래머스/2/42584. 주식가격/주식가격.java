import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();

        for (int i : prices) {
            queue.add(i);
            list.add(i);
        }
        int j=0, count = 0, min = 0;
        while (!queue.isEmpty()) {
            min = queue.peek();
            for (int i = j; i < list.size(); i++) {
                count++;
                if (list.get(i) < min) {
                    queue.poll();
                    answer[j] = count-1;
                    j++;
                    count = 0;
                    break;
                } else if (i == list.size() - 1) {
                    queue.poll();
                    answer[j] = count-1;
                    count = 0;
                    j++;
                }
            }
        }


        return answer;
    }
}