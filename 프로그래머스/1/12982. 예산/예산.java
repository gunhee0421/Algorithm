import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d);
        int sum = 0;
        for (int i = 0; i < d.length; i++) {
            if (sum+d[i] > budget) {
                return answer;
            }
            sum += d[i];
            answer++;
        }

        return answer;
    }
}