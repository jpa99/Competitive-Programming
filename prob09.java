import java.io.File;
import java.util.*;
public class prob09 {

	public static void main(String[] args) throws Exception
	{
		Scanner scan = new Scanner(new File("prob09-1-in.txt"));
		
		int x = 0;
		while (x < 3)
		{
			String[] nums = new String[3];
			nums = scan.nextLine().split(" ");
			int[] ints = new int[3];
			for (int i = 0;i<nums.length;i++)
			{
				ints[i]=Integer.parseInt(nums[i]);
			}	
		
			double painted = 2 * ((ints[0] * ints[1]) + (ints[0] * ints[2]) + (ints[1] * ints[2]));
			double notPainted =  6*(ints[0] * ints[1] * ints[2]);
			notPainted = notPainted - painted;
			System.out.println(painted);
			System.out.println(notPainted);

			if (painted == notPainted)
			{
				System.out.println("A " + ints[0] + "x" + ints[1] + "x" + ints[2] + "x block is PERFECT.");
			}
			if (painted > notPainted)
			{
				System.out.println("A " + ints[0] + "x" + ints[1] + "x" + ints[2] + "x block is MORE than Perfect.");
			}
			if (painted < notPainted)
			{
				System.out.println("A " + ints[0] + "x" + ints[1] + "x" + ints[2] + "x block is LESS than PERFECT.");
			}
			x++;
		}
		
	}

}
