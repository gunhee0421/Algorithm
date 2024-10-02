N=int(input())
list=list(map(int,input().split()))
T,P = map(int,input().split())
sum=0

for i in list:
    if i==0:
        continue
    elif i<=T:
        sum+=1
    elif i%T==0:
        sum+=i//T
    else:
        sum+=i//T+1

pen_sum = N//P
pen = N%P

print(sum)
print(f'{pen_sum} {pen}')