def solution(clothes):
    dict = {}
    res = 1
    
    for i in range(len(clothes)):
        value, key = clothes[i]
        if key in dict:
            dict[key] += 1
        else:
            dict[key] = 1
            
    for key, value in dict.items():
        res *= value+1
    return res-1