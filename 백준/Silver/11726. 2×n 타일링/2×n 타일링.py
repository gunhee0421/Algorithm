import sys
sys.setrecursionlimit(10**6)
input = sys.stdin.readline

T = int(input())

dp = [0 for _ in range(1001)]
dp[1] = 1
dp[2] = 2
def solution(n):
    if dp[n] != 0 :
        return dp[n]
    else:
        dp[n] = solution(n-1)+solution(n-2)
        return dp[n]
if T==0:
    print(0)
else:
    print(solution(T)%10007)