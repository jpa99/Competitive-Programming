import java.util.*;
import java.io.*;

public class prob03 {

	public static void main(String[] args) throws Exception
	{
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(new File("prob03.txt"));
		int lines = scan.nextInt();
		scan.nextLine();
		int lineNum = 0;
		
		while(lineNum < lines)
		{
			
			String word = scan.nextLine();
			System.out.println(doubLetters(word));
			lineNum++;
		}

	}
	
	public static String doubLetters(String word)
	{
		boolean doubLetters = false;
		for(int i = 0; i < word.length()-1; i++)
		{
			if(word.charAt(i) == word.charAt(i+1))
				return "likes " + word;
		}
		
		return "hates " + word;
		
		
	}

}
