import sys
from collections import defaultdict

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

left = 0
fCount = defaultdict(int)
maxNum = 0

for right in range(N):
    fCount[arr[right]] += 1

    while len(fCount) > 2:
        fCount[arr[left]] -= 1
        if fCount[arr[left]] == 0:
            del fCount[arr[left]]
        left += 1

    maxNum = max(maxNum, right - left + 1)

print(maxNum)