import matplotlib.pyplot as plt
import argparse

def move(initial, final):
    key = initial[-1]
    initial.pop()
    final.append(key)
    global step
    step += 1
    print("move ", step)
    print("left:   ", source)
    print("middle: ", aux)
    print("right:  ", dest)

def getParser():
    parser = argparse.ArgumentParser()
    parser.add_argument('--number', type = int, default = 10, help = "The number of plates" )
    args = parser.parse_args()
    return args

def magicMove(n, initial, middle, final):
    if n == 1:
        move(initial,final)
        return
    else:
        magicMove(n-1, initial, final, middle)
        move(initial, final)
        magicMove(n-1, middle, initial, final)


if __name__ == "__main__":
    step = 0
    args = getParser()
    i = args.number
    source = []
    while i>0:
        source.append(i)
        i -= 1
    print(source)
    aux = []
    dest = []
    magicMove(args.number, source, aux ,dest)
    print("Total steps needed is: ",step)