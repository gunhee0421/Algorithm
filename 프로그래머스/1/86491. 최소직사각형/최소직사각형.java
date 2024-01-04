class Solution {
    public int solution(int[][] sizes) {
        int answer = 0;

        int w=0, h=0;
        for (int i = 0; i < sizes.length; i++) {
            int temp = Math.max(sizes[i][0], sizes[i][1]);
            int temp2 = Math.min(sizes[i][0], sizes[i][1]);
            sizes[i][0] = temp;
            sizes[i][1] = temp2;
        }
        for (int i = 0; i < sizes.length; i++) {
            w = Math.max(w, sizes[i][0]);
            h = Math.max(h, sizes[i][1]);
        }
        answer = w * h;

        return answer;
    }
}