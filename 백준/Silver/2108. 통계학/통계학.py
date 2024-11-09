from collections import Counter
import sys

input = sys.stdin.readline

N=int(input())
arr=[int(input()) for _ in range(N)]

arr.sort()

count= Counter(arr)
mostCommen=count.most_common()

maxFreq = mostCommen[0][1]
modes=[num for num, freq in mostCommen if freq==maxFreq]

print(round(sum(arr)/len(arr)))
print(arr[round(len(arr)//2)])
if len(modes) > 1:
    print(modes[1])
else:
    print(modes[0])
print(max(arr) - min(arr))