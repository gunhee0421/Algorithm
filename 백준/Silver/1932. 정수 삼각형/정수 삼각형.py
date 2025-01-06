import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

dp = [[0] * N for _ in range(N)]

dp[0][0] = arr[0][0]

for i in range(1, N):
    length = len(arr[i])
    for j in range(length):
        if j == 0:
            dp[i][j] = dp[i-1][j] + arr[i][j]
        elif j == length:
            dp[i][j] = dp[i-1][j-1] + arr[i][j]
        else:
            dp[i][j] = max(dp[i-1][j] + arr[i][j], dp[i-1][j-1] + arr[i][j])

print(max(dp[N-1]))