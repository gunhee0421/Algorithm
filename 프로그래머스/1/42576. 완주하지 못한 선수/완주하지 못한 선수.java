import java.util.HashMap;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> p1 = new HashMap<>();
        String answer = "";
        for (int i = 0; i < participant.length; i++) {
            int n = 0;
            if (p1.containsKey(participant[i])) {
                n = p1.get(participant[i]);
                p1.replace(participant[i], n + 1);
            }
            else{
                p1.put(participant[i], 1);
            }
        }
        for (int i = 0; i < completion.length; i++) {
            int n = p1.get(completion[i]);
            p1.replace(completion[i], n - 1);
        }
        for (int i = 0; i < participant.length; i++) {
            if (p1.get(participant[i]) != 0) {
                answer = participant[i];
            }
        }
        return answer;
    }
}