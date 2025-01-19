import sys as s
n = int(s.stdin.readline().strip())
height = [int(s.stdin.readline().strip()) for _ in range(n)]

stack = []
cnt = 0

for cur in height:
  while stack and stack[-1] <= cur:
    stack.pop()

  cnt += len(stack)
  stack.append(cur)

print(cnt)