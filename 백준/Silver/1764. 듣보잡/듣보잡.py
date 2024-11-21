import sys
input = sys.stdin.readline

N, M = map(int, input().split())

inSet = set()
outSet = set()
result = set()

for n in range(N):
    inSet.add(input().strip())
for m in range(M):
    outSet.add(input().strip())

for i in inSet:
    if i in outSet:
        result.add(i)

sortedResult = sorted(result)

print(len(sortedResult))
for i in sortedResult:
    print(i)