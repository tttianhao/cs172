import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class isAnagram {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first word");
        String first = scan.nextLine();
        System.out.println("Enter the second word");
        String second = scan.nextLine();
        HashMap firstMap = isAna(first);
        HashMap secondMap = isAna(second);
        if (firstMap.equals(secondMap)) {
            System.out.println("There are anagram");
        } else {
            System.out.println("There are not anagram");
        }
    }

    public static HashMap isAna(String word) {
        Map map1 = new HashMap();
        for (int i = 0; i < word.length(); i++ ) {
            if (!map1.containsKey(word.charAt(i))) {
                map1.put(word.charAt(i), 1);
            } else {
                int count = (Integer) map1.get(word.charAt(i));
                map1.put(word.charAt(i), count + 1);
            }
        }
        return (HashMap) map1;
    }
}
