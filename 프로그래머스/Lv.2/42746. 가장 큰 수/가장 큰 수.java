import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";

        String[] s = new String[numbers.length];
        for(int i=0; i<s.length; i++){
            s[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(s, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (String a : s) {
            answer += a;
        }
        if(answer.charAt(0)=='0') return "0";
        return answer;
    }
}