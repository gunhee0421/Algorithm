import sys
input = sys.stdin.readline

N, T = map(int, input().split())

arr = [list(map(int, input().split())) for _ in range(N)]
dp = [[0]*N for _ in range(N)]

for i in range(N):
    dp[i][0] = arr[i][0]
    for j in range(1, N):
        dp[i][j] = dp[i][j-1] + arr[i][j]

for t in range(T):
    x1, y1, x2, y2 = map(int, input().split())

    res = 0

    for j in range(x1-1, x2):
        if y1 == 1:
            res += dp[j][y2-1]
        else:
            res += dp[j][y2-1] - dp[j][y1-2]

    print(res)
