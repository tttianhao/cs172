import java.awt.*;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean play = true;
        while (play) {
            int counter = 0;
            boolean game = true;
            int[][] board = initialBoard();
            printBoard(board, "no");
            while (game) {
                if (checkValid(board, "w") == false && checkValid(board, "a") == false && checkValid(board, "s") == false && checkValid(board, "d") == false) {
                    // Here it checks if there is a valid move, if there is no valid move then game is over
                    gameOver(board);
                    game = false;
                    play = false;
                    break;
                }
                System.out.println("Your current maximum is: "+maximum(board));
                System.out.println();
                System.out.println("make a move");
                String wasd = scanner.nextLine();
                if (wasd.equals("w")){

                    // Check player's action
                    if (checkValid(board, "w")) {
                        // If the players action is valid
                        up(board);
                        // Move the board accordingly
                        genNewNumber(board);
                        // Generate a new number on the board
                        printBoard(board, "w");
                        // Show the current board after action
                        counter++;
                        // The counter of movement +1
                        System.out.println("Current Move: " + counter);

                    }
                    else {
                        System.out.println("Your input is not valid");
                    }

                } else if (wasd.equals("a")){
                    // Same logic for all the directions

                    if (checkValid(board, "a")) {
                        left(board);
                        genNewNumber(board);
                        printBoard(board, "a");
                        counter++;
                        System.out.println("Current Move: " + counter);
                    }
                    else {
                        System.out.println("Your input is not valid");
                    }

                } else if (wasd.equals("s")) {
                    if (checkValid(board, "s")) {
                        down(board);
                        genNewNumber(board);
                        printBoard(board, "s");
                        counter++;
                        System.out.println("Current Move: " + counter);
                    }
                    else {
                        System.out.println("Your input is not valid");
                    }

                } else if (wasd.equals("d")) {
                    if (checkValid(board, "d")) {
                        right(board);
                        genNewNumber(board);
                        printBoard(board, "d");
                        counter++;
                        System.out.println("Current Move: " + counter);
                    }
                    else {
                        System.out.println("Your input is not valid");
                    }

                } else if (wasd.equals("r")) {
                    // If player wish to restart
                    while (true) {
                        System.out.println("Are you sure to restart? (yes/no)");
                        // Ask for confirmation
                        String sure = scanner.nextLine();
                        if (sure.equals("yes")) {
                            // Terminate the current game if the user is sure.
                            gameOver(board);
                            System.out.println("Number of movement you made: "+counter);
                            game = false;
                            break;
                        } else if (sure.equals("no")) {
                            break;
                        } else {
                            System.out.println("please enter 'yes' or 'no'.");
                        }
                    }
                } else if (wasd.equals("q")) {
                    // If palyer wish to quit
                    while (true) {
                        System.out.println("Are you sure to quit? (yes/no)");
                        // Ask for confirmation
                        String quit = scanner.nextLine();
                        if (quit.equals("yes")) {
                            // Terminate the current game and quit the program
                            game = false;
                            play = false;
                            break;
                        } else if (quit.equals("no")) {
                            break;
                        } else {
                            System.out.println("please enter 'yes' or 'no'. ");
                        }
                    }
                } else {
                    System.out.println("Please enter 'q' for quit, 'r' for restart or 'w', 'a', 's', 'd' for movements ");
                }

            }
        }


    }

    public static int[][] initialBoard() {
        /*
        This function create the initial board by randomly generate two number (P(2) = 0.8 or P(4) = 0.2) on the board

        Args: none

        returns: a 4x4 array with the infomation of the inital board
         */
        int[][] board = new int[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                board[i][j] = 0;
            }
        }

        for (int l = 0; l < 2; l++){
            double twoOrFour = Math.random();
            int[] index = checkIndex(board);
            int index1 = index[0];
            int index2 = index[1];
            if (twoOrFour < 0.8) {
                board[index1][index2] = 2;
            } else {
                board[index1][index2] = 4;
            }
        }
        return board;
    }

    public static int[] checkIndex(int[][] array) {
        /*
        This function check the index of a tile which does not have number (this function is used to generate a random index of an empty tile)

        Args: 4*4 array, the current board

        returns: a 1*2 array with the first element the row index and second element the column index.
                 null, if the board is all full
         */
        int[] index = new int[16];
        int i = 0;
        for (int j = 0; j < 4; j++) {
            for (int k = 0; k < 4; k++) {
                if (array[j][k] == 0) {
                    index[i] = j*4+k+1;
                }
                i++;
            }
        }
        boolean noZero = true;
        for (int m : index) {
            noZero = noZero && m == 0;
        }
        if(noZero) {
            return null;
        }

        Random rand = new Random();
        while (true) {
            int randIndex = rand.nextInt(16);
            if (index[randIndex] != 0) {
                int[] newIndex = new int[2];
                newIndex[1] = (index[randIndex] - 1) % 4;
                newIndex[0] = (index[randIndex] - 1 - newIndex[1]) / 4;
                return newIndex;
            }
        }
    }

    public static void printBoard(int[][] array, String choose) {
        /*
        This function print the board in a somewhat pretty but definetly neat way

        Args: 4*4 array, the current board

        returns: void
         */
        for (int r = 0; r < 25; r++) {
            System.out.println();
        }
        String movement = null;
        switch (choose) {
            case "a":
                movement = "left";
                break;
            case "s":
                movement = "down";
                break;
            case "d":
                movement = "right";
                break;
            case "w":
                movement = "up";
                break;
        }
        if (movement != null) {System.out.println("You choose to move " + movement + ". That is valid.");}
        System.out.println("+---------------------+");
        for (int i = 0; i < 4; i++) {
            System.out.printf("%s","|");
            for (int j = 0; j < 4; j++) {
                if (array[i][j] != 0) {
                    System.out.printf("%5s", array[i][j]);
                }
                else {
                    System.out.printf("%5s", "*");
                }
            }
            System.out.printf("%2s","|");
            System.out.println();
        }
        System.out.println("+---------------------+");
    }

    public static boolean genNewNumber(int[][] array) {
        /*
        This function generates a new number in the board at a empty tile with P(2) = 0.8 and P(4) = 0.2

        Args: 4*4 array, the current board

        returns: true if there is empty tile in the board
                 false if the board if full
         */
        int[] index = checkIndex(array);
        if (index == null) {
            return false;
        } else {
            if (Math.random() < 0.8) {
                array[index[0]][index[1]] = 2;
            } else {
                array[index[0]][index[1]] = 4;
            }
        }
        return true;
    }

    public static void left(int[][] array) {
        /*
        This function and the next three functions (right, up, down) are the movement of board based on players choice

        Args: 4*4 array, the current board

        returns: void
         */
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = array[i][j];
            }
            checkSum(temp);
            move(temp);
            for (int k = 0; k < 4; k++) {
                array[i][k] = temp[k];
            }
        }
    }

    public static void right(int[][] array) {
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[4];
            for (int j = 0; j < 4; j++) {
                temp[j] = array[i][3-j];
            }
            checkSum(temp);
            move(temp);
            for (int k = 0; k < 4; k++) {
                array[i][k] = temp[3-k];
            }
        }
    }

    public static void up(int[][] array) {
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[4];
            for (int j = 0; j<4; j++) {
                temp[j] = array[j][i];
            }
            checkSum(temp);
            move(temp);
            for (int k = 0; k < 4; k++) {
                array[k][i] = temp[k];
            }
        }
    }

    public static void down(int[][] array) {
        for (int i = 0; i < 4; i++) {
            int[] temp = new int[4];
            for (int j = 0; j<4; j++) {
                temp[3-j] = array[j][i];
            }
            checkSum(temp);
            move(temp);
            for (int k = 0; k < 4; k++) {
                array[k][i] = temp[3-k];
            }
        }
    }

    public static void checkSum(int[] array) {
        /*
        This function sum up the numbers in a line based on the 2048's rule. (i.e. it sum up the same number with no other numbers in between)

        Args: 1*4 array, one line of the board (could be one row or column based on users action)

        returns: void
         */
        for (int i = 0; i < 4; i++) {
            if (i == 0 && array[i+1] == 0 && array[i+2]==0 && array[i+3] == array[i]) {
                array[i] = array[i] + array[i];
                array[i+3] = 0;
            } else if ((i == 0 || i == 1) && array[i+1]==0 && array[i+2]==array[i]) {
                array[i] = array[i] + array[i];
                array[i+2] = 0;
            } else if ((i == 0 || i == 1 || i == 2) && array[i] == array[i+1]) {
                array[i] = array[i] + array[i];
                array[i+1] = 0;
            }
        }
    }

    public static void move(int[] array) {
        /*
        This function move the numbers to up, down, left or right based on player's choice. It moves all the numbers to the nearest empty tile.

        Args: 1*4 array, one row or column of the board

        returns: void
         */
        if (array[0] != 0 && array[1] != 0 && array[2] != 0 && array[3] != 0) {
            return;
        } else if (array[0] == array[1] && array[2] == array[3] && array[0]==0 && array[0] == array[2]) {
            return;
        } else {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (array[j] == 0) {
                        array[j] = array[j+1];
                        array[j+1] = 0;
                    }
                }
            }
        }
    }

    public static void gameOver(int[][] array) {
        /*
        This function handles when the game is over. the function calculates the largest number and print it out

        Args: 4*4 array, the current board

        returns: void
         */
        int key = array[0][0];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (array[i][j] > key) {
                    key = array[i][j];
                }
            }
        }
        System.out.println("Game is over.");
        System.out.println("Your highest number is: " + key);
    }

    public static boolean checkValid(int[][] array, String move) {
        /*
        This function check a movement is valid by creating a temp board on which the movement is executed and then compare the result after movement and see if there is any difference before and after the movement

        Args: 4*4 array, the board
              move: a string of 'a', 's', 'd', 'w'

        returns: true if there is difference
                 false if there is no difference (movement is not valid)
         */
        int[][] temp = new int[4][4];
        for (int i = 0 ; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                temp[i][j] = array[i][j];
            }
        }

        switch (move) {
            case "a":
                left(temp);
                break;

            case "s":
                down(temp);
                break;

            case "d":
                right(temp);
                break;

            case "w":
                up(temp);
                break;
        }
        for ( int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (temp[i][j] != array[i][j]){
                    return true;
                }
            }
        }
        return false;
    }

    public static int maximum(int[][] array) {
        int key = array[0][0];
        for (int i =0; i<4; i++){
            for(int j = 0; j<4; j++){
                if(array[i][j]>key){
                    key = array[i][j];
                }
            }
        }
        return key;
    }
}
