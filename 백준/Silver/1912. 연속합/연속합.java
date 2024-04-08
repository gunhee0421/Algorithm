import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{
    static Integer[] dp;
    static int[] nums;
    static int max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new Integer[n];
        nums = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        dp[0] = max = nums[0];
        dynamic(n-1);

        System.out.println(max);
    }

    static int dynamic(int n) {
        if (dp[n] == null) {
            dp[n] = Math.max(dynamic(n - 1) + nums[n], nums[n]);
            max = Math.max(max, dp[n]);
        }
        return dp[n];
    }
}