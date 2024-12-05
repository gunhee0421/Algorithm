import sys
input = sys.stdin.readline

n, m, b = map(int, input().split())
ground = []
for _ in range(n):
    ground.extend(map(int, input().split()))

time = [0 for i in range(257)]
dept = 0

for i in range(257):
    block = b
    for j in ground:
        if j <= i:
            time[i] += i-j
            block -= i-j
        else:
            time[i] += 2*(j-i)
            block += j-i
    if block >= 0 and time[i] <= time[dept]:
        dept = i

print(time[dept], dept)