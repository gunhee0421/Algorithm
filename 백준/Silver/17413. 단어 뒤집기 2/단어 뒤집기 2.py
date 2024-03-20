from sys import stdin
input=stdin.readline

word=input()

stack=[]
check=False
result=""

for i in word:
    if i=='<':
        check=True
        for _ in range(len(stack)):
            result += stack.pop()
    stack.append(i)

    if i=='>':
        check=False
        for _ in range(len(stack)):
            result += stack.pop(0)

    if i==' ' and check==False:
        for i in range(len(stack)):
            if i==0:
                stack.pop()
                continue
            result+=stack.pop()
        result+=" "

if stack:
    for i in range(len(stack)):
        if i==0:
            stack.pop()
            continue
        result += stack.pop()

print(result)
