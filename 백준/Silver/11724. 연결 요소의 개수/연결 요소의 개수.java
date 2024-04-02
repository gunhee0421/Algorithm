import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] grah;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        grah = new int[n][n];
        visited = new boolean[n];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            grah[x-1][y-1] = grah[y-1][x-1] = 1;
        }
        int reslut=0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                reslut++;
            }
        }
        System.out.println(reslut);
    }

    public static void dfs(int index) {
        if (visited[index]) {
            return;
        } else {
            visited[index] = true;
            for (int i = 0; i < n; i++) {
                if (grah[index][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}