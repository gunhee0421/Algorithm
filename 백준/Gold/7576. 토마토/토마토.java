import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int[][] grah;
    static boolean[][] visited;
    static int count;
    static Queue<int[]> q = new LinkedList<>();


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        grah = new int[m][n];
        visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grah[i][j] = Integer.parseInt(st.nextToken());
                if (grah[i][j] == 1) {
                    q.offer(new int[]{i, j, 0});
                }
            }
            Arrays.fill(visited[i], false);
        }
        bfs();
        if (checkgraph()) {
            System.out.println(count);
        } else {
            System.out.println(-1);
        }
    }

    public static void bfs() {
        count = 0;
        int[][] pos = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int nowx = now[0];
            int nowy = now[1];
            visited[nowx][nowy] = true;
            for (int i = 0; i < pos.length; i++) {
                int x = nowx + pos[i][0];
                int y = nowy + pos[i][1];
                count = now[2];
                if (x >= 0 && x < grah.length && y >= 0 && y < grah[0].length && grah[x][y] == 0 && !visited[x][y]) {
                    count++;
                    q.offer(new int[]{x, y, count});
                    grah[x][y] = 1;
                    visited[x][y] = true;
                }
            }
        }
    }
    public static boolean checkgraph() {
        for (int i = 0; i < grah.length; i++) {
            for (int j = 0; j < grah[0].length; j++) {
                if (grah[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
}