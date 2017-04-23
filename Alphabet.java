import java.util.*;
import java.io.*;

public class Alphabet {

	public static void main(String[] args) throws Exception{
		
		Scanner scan=new Scanner(new File("art.in"));
		//longest increasing substring
		char[] str=scan.nextLine().toUpperCase().toCharArray();
		System.out.println(Arrays.toString(str));
		int[] hash=new int[26];
		for(int i=0;i<str.length;i++){
			hash[str[i]-65]++;
		}
		System.out.println(Arrays.toString(hash));
		
		

	}

}
