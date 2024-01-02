import java.util.ArrayList;
import java.util.Arrays;


class Solution {
    // 1 1 2 3 4
    public int[] solution(int[] numbers) {
        Arrays.sort(numbers);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                int sum = numbers[i] + numbers[j];
                if (!list.contains(sum)) {
                    list.add(sum);
                }
            }
        }
        int[] answer = new int[list.size()];
        for (int i=0; i<answer.length; i++) {
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
