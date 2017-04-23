import java.util.*;
import java.io.*;
public class prob06 
{

	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner (new File("prob06.txt"));
		int trials  = scan.nextInt();
		scan.nextLine();
		int n = 0;
		while (n < trials)
		{
			String[] nums = new String[5];
			nums = scan.nextLine().split(" ");
			int[] ints = new int[5];
			for (int i=0;i<nums.length;i++)
			{
				ints[i]=Integer.parseInt(nums[i]);
			}
			
			float slope = 0;
			slope += ((ints[4] / 8) - (ints[3] / 8));
			slope = slope / (ints[2] - ints[1]);
			float temp = (slope * ints[0]) - (slope * ints[1]) + (ints[3] / 8);
			System.out.println(temp);
			n++;
		}

	}

}
