import sys

input = sys.stdin.readline

N, M = map(int, input().split())
nums = list(map(int, input().split()))
res = []

def backtracking(cur, used):
    if len(cur) == M:
        res.append(tuple(cur))
        return

    prev = None
    for i in range(N):
        if not used[i] and nums[i] != prev:
            used[i] = True
            backtracking(cur + [nums[i]], used)
            used[i] = False
            prev = nums[i]

backtracking([], [False] * N)

for i in sorted(set(res)):
    print(*i)