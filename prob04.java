import java.util.*;
import java.io.*;

public class prob04 {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("prob04-1-in.txt"));
		double a;
		int index;
		String n;
		
		while(scan.hasNextLine())
		{
			double base = scan.nextDouble();
			if(base != 0.0)
			{
				int exponent = scan.nextInt();
				a=(base * Math.pow(10, exponent));
				n=String.valueOf(a);
				index=n.indexOf(".");
				if(n.substring(index+1).length()>2){
					System.out.println(n.substring(0, index)+round(n.substring(index+1, index+3)));
				}
			}
		}


	}
	
	
	public static String round(String a){
		String str;
		int x;
		String[] s=a.split("");
		if(Integer.parseInt(s[1])<5){
			return s[0];
		}
		else{
			x=Integer.parseInt(s[0]);
			x++;
			return String.valueOf(x);
		}
	}

}
