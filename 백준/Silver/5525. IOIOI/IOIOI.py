import sys

input = sys.stdin.readline

n = int(input())
m = int(input())
s = input()

strLen = 2*n+1
res = 0

for i in range(len(s)-strLen):
    word = s[i:i+strLen]

    if word[0] == word[-1] == 'I':
        suc = True
        prev = word[0]
        for j in range(1, len(word)):
            cur = word[j]
            if prev == cur:
                suc = False
                break
            prev = cur
        if suc:
            res += 1

print(res)