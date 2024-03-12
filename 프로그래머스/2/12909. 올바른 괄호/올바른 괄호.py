def solution(s):
    answer = True

    stack=[]

    for i in range(0, len(s)):
        word = s[i : i+1]
        if word=='(':
            stack.append('(')
        else:
            if(len(stack)==0):
                return False
            stack.pop()

    if(len(stack)>0):
        return False

    return True