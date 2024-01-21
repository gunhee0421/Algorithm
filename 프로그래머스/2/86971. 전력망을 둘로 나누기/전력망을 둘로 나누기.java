import java.util.*;
class Solution {
    int[][] arr;
    public int solution(int n, int[][] wires) {
        int answer = n;

        arr = new int[n + 1][n + 1];
        for (int i = 0; i < wires.length; i++) {
            arr[wires[i][0]][wires[i][1]] = 1;
            arr[wires[i][1]][wires[i][0]] = 1;
        }

        for (int i = 0; i < wires.length; i++) {
            int a = wires[i][0];
            int b = wires[i][1];

            arr[a][b] = 0;
            arr[b][a] = 0;

            answer = Math.min(answer, dfs(n, a));
            
            arr[a][b]=1;
            arr[b][a]=1;

        }
        return answer;
    }

    public int dfs(int n, int start) {
        boolean[] visited = new boolean[n + 1];
        int count = 1;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        while (!q.isEmpty()) {
            int now = q.poll();
            visited[now] = true;

            for (int i = 0; i < n + 1; i++) {
                if(visited[i]) continue;
                if (arr[now][i] == 1) {
                    q.offer(i);
                    count++;
                }
            }
        }
        return (int)Math.abs(n - 2 * count);
    }
}