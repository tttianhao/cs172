import java.util.ArrayList;
import java.util.Scanner;

public class Lab3Task1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		//input arrays with ";" between them
		String[] temp = scanner.nextLine().split(";");

		//input integers with white space between them
		int[][] arr = new int[4][4];
		for(int i = 0; i < 4; i++){
			String[] tempA = temp[i].split("\\s");
			for(int j = 0; j < 4; j++){
				arr[i][j] = Integer.parseInt(tempA[j]);
			}
		}
		
		//input integers with white space between them
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		for(int i = 0; i < 4; i++){
			String[] tempA = temp[i].split("\\s");
			list.add(i, new ArrayList<Integer>());
			for(int j = 0; j < 4; j++){
				list.get(i).add(j, Integer.parseInt(tempA[j]));
			}
		}
		
		print2Darray(arr);
		print2DList(list);
		
		scanner.close();

	}

	public static void print2Darray(int[][] array) {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++){
				System.out.printf("  %s",array[i][j]);
			}
			System.out.println();
		}
	}

	public static void print2DList(ArrayList<ArrayList<Integer>> list) {
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++){
				System.out.printf("  %s",list.get(i).get(j));
			}
			System.out.println();
		}
	}

}
