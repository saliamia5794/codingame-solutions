def char_position(letter): 
    return ord(letter) - 97 

l = int(input())
h = int(input())
t = input()
t = t.lower()
for i in range(h):
    row = input()
    j=""
    for i in t:
        if i.isalpha():
            e=char_position(i)
            z=e*l
            j+=row[z:(l+z)]
        else:
            e=26
            z=e*l
            j+=row[z:(l+z)]

    print (j)

