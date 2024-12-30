import sys

input = sys.stdin.readline

T = int(input())
res = T

for _ in range(T):
    word = input()
    visited = []
    prev = None
    for i in word:
        if i in visited:
            if prev == i:
                continue
            else:
                res -= 1
            break
        else:
            if prev != i:
                visited.append(i)
        prev = i

print(res)