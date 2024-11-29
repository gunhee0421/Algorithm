import sys
input = sys.stdin.readline

N, K= map(int, input().split())
arr = [int(input()) for _ in range(N)]

arr.sort(reverse=True)

res = 0

for i in arr:
    if i <= K:
        res += K // i
        K = K % i

print(res)