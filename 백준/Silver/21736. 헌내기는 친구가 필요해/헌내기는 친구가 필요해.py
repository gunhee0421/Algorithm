import sys
input = sys.stdin.readline

X, Y = map(int, input().split())
graph = [list(input().strip()) for _ in range(X)]
visited = [[False] * Y for _ in range(X)]
queue = []
res = 0

for i in range(X):
    if 'I' in graph[i]:
        start = (i, graph[i].index('I'))
        queue.append(start)
        visited[start[0]][start[1]] = True
        break

while queue:
    x, y = queue.pop(0)

    for dx, dy in [(-1, 0), (1, 0), (0, -1), (0, 1)]:
        nx, ny = x + dx, y + dy

        if 0 <= nx < X and 0 <= ny < Y and not visited[nx][ny]:
            visited[nx][ny] = True
            if graph[nx][ny] == 'P':
                res += 1
            if graph[nx][ny] in 'PO':
                queue.append((nx, ny))

print("TT" if res == 0 else res)