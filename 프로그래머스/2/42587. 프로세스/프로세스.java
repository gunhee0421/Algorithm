import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> name = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> namelist = new ArrayList<>();

        int max=0;
        for (int i : priorities) {
            queue.add(i);
            max = Math.max(max, i);
        }
        for (int i = 0; i < priorities.length; i++) {
            name.add(i);
        }
        while (!queue.isEmpty()) {
            if (max==queue.peek()) {
                list.add(queue.poll());
                namelist.add(name.poll());
                max = 0;
                for (int i : queue) {
                    max = Math.max(max, i);
                }
            }else {
                queue.add(queue.poll());
                name.add(name.poll());
            }
        }
        int count = 1;
        for (int i = 0; i < namelist.size(); i++) {
            if (location == namelist.get(i)) {
                answer=count;
                break;
            }
            count++;
        }

        return answer;
    }
}