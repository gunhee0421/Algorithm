from sys import stdin
input=stdin.readline

N, M = map(int, input().split())
hash={}

for i in range(1, N+1):
    n=input().strip()
    hash[n]=str(i)
    hash[str(i)]=n

for i in range(M):
    print(hash.get(input().strip()))
