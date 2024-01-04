class Solution {
    int answer = 0;
    public int solution(int[] numbers, int target) {

        dfs(numbers, target, 0, 0);

        return answer;
    }

    public void dfs(int[] number, int target, int deep, int sum) {
        if (deep == number.length) {
            if(target==sum) answer++;
        } else{
            dfs(number, target, deep + 1, sum + number[deep]);
            dfs(number, target, deep + 1, sum - number[deep]);
        }
    }
}