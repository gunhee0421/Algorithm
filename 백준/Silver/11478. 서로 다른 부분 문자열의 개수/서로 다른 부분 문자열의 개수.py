s = input()
set = set()
l=1
i=0

while l<len(s)+1:
    set.add(s[i:i+l])
    i=i+1
    if i==len(s):
        l=l+1
        i=0

print(len(set))