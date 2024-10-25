n, m = map(int, input().split())

graph = []
cnt = []

for i in range(n):
    graph.append(input())

for i in range(n-7):
    for j in range(m-7):
        wIndex = 0
        bIndex = 0
        for k in range(i, i+8):
            for l in range(j, j+8):
                if (k+l)%2==0:
                    if graph[k][l]!='W':
                        wIndex+=1
                    else:
                        bIndex+=1
                else:
                    if graph[k][l]!='W':
                        bIndex+=1
                    else:
                        wIndex+=1

        cnt.append(wIndex)
        cnt.append(bIndex)

print(min(cnt))