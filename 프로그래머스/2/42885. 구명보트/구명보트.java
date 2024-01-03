import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // 50 50 70 80
    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : people) {
            list.add(i);
        }
        while (!list.isEmpty()) {
            int i = 0, j = list.size() - 1;
            if (i == j) {
                list.remove(i);
                answer++;
            } else {
                int sum = list.get(i) + list.get(j);
                if (sum <= limit) {
                    list.remove(j);
                    list.remove(i);
                    answer++;
                } else {
                    list.remove(j);
                    answer++;
                }
            }
        }
        return answer;
    }
}