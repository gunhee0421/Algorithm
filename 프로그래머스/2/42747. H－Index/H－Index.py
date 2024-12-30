def solution(citations):
    citations.sort(reverse=True)
    
    res = 0
    for i in range(len(citations)):
        if i+1 <= citations[i]:
            res = i+1
        else:
            break
            
    return res