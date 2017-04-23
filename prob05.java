import java.util.*;
import java.io.*;

public class prob05 {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("prob05.txt"));
		int n;
		String str, x;
		String[] a;
		String[] arr;
		int numLines = scan.nextInt();
		scan.nextLine();
		for(int lin=0;lin<numLines;lin++){
			x="";
			a=scan.nextLine().split(" ");
			n=Integer.parseInt(a[0]);
			str=a[1];
			arr=str.split("");
			for(int i=0;i<arr.length;i++){
				if(i%n!=0){
					x+=arr[i];
				}
			}
			
			System.out.println(x+" "+x.length());
		}

	}
	

	


}
