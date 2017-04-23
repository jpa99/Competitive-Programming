import java.util.*;
import java.io.*;

public class prob08 
{
	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(new File("prob08.txt"));
		int trials = scan.nextInt();
		scan.nextLine();
		int n = 0;
		while (n < trials)
		{
			String word = scan.nextLine();
			
			
			String[] array = new String[20];
			int i;
			for (i = 0; i < word.length(); i++)
			{
				String toReturn = "";
				int z = 0;
				while(z < word.length() - i - 1)
				{
					toReturn += " ";
					z++;
				}
				int x = 0;
				while (x < i + 1)
				{
					toReturn += word.charAt(x);
					x++;
				}
				array[i] = toReturn;
			}
			
			for (int k = 0; k < word.length() - 1; k++)
			{
				String return2 = "";
				int y = k + 1;
				while (y < word.length())
				{
					return2 += word.charAt(y);
					y++;
				}
				
				int h = 0;
				while (h < k)
				{
					return2 += " ";
					h++;
				}
				array[i + k] = return2;
			}
			
			for (int a=0;a<array.length;a++)
			{
				try{
					if(!array[a].equals(null)){
						System.out.println(array[a]);
					}
				}
				catch(NullPointerException e){}
			}
			System.out.println();
			n++;
		}

	}

}
