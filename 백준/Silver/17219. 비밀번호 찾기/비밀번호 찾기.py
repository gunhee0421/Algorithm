from sys import stdin
input=stdin.readline

N, M = map(int, input().split())
dict={}

for i in range(N):
    a, b = map(str, input().split())
    dict[a]=b

for i in range(M):
    print(dict.get(input().strip()))