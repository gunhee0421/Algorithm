from sys import stdin
input = stdin.readline

T=int(input())

stack=[]
list=[]
num=1
su=True
re=""

for i in range(T):
    list.append(int(input()))

for i in range(len(list)):
    n=list[i]
    if n>=num:
        while n>=num:
            stack.append(num)
            num+=1
            re+="+\n"
        stack.pop()
        re+="-\n"
    else:
        m=stack.pop()
        if m > n:
            print("NO")
            su=False
            break
        else:
            re+="-\n"

if su:
    print(re)
