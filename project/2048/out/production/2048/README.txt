Tianhao Yu
contact: tyu14@u.rochester.edu

Usage:

compile the file with ```javac Main.java```
run the file with ```java Main```

Features:

This program is a text based 2048 game. The applicable actions are movement actions, quit and restart.

Movement:

--w: move up
--a: move left
--s: move down
--d: move right

Quit:

--q: quit, the program will ask for confirmation (yes/no)

restart:
--r: restart the game.

everytime the player gives an action, the program checks if the action is valid. If valid, the program will calculate the movement and generate a new number on the board. If not valid, the program will tell the user that the movement is not valid and ask for another valid. 

The program checks if the game is over by checking if there is any valid movement. If such movement doesn't exist, then the game is over. 

The program keeps a counter of valid movement have being made. 

The program outputs the maximum number when the game is over.