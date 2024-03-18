from sys import stdin
from collections import deque

input = stdin.readline

a, b = map(int, input().split())
q=deque()
result=[]

for i in range(1, a+1): q.append(i)

while q:
    for i in range(b-1):
        q.append(q.popleft())
    result.append(q.popleft())

print(str(result).replace('[', '<').replace(']', '>'))