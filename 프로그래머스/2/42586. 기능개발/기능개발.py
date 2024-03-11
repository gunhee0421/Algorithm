import math

def solution(progresses, speeds):
    answer = []

    clearTime=[]

    # 완성까지 걸리는 시간 배열
    for i in range(len(progresses)):
        clearTime.append(math.ceil((100-progresses[i])/speeds[i]))

    count, max = 1, clearTime[0]
    for i in range(1, len(clearTime)):
        if max >= clearTime[i]:
            count = count + 1
        else:
            answer.append(count)
            count=1
            max=clearTime[i]
    answer.append(count)

    return answer