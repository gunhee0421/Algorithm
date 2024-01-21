import java.util.*;

class Solution {
    boolean[] visited;
    String[] answer;
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        Arrays.sort(tickets, Comparator.comparing((String[] ticket) -> ticket[1]).reversed());

        dfs("ICN", tickets, 0, "");


        return answer;
    }
    public void dfs(String begin, String[][] tickets, int used, String str){
        if(used==visited.length) {
            str += begin;
            answer = str.split(" ");
            return;
        }

        for(int i=0; i<tickets.length; i++){
            if(visited[i]) continue;
            String s = tickets[i][0];
            String target = tickets[i][1];

            if(s.equals(begin)){
                visited[i] = true;
                String string = str + begin + " ";
                dfs(target, tickets, used+1, string);
                visited[i] = false;
            }
        }
    }
}