import java.util.*;

class Solution {
    public static int count = 0;
    public int solution(String begin, String target, String[] words) {
        int answer = 0;

        ArrayList<String> list = new ArrayList<>();
        for(String s : words) list.add(s);

        dfs(begin, target, list);

        answer = count;

        return answer;
    }

    public static void dfs(String begin, String target, ArrayList<String> arrayList) {
        boolean possible = false;
        if (!arrayList.contains(target)) {
            count = 0;
            return;
        }
        if (begin.equals(target)) {
            return;
        }
        int c = 0;
        for (int i = 0; i < begin.length(); i++) {
            if (begin.charAt(i) == target.charAt(i)) {
                c++;
            }
            if (c == target.length() - 1) {
                possible = true;
            }
        }

        for (int i = 0; i < arrayList.size(); i++) {
            int k = 0;
            for (int j = 0; j < begin.length(); j++) {
                if (possible) {
                    count++;
                    return;
                }
                if (begin.charAt(j) == arrayList.get(i).charAt(j)) {
                    k++;
                }
            }
            if (k == begin.length() - 1) {
                count++;
                String s = arrayList.remove(i);
                dfs(s, target, arrayList);
            }
        }
    }
}