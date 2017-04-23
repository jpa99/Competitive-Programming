import java.io.File;
import java.util.*;
public class PaliNum {

	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(new File("pal.dat"));
		int s;
		while(scan.hasNextLine()){
			int i, k=0;
			s=Integer.parseInt(scan.nextLine());
			while(s!=reverseNum(String.valueOf(s)) && k<5){
				s+=reverseNum(String.valueOf(s));
				k++;
			}
			System.out.println(s);
			
		}
		
	}
	
	public static int reverseNum(String s){
		String q="";
		String[] num=s.split("");
		for(int i=0;i<num.length;i++){
			q+=num[num.length-i-1];
		}
		return Integer.parseInt(q);
	}

}
