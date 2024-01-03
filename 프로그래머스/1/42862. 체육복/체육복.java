import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (lost[i] == reserve[j] && (lost[i]>0 && reserve[j]>0)) {
                    lost[i] = -3;
                    reserve[j] = -3;
                    answer++;
                }
            }
        }

        for (int i = 0; i < lost.length; i++) {
            for (int j = 0; j < reserve.length; j++) {
                if (reserve[j] + 1 == lost[i] || reserve[j] - 1 == lost[i]) {
                    lost[i] = -3;
                    reserve[j] = -3;
                    answer++;
                }
            }
        }

        return answer;
    }
}