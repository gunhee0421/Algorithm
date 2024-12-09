import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
s = input()

strLen = 2*n+1
res = 0
count = 0
i = 1

while i < len(s) - 1:
    if s[i-1] == 'I' and s[i] == 'O' and s[i+1] == 'I':
        count += 1
        if count == n:
            res += 1
            count -= 1
        i += 1
    else:
        count = 0
    i += 1

print(res)