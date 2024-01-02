class Solution {
    public String solution(String s) {
        String answer = "";
        if (s.length() % 2 == 1) {
            char c = s.charAt(s.length() / 2);
            answer += c;
        } else{
            int n = s.length() / 2;
            answer += s.substring(n - 1, n + 1);
        }

        return answer;
    }
}