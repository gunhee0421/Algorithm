from sys import stdin
input = stdin.readline

S, E, Q = input().split()
S, E, Q = int(S[0:2]) * 60 + int(S[3:]), int(E[0:2]) * 60 + int(E[3:]), int(Q[0:2]) * 60 + int(Q[3:])

map = set()
answer = 0

while True:
    try:
        time, name = input().split()
        time = int(time[0:2]) * 60 + int(time[3:])

        if time <= S:
            map.add(name)

        elif E <= time <= Q and name in map:
            map.remove(name)
            answer += 1

    except:
        break

print(answer)
