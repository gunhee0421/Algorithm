import sys

input = sys.stdin.readline

T = int(input())

data = set()

for i in range(T):
    rq = input().split()

    if len(rq) == 1:
        if rq[0] == "all":
            data = set([i for i in range(1, 21)])
        else:
            data = set()
    else:
        rq[1] = int(rq[1])
        if rq[0] == 'add':
            data.add(rq[1])
        elif rq[0] == 'remove':
            if rq[1] in data:
                data.remove(rq[1])
        elif rq[0] == 'check':
            if rq[1] in data:
                print(1)
            else:
                print(0)
        elif rq[0] == 'toggle':
            if rq[1] in data:
                data.remove(rq[1])
            else:
                data.add(rq[1])
        elif rq[0] == 'empty':
            data.clear()