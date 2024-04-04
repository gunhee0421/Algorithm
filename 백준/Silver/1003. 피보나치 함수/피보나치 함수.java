import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static Integer[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine());

            if (n < 1) {
                dp = new Integer[2][2];
            } else {
                dp = new Integer[n+1][2];
            }

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            sb.append(dynamicZero(n)+" "+dynamicOne(n)+"\n");
        }
        System.out.println(sb);
    }

    static int dynamicZero(int n) {
        if (dp[n][0] == null) {
            dp[n][0] = dynamicZero(n - 1) + dynamicZero(n - 2);
        }
        return dp[n][0];
    }

    static int dynamicOne(int n) {
        if (dp[n][1] == null) {
            dp[n][1] = dynamicOne(n - 1) + dynamicOne(n - 2);
        }
        return dp[n][1];
    }
}