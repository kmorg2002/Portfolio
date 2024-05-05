
n1 = int(input("Enter your first value: "))
#second number here
n2 = int(input("Enter your second value: "))

s = n1 + n2

d = n1 - n2

p = n1 * n2

m = n1 % n2
if 10 <= n1 <= 30 and 10 <= n2 <= 30:
    print("Sum ", s)
    print("Diff", d)
    print("Prod", p)
else:
    print("Please try again with values 10-30.")

