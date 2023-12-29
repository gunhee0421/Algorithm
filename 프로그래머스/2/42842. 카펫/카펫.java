class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int total = brown + yellow;

        for (int i = 3; i <=total; i++) {
            if (total % i == 0) {
                int h = total / i;
                int w = i;
                if ((w - 2) * (h - 2) == yellow) {
                    answer[0] = w;
                    answer[1] = h;
                }
            }
        }
        return answer;
    }
}