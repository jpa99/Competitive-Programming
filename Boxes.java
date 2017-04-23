import java.util.Arrays;
import java.util.Scanner;

public class Boxes {

	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(System.in);
		
		int rows=5;
		int cols=6;
		String character="*";
		
		String[][] arr=new String[rows][cols];
		for(int r=0;r<rows;r++){
			for(int c=0;c<cols;c++){
				arr[r][c]=character;
			}
		}
		
		for(int r=2;r<rows-2;r++){
			for(int c=2;c<cols-2;c++){
				arr[r][c]=" ";
			}
		}
		
		for(String[] a:arr){
			System.out.println(Arrays.toString(a));
		}
		

	}

}
