import sys
input = sys.stdin.readline

s = input().strip()

minusWords = s.split('-')

result = sum(map(int, minusWords[0].split('+')))

for i in minusWords[1:]:
    result -= sum(map(int, i.split('+')))

print(result)