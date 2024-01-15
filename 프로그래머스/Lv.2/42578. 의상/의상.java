import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        for (int i = 0; i < clothes.length; i++) {
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], 1);
            }else{
                int value = map.get(clothes[i][1])+1;
                map.replace(clothes[i][1], value);
            }
        }
        int answer = 0;
        int value = 1;
        for (String s : map.keySet()) {
            value *= map.get(s)+1;
        }
        answer=value-1;
        return answer;
    }
}