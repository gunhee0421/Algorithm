import sys
input = sys.stdin.readline

N, R, C = map(int, input().split())

def z_division(n, r, c):
    if n == 0:
        return 0

    half = 2 ** (n-1)

    if r < half and c < half:
        return z_division(n-1, r, c)
    elif r < half and c >= half:
        return half * half + z_division(n-1, r, c-half)
    elif r >= half and c < half:
        return 2 * half * half + z_division(n-1, r-half, c)
    elif r >= half and c>= half:
        return 3 * half * half + z_division(n-1, r-half, c-half)

res = z_division(N, R, C)
print(res)