class Solution {
    public String solution(String s) {
        String answer = "";
        String[] splitS = s.split(" ");

        int max=Integer.MIN_VALUE, min=Integer.MAX_VALUE;
        for (int i = 0; i < splitS.length; i++) {
            max = Math.max(max, Integer.parseInt(splitS[i]));
            min = Math.min(min, Integer.parseInt(splitS[i]));
        }
        answer = min + " " + max;
        return answer;
    }
}