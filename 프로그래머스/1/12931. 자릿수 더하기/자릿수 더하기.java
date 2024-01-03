public class Solution {
    public int solution(int n) {
        int answer = 0, sum=0;
        String str=Integer.toString(n);
        for(int i=0; i<str.length(); i++){
            String str1=str.substring(i, i+1);
            sum+=Integer.parseInt(str1);
        }
        answer=sum;
        return answer;
    }
}