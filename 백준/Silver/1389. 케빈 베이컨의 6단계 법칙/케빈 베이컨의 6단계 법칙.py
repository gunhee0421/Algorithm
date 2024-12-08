import sys
from collections import deque

input = sys.stdin.readline

N, M = map(int, input().split())

graph = [[] for _ in range(N+1)]

for _ in range(M):
    a, b = map(int, input().split())
    graph[a].append(b)
    graph[b].append(a)

def bfs(start):
    q = deque()
    q.append(start)
    while q:
        cur = q.popleft()
        for i in graph[cur]:
            if visited[i]==0 and start!=i:
                visited[i] = visited[cur]+1
                q.append(i)

result = float('inf')
for i in range(1, N + 1):
    visited = [0 for i in range(N + 1)]
    bfs(i)
    kevin = sum(visited)
    if kevin < result:
         result = kevin
         min_kevin = i

print(min_kevin)