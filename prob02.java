import java.util.*;
import java.io.*;

public class prob02 {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("prob02.txt"));
		
		
		while(scan.hasNextLine()){
			int gallons = scan.nextInt();
			if(gallons!=0){
				int weeks = 10000 / gallons;
			
				System.out.println(gallons + " gallons per week will last " + weeks + " weeks");
			}
		scan.nextLine();
		}
	}

}
