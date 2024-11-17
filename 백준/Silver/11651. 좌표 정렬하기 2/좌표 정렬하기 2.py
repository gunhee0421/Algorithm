T=int(input())

arr = []

for i in range(T):
    arr.append(tuple(map(int, input().split())))

arr.sort(key=lambda a: (a[1], a[0]))

for i in range(T):
    print(str(arr[i][0])+" "+str(arr[i][1]))