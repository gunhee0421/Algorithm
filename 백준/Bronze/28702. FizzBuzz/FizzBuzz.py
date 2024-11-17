list = []
num = 0
result = 0

for i in range(3):
    n = input()
    if n.isnumeric():
        num = n
    list.append(n)

for i in range(3):
    if list[i] == num:
        result = int(num) + (3-i)

if result%3==0 and result%5==0:
    print("FizzBuzz")
elif result%3==0 and result%5!=0:
    print("Fizz")
elif result % 5 == 0 and result % 3 != 0:
    print("Buzz")
else:
    print(result)