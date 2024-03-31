import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int result;
    static int n, m;
    static int[] visited = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dfs();
        System.out.println(result);
    }

    public static void dfs() {
        Queue<Integer> q = new LinkedList<>();
        q.offer(n);
        visited[n] = 1;

        while (!q.isEmpty()) {
            int num = q.poll();
            int time = visited[num];

            if (num == m) {
                result = time-1;
                return;
            }
            if (num-1>=0 && visited[num-1]==0) {
                q.offer(num-1);
                visited[num-1] = time + 1;
            }
            if (num+1<=100000 && visited[num+1]==0) {
                q.offer(num+1);
                visited[num+1] = time + 1;
            }
            if (num*2<=100000 && visited[num*2]==0) {
                q.offer(num*2);
                visited[num*2] = time + 1;
            }

        }
    }
}