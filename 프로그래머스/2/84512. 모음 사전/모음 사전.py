from itertools import*

def solution(word):
    arr= []
    mo = ['A', 'E', 'I', 'O', 'U']
    
    for i in range(1, 6):
        for j in list(product(mo, repeat=i)):
            arr.append(''.join(j))
    arr.sort()
    
    return arr.index(word)+1