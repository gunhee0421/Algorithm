import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] grah;
    static boolean[][] visited;
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grah = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grah[i][j] = s.charAt(j)-'0';
            }
            Arrays.fill(visited[i], false);
        }
        
//        dfs(0, 0, 1);
        bfs(0, 0);
        System.out.println(grah[n-1][m-1]);
    }

    public static void bfs(int x, int y) {
        int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            for (int i = 0; i < pos.length; i++) {
                x = nowx + pos[i][0];
                y = nowy + pos[i][1];

                if (x > -1 && x < n && y > -1 && y < m && !visited[x][y] && grah[x][y] == 1) {
                    q.add(new int[]{x, y});
                    grah[x][y] = grah[nowx][nowy] + 1;
                    visited[x][y] = true;
                }
            }
        }
    }
}
