import sys

input = sys.stdin.readline

N, M = map(int, input().split())
arr = list(set(map(int, input().split())))
arr.sort()

def backtracking(depth, index, path):
    if depth == M:
        print(*path)
        return

    for i in range(index, len(arr)):
        backtracking(depth + 1, i, path + [arr[i]])

backtracking(0, 0, [])