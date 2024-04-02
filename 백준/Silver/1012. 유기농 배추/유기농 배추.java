import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
    static int[][] grah;
    static boolean[][] visited;
    static int m, n, k, count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            grah = new int[n][m];
            visited = new boolean[n][m];
            count = 0;

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int y = Integer.parseInt(st.nextToken());
                int x = Integer.parseInt(st.nextToken());
                grah[x][y] = 1;
            }
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < m; b++) {
                    if (grah[a][b] == 1 && !visited[a][b]) {
                        dfs(a, b);
                    }
                }
            }
            sb.append(count + "\n");
        }
        System.out.println(sb);
    }
    public static void dfs(int x, int y){
        count++;
        int[][] pos = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            for (int i = 0; i < 4; i++) {
                x = nowx + pos[i][0];
                y = nowy + pos[i][1];
                if (x >= 0 && x < n && y >= 0 && y < m && grah[x][y] == 1 && !visited[x][y]) {
                    q.offer(new int[]{x, y});
                    grah[nowx][nowy] = 0;
                    visited[x][y] = true;
                }
            }
            grah[nowx][nowy] = 0;
        }
    }
}