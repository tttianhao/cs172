import java.util.ArrayList;
import java.util.Scanner;

public class Lab3Task2 {

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
		
		runningSum2DArray(arr, 1);
		runningSum2DArray(arr, 2);
		runningSum2DArrayList(list, 3);
		runningSum2DArrayList(list, 4);
		
		scanner.close();

	}
	public static void runningSum2DArray(int[][] array, int dir) {
		int[][] temp = array;
		switch(dir) {
			case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 2; j >=0; j--) {
					temp[i][j] += temp[i][j+1];
				}
			}
			break;

			case 2:
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= 3; j++) {
					temp[i][j] += temp[i][j-1];
				}
			}
			break;

			case 3:
			for (int j = 0; j<4; j++) {
				for (int i = 2; i >= 0; i--) {
					temp[i][j] += temp[i+1][j];
				}
			}
			break;

			case 4:
			for (int j = 0; j< 4; j++) {
				for (int i = 1; i <= 3; i++) {
					temp[i][j] += temp[i-1][j];
				}
			}
			break;
		}
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++){
				System.out.printf("  %s",temp[i][j]);
			}
			System.out.println();
		}
		
	}

	public static void runningSum2DArrayList(ArrayList< ArrayList< Integer > > list, int dir) {
		switch(dir) {
			case 1:
			for (int i = 0; i < 4; i++) {
				for (int j = 2; j >=0; j--) {
					list.get(i).set(j, list.get(i).get(j)+list.get(i).get(j+1));
				}
			}
			break;

			case 2:
			for (int i = 0; i < 4; i++) {
				for (int j = 1; j <= 3; j++) {
					list.get(i).set(j, list.get(i).get(j) + list.get(i).get(j-1));
				}
			}
			break;

			case 3:
			for (int j = 0; j<4; j++) {
				for (int i = 2; i >= 0; i--) {
					list.get(i).set(j, list.get(i).get(j) + list.get(i+1).get(j));
				}
			}
			break;

			case 4:
			for (int j = 0; j< 4; j++) {
				for (int i = 1; i <= 3; i++) {
					list.get(i).set(j, list.get(i).get(j) + list.get(i-1).get(j));
				}
			}
			break;

		}
		for (int i=0; i<4; i++) {
			for (int j=0; j<4; j++){
				System.out.printf("  %s",list.get(i).get(j));
			}
			System.out.println();
		}
	}

}
