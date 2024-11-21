import sys
input = sys.stdin.readline

T = int(input())

list = sorted(map(int, input().split()))

dp = [0] * (T+1)

for i in range(len(list)):
    dp[i+1] = dp[i] + int(list[i])

print(sum(dp))