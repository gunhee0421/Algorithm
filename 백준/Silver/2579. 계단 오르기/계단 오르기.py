import sys
input = sys.stdin.readline

N = int(input())
arr = [int(input()) for _ in range(N)]
dp = [0] * (N+1)

def max_score():
    if N==1:
        return arr[0]
    elif N==2:
        return arr[0] + arr[1]

    dp[1] = arr[0]
    dp[2] = arr[0] + arr[1]

    for i in range(3, N+1):
        dp[i] = max(dp[i-2] + arr[i-1], dp[i-3]+arr[i-2]+arr[i-1])

    return dp[N]

print(max_score())