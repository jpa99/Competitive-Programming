import java.io.*;
import java.util.*;

public class CowCode {
	static int counter=0;
	public static void main(String[] args) throws Exception {
		long start=System.currentTimeMillis();
		Scanner scan=new Scanner(new File("cowcode.in"));
		PrintWriter writer = new PrintWriter(new File("cowcode.out"));
		String text=scan.next();
		long n=Long.parseLong(scan.next());

		String c=f(n, text);
		System.out.println(c);
		
		writer.println(c);
		writer.close();
		long end=System.currentTimeMillis()-start;
		System.out.println("Time: "+end+" ms");
	}
	public static String f(long n, String word){
		return (n <= word.length()) ? n<=0 ? String.valueOf(word.charAt(word.length()-1)):String.valueOf(word.charAt((int)(n-1))) : (n-(long) (word.length()*Math.pow(2, (int)(Math.floor(Math.log((n-1)/word.length())/Math.log(2))))))==1 ? f(n-1, word) : f((long)(n-1-(long) (word.length()*Math.pow(2, (int)(Math.floor(Math.log((n-1)/word.length())/Math.log(2)))))), word);
	}

}