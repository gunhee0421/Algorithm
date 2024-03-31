import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] grah;
    static boolean[][] visited;
    static PriorityQueue<Integer> result = new PriorityQueue<>(Collections.reverseOrder());
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grah = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grah[i][j] = Integer.parseInt(st.nextToken());
            }
            Arrays.fill(visited[i], false);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && grah[i][j]==1) {
                    bfs(i, j);
                    result.add(count);
                }
            }
        }
        System.out.println(result.size());
        if (result.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(result.poll());
        }
    }

    public static void bfs(int x, int y) {
        count=1;
        int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];

            for (int i = 0; i < pos.length; i++) {
                x = nowx + pos[i][0];
                y = nowy + pos[i][1];
                if (x >= 0 && x < grah.length && y >= 0 && y < grah[0].length && grah[x][y] == 1 && !visited[x][y]) {
                    count++;
                    q.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }

        }

    }
}