import sys
input = sys.stdin.readline

N = int(input())
arr = [list(map(int, input().split())) for _ in range(N)]

blue, white = 0, 0

def isFull(array, x, y, size):
    value = array[x][y]
    for i in range(x, x + size):
        for j in range(y, y + size):
            if array[i][j] != value:
                return False
    return True

def dfs(array, x, y, size):
    global white, blue
    if isFull(array, x, y, size):
        if array[x][y] == 0:
            white += 1
        else:
            blue += 1
    else:
        halfSize = size // 2
        dfs(array, x, y, halfSize)
        dfs(array, x, y + halfSize, halfSize)
        dfs(array, x + halfSize, y, halfSize)
        dfs(array, x + halfSize, y + halfSize, halfSize)

dfs(arr, 0, 0, N) 
print(white)
print(blue)