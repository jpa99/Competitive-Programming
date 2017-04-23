import java.util.*;
import java.io.*;

public class prob10 {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("prob10-1-in.txt"));
		String board = scan.nextLine();
		
		
		char[][] board3 = new char[3][3];
		int num = 0;
		for(int r = 0; r < 3; r++)
		{
			for(int c = 0; c < 3; c++)
			{
				if(num < board.length())
				{
					board3[r][c] = board.charAt(num);
					num++;
				}
				
			}
		}
		
		if(board3[0][0] == board3[0][1] && board3[0][1]== board3[0][2])
		{
			char winner = board3[0][0];
			board3[0][0] = '$';
			
		}
		

	}

}
