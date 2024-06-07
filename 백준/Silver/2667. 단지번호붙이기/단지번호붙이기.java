import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main{
    static char[][] grah;
    static boolean[][] visited;
    static ArrayList<Integer> list = new ArrayList<>();
    static int count, n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grah = new char[n][n];
        visited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            grah[i] = s.toCharArray();
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grah[i][j] == '1' && !visited[i][j]) {
                    count = 0;
                    dfs(i, j);
                    list.add(count);
                }
            }
        }
        System.out.println(list.size());
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        count++;
        if (x + 1 < n && grah[x + 1][y] == '1' && !visited[x + 1][y]) {
            dfs(x + 1, y);
        }
        if (y + 1 < n && grah[x][y + 1] == '1' && !visited[x][y + 1]) {
            dfs(x, y + 1);
        }
        if (x - 1 >= 0 && grah[x - 1][y] == '1' && !visited[x - 1][y]) {
            dfs(x - 1, y);
        }
        if (y - 1 >= 0 && grah[x][y - 1] == '1' && !visited[x][y - 1]) {
            dfs(x, y - 1);
        }
    }
}