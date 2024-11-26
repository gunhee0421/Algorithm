import sys

input = sys.stdin.readline

N = int(input())
arr = list(map(int, input().split()))

sortedArray = sorted(set(arr))

rank = {value: index for index, value in enumerate(sortedArray)}

print(' '.join(str(rank[i]) for i in arr))
