import java.util.*;

class Solution {
    List<Integer> list = new ArrayList<>();
    boolean[] visited = new boolean[7];
    public int solution(String numbers) {
        int answer = 0;
        
        for(int i=0; i<numbers.length(); i++){
            dfs(numbers, "", i+1);
        }
        for(int i=0; i<list.size(); i++){
            if(prime(list.get(i))){
                answer++;
            }
        }
        
        return answer;
    }
    public void dfs(String numbers, String str, int n){
        if(str.length()==n){
            int num=Integer.parseInt(str);
            if(!list.contains(num)){
                list.add(num);
            }
        }
        for(int i=0; i<numbers.length(); i++){
            if(!visited[i]){
                visited[i]=true;
                str+=numbers.charAt(i);
                dfs(numbers, str, n);
                visited[i]=false;
                str=str.substring(0, str.length()-1);
            }
        }
    }
    
    public boolean prime(int n){
        if(n<2) return false;
        for(int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}