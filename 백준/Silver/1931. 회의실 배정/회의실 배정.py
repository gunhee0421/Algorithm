import sys

input = sys.stdin.readline

N = int(input())

arr = []
for _ in range(N):
    a, b = map(int, input().split())
    arr.append([a, b])

arr.sort(key=lambda x: (x[1], x[0]))

count = 0
end_time = 0

for start, end in arr:
    if start >= end_time:
        count += 1
        end_time = end

print(count)