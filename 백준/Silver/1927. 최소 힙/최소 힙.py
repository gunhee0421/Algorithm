import sys
import heapq

input = sys.stdin.readline

T = int(input().strip())
heap = []

for _ in range(T):
    n = int(input().strip())

    if n == 0:
        if heap:
            print(heapq.heappop(heap))
        else:
            print(0) 
    else:
        heapq.heappush(heap, n)