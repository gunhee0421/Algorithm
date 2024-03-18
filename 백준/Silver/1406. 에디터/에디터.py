from sys import stdin
input = stdin.readline

list1 = list(input())
list1.remove("\n")

list2=[]

for i in range(int(input())):
    ip=input().split()

    if ip[0]=='L':
        if list1:
            list2.append(list1.pop())
    elif ip[0]=='D':
        if list2:
            list1.append(list2.pop())
    elif ip[0]=='B':
        if list1:
            list1.pop()
    else:
        list1.append(ip[1])

list1.extend(reversed(list2))
print(('').join(list1))
