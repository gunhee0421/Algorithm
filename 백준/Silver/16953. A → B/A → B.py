import sys
from collections import deque
input = sys.stdin.readline

A, B = map(int, input().split())

q = deque()
res = sys.maxsize

q.append((A, 0))
visited = [A]

while q:
    num, index = q.popleft()

    if num == B:
        res = min(res, index)
    else:
        numOne = int(str(num)+str(1))
        numDuble = num * 2
        if (numOne <= B) and (numOne not in visited):
            q.append((numOne, index+1))
            visited.append(numOne)
        if (numDuble <= B) and (numDuble not in visited):
            q.append((numDuble, index+1))
            visited.append(numDuble)

if res == sys.maxsize:
    print(-1)
else:
    print(res+1)