
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int count = 0;
    static int[][] arr;
    static boolean[][] visite;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arr = new int[n][m];
        visite=new boolean[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visite[i], false);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                count = 0;
                if (!visite[i][j] && arr[i][j] == 1) {
                    dfs(i, j);
                    pq.add(count);
                }
            }
        }
        System.out.println(pq.size());
        if (pq.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(pq.remove());
        }
    }
    public static void dfs(int x, int y) {
        visite[x][y] = true;
        count++;

        int[][] pos = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < pos.length; i++) {
            int nx = x + pos[i][0];
            int ny = y + pos[i][1];

            if (nx > -1 && nx < arr.length && ny > -1 && ny < arr[0].length && !visite[nx][ny] && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }
}