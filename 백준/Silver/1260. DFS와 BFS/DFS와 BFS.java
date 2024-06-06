import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{

    static int[][] grah;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();
    static int N, M ;

    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        grah = new int[N + 1][N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grah[a][b] = grah[b][a] = 1;
        }
        dfs(start);

        System.out.println(sb);
        sb.setLength(0);
        Arrays.fill(visited, false);

        bfs(start);
        System.out.println(sb);
    }

    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start+" ");

        for (int i = 0; i < N + 1; i++) {
            if (grah[start][i] == 1 && !visited[i]) {
                dfs(i);
            }
        }
    }

    public static void bfs(int start) {
        q.offer(start);
        visited[start] = true;
        sb.append(start + " ");

        while (!q.isEmpty()) {
            int index = q.poll();
            for (int i = 0; i < N + 1; i++) {
                if (grah[index][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                    sb.append(i + " ");
                }
            }
        }

    }
}