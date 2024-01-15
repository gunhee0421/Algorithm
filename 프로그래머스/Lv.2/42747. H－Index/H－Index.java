import java.util.*;


class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Integer[] arr = new Integer[citations.length];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = citations[i];
        }
        // 6 5 3 1 0
        Arrays.sort(arr, Comparator.reverseOrder());

        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i + 1 <= arr[i]) {
                count = i + 1;
            } else{
                break;
            }
        }
        answer = count;

        return answer;
    }
}