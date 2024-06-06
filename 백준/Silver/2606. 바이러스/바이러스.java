import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

    static int[][] grah;
    static boolean[] visited;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int node = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());
        int n = Integer.parseInt(new StringTokenizer(br.readLine()).nextToken());

        grah = new int[node + 1][node + 1];
        visited = new boolean[node + 1];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            grah[a][b] = grah[b][a] = 1;
        }
        dfs(1, node);

        System.out.println(count - 1);
    }

    public static void dfs(int start, int node) {
        visited[start] = true;
        count++;

        for (int i = 0; i < node + 1; i++) {
            if (grah[start][i] == 1 && !visited[i]) {
                dfs(i, node);
            }
        }
    }
}