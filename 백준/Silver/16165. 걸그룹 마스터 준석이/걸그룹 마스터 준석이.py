from sys import stdin

a, b = map(int, input().split())

list={}
result=""

for i in range(a):
    c = input()
    n = int(input())
    l=[]
    for j in range(n):
        l.append(input())
    list[c]=l

for i in range(b):
    word = input()
    num = int(input())

    if num==0:
        arr = list.get(word)
        arr = sorted(arr)
        for j in range(len(arr)):
            result+=arr[j]+"\n"
    else:
        for key in list:
            arr = list[key]
            if word in arr:
                result+=key+"\n"

print(result)