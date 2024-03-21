from sys import stdin
input=stdin.readline

T=int(input())
for i in range(T):
    N=int(input())
    hash={}
    for j in range(N):
        a, b = map(str, input().split())
        if b in hash:
            l=hash.get(b)
            hash[b].append(a)
        else:
            hash[b]=[a]

    ans=1
    for key in hash:
        ans*=len(hash[key])+1
    print(ans-1)
