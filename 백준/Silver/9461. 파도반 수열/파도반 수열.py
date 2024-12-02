import sys
input = sys.stdin.readline

N = int(input())
dp = [0] * 101

dp[1] = dp[2] = dp[3] = 1
dp[4] = dp[5] = 2
dp[6] = 3
dp[7] = 4
dp[8] = 5
dp[9] = 7
dp[10] = 9

def find(n):
    if dp[n] > 0:
        return dp[n]
    else:
        dp[n] = find(n-1) + find(n-5)
        return dp[n]

for i in range(N):
    n = int(input())
    print(find(n))

