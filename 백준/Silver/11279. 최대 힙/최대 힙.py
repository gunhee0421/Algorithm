import sys
from queue import PriorityQueue
input = sys.stdin.readline

q = PriorityQueue()
n = int(input())
for i in range(n):
    s = int(input())
    if s==0:
        if q.empty():
            print(0)
        else:
            print(-q.get())
    else:
        q.put(-s)
