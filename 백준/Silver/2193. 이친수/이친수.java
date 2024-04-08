import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    static long[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        if (n < 2) {
            dp = new long[3];
        }
        else{
            dp = new long[n + 1];
        }
        dp[0] = dp[1] = dp[2] = 1;

        System.out.println(dynamic(n));
    }

    static long dynamic(int n) {
        if (dp[n] == 0) {
            dp[n] = dynamic(n - 1) + dynamic(n - 2);
        }
        return dp[n];
    }
}