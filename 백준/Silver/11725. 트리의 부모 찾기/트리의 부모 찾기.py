import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
v = [[0] for _ in range(N+1)]
parent = [0 for _ in range(N+1)]

for _ in range(N-1):
    a, b = map(int, input().split())
    v[a].append(b)
    v[b].append(a)

parent[1] = 0
q = deque()
q.append(1)

while q:
    current = q.popleft()
    for vec in v[current]:
        if parent[vec] == 0:
            parent[vec] = current
            q.append(vec)

print(*parent[2:], sep='\n')
