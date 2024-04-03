import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static Integer[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            int N = Integer.parseInt(br.readLine());
            if (N < 3) {
                dp = new Integer[4];
            } else{
                dp = new Integer[N + 2];
            }
            dp[0] = 0;
            dp[1] = 1;
            dp[2] = 2;
            dp[3] = 4;

            sb.append(dynamic(N) + "\n");
        }
        System.out.println(sb);
    }

    static int dynamic(int N) {
        if (dp[N] == null) {
            dp[N] = dynamic(N - 1) + dynamic(N - 2) + dynamic(N - 3);
        }
        return dp[N];
    }
}