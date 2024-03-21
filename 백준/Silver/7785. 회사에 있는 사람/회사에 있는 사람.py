from sys import stdin
input = stdin.readline

T = int(input())
q={}
ans=[]

for _ in range(T):
    a=input().split()
    q[a[0]]=a[1]

for key in q:
    if q[key]=="enter":
        ans.append(key)

result=sorted(ans, reverse=True)

for out in result:
    print(out)
