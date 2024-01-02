import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;

        int n = nums.length / 2;
        for (int i : nums) {
            set.add(i);
        }
        if (set.size() >= n) {
            answer = n;
        } else {
            answer = set.size();
        }

        return answer;
    }
}