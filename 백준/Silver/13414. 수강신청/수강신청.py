from sys import stdin
input=stdin.readline

K, L = map(int, input().split())
map={}

for index in range(1, L+1):
    map[input().strip()]=index

map=sorted(map.items(), key= lambda item : item[1])

if len(map)<K:
    K=len(map)

for _ in range(K):
    print(map.pop(0)[0])
