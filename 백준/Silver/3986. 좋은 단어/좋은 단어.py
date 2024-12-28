import sys
input = sys.stdin.readline

T = int(input())
res = 0

for _ in range(T):
    s = list(input())
    arr = []
    s.pop()

    while s:
        if (len(arr) > 0):
            if (arr[-1] == s[-1]):
                s.pop()
                arr.pop()
            else:
                arr.append(s.pop())
        else:
            arr.append(s.pop())

    if (len(arr) == 0):
        res += 1

print(res)
