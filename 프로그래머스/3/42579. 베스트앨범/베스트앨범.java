import java.util.*;

class Solution {
    public ArrayList<Integer> solution(String[] genres, int[] plays) {
        ArrayList<Integer> answer = new ArrayList<>();

        HashMap<String, HashMap<Integer, Integer>> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < genres.length; i++) {
            if(map.containsKey(genres[i])){
                HashMap<Integer, Integer> map2 = map.get(genres[i]);
                map2.put(i, plays[i]);
                map.put(genres[i], map2);
            } else{
                HashMap<Integer, Integer> map2 = new HashMap<>();
                map2.put(i, plays[i]);
                map.put(genres[i], map2);
                list.add(genres[i]);
            }
        }
        while (!list.isEmpty()) {
            int total = 0, index=0;
            for (int i = 0; i < list.size(); i++) {
                int sum = 0;
                for (Integer j : map.get(list.get(i)).keySet()) {
                    sum += map.get(list.get(i)).get(j);
                }
                if (total < sum) {
                    total = sum;
                    index = i;
                }
            }
            int k = 2;
            while (k > 0) {
                if (map.get(list.get(index)).isEmpty()) {
                    break;
                }
                int max = 0, j = 0;

                for (Integer i : map.get(list.get(index)).keySet()) {
                    if (max < map.get(list.get(index)).get(i)) {
                        max = map.get(list.get(index)).get(i);
                        j = i;
                    }
                }
                answer.add(j);
                map.get(list.get(index)).remove(j);
                k--;
            }
            list.remove(index);
        }
        return answer;
    }
}