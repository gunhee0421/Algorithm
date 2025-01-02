import sys
from collections import deque
input = sys.stdin.readline

A, B = map(int, input().split())

q = deque()

q.append((A, 1))
visited = set()
visited.add(A)

while q:
    num, index = q.popleft()
    numOne = num*10 + 1
    numDuble = num * 2

    if num == B:
        print(index)
        break
    if (numOne <= B) and (numOne not in visited):
        q.append((numOne, index+1))
        visited.add(numOne)
    if (numDuble <= B) and (numDuble not in visited):
        q.append((numDuble, index+1))
        visited.add(numDuble)
else:
    print(-1)