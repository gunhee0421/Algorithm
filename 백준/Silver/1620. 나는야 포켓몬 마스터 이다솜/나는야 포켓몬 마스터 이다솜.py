N, M = map(int , input().split())
hash={}
copy={}
result=[]

for i in range(1, N+1):
    n=input()
    hash[n]=i
    copy[i]=n

for i in range(M):
    que= input()
    if que.isalpha():
        result.append(hash.get(que))
    else:
        result.append(copy.get(int(que)))
print(*result, sep="\n")
