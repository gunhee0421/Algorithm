import sys
import math

def is_prime(num):
    if num < 2:
        return False
    for i in range(2, int(math.sqrt(num)) + 1):
        if num % i == 0:
            return False
    return True

def backtrack(num, length, N):
    if not is_prime(num):
        return

    if length == N:
        print(num)
        return

    for i in range(1, 10, 2):
        backtrack(num * 10 + i, length + 1, N)

def solution(N):
    for prime in [2, 3, 5, 7]:
        backtrack(prime, 1, N)

if __name__ == "__main__":
    N = int(sys.stdin.readline().strip())
    solution(N)
