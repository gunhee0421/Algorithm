import sys
input = sys.stdin.readline

N = int(input())

arr = list(map(int, input().split()))

maxDp = arr
minDp = arr

for _ in range(N-1):
    arr = list(map(int, input().split()))
    maxDp = [arr[0] + max(maxDp[0], maxDp[1]), arr[1] + max(maxDp), arr[2]+max(maxDp[1], maxDp[2])]
    minDp = [arr[0] + min(minDp[0], minDp[1]), arr[1] + min(minDp), arr[2]+min(minDp[1], minDp[2])]

print(max(maxDp), min(minDp))