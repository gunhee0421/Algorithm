import sys
from collections import deque
input = sys.stdin.readline

q = deque()
T = int(input())

for _ in range(T):
    order = list(input().split())

    if order[0] == "push":
        q.append(int(order[1]))
    elif order[0] == "pop":
        print(q.popleft() if len(q) > 0 else -1)
    elif order[0] == "size":
        print(len(q))
    elif order[0] == "empty":
        print(0 if len(q) > 0 else 1)
    elif order[0] == "front":
        print(q[0] if len(q) > 0 else -1)
    elif order[0] == "back":
        print(q[-1] if len(q) > 0 else -1)
