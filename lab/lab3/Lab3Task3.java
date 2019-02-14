import java.util.ArrayList;
import java.util.Scanner;

public class Lab3Task3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//input integers with white space between them
		ArrayList<Integer> list = new ArrayList<Integer>();
		String[] tempB = scanner.nextLine().split("\\s");
		for(String s : tempB) {
			list.add(Integer.parseInt(s));
		}

		printArrayListBasicLoop(list);
		printArrayListEnhancedLoop(list);
		printArrayListForLoopListIterator(list);
		printArrayListLambda(list);

		scanner.close();

	}

	public static void printArrayListBasicLoop(ArrayList<Integer> al){
		for (int i = 0; i < 4; i++) {
			System.out.println(al.get(i));
		}
	}

	public static void printArrayListEnhancedLoop(ArrayList<Integer> al) {
		for (Integer i : al) {
			System.out.println(i);
		}
	}

	public static void printArrayListForLoopListIterator(ArrayList<Integer> al) {
		for (Integer i : al) {
			System.out.println(i);
		}
	}

	public static void printArrayListLambda(ArrayList<Integer> al) {
		int i = 0;
		while (i<4) {
			System.out.println(al.get(i));
			i++;
		}
	}

}
