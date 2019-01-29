import java.util.Scanner;

public class isRotation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first word");
        String first = scan.nextLine();
        System.out.println("Enter the second word");
        String second = scan.nextLine();
        boolean rotation = false;
        for (int i = 0; i < first.length(); i++) {
            rotation = rotation || second.equals(rotate(i, first));
            if (rotation) {
                System.out.println("They are rotation");
                break;
            }
        }
        if (!rotation) {System.out.println("They are not rotation");}
    }

    public static String rotate(int i, String word) {
        String newWord = Character.toString(word.charAt(i));
        for (int j = i+1; j < word.length(); j++ ) {
            newWord += Character.toString(word.charAt(j));
        }
        for (int k = 0; k < i; k++) {
            newWord += Character.toString(word.charAt(k));
        }
        return newWord;
    }
}
