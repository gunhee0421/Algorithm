import heapq

def solution(scoville, K):
    heap = []
    res = 0
    
    for s in scoville:
        heapq.heappush(heap, int(s))
    
    while heap[0] < K:
        if len(heap)<2:
            return -1
        a = heapq.heappop(heap)
        b = heapq.heappop(heap)
        
        heapq.heappush(heap, a+b*2)
        res+=1
    
    return res