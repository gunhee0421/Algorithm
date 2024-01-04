class Solution {
    int count = 1;
    public int solution(int n, int[][] computers) {
        int answer = n;

        boolean[] visited = new boolean[computers.length];

        for (int i = 0; i < computers.length; i++) {
            dfs(computers, visited, i);
        }

        if (count == n) {
            answer = 1;
        } else if (count < n) {
            answer = n - count + 1;
        }

        return answer;
    }

    public void dfs( int[][] graph, boolean[] visited, int index) {
        visited[index] = true;
        for (int i = 0; i < graph[index].length; i++) {
            if (graph[index][i] == 1 && !visited[i]) {
                dfs(graph, visited, i);
                count++;
            }
        }
    }
}