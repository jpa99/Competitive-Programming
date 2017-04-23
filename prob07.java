import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class prob07 {

	public static void main(String[] args)throws Exception {
		Scanner scan = new Scanner (new File("prob07-1-in.txt"));
		String a, b, c, common="";
		
		
		int num=Integer.parseInt(scan.nextLine());
		for(int k=0;k<num;k++){
			a=scan.next();
			b=scan.next();
			c=scan.next();
			for(int i=0;i<a.length();i++){
				if(has(a.substring(i, i+1), b, c)){
					common+=a.substring(i, i+1);
				}
			}
			ArrayList<String> arr=new ArrayList<String>();
			for(int j=0;j<common.length();j++){
				for(int l=0;l<arr.size();l++){
				}
			}
			
			
			
			
			
			
			System.out.println(common);
		}

	}
	
	
	public static boolean has(String character, String b, String c){
		boolean first=false, second=false;
		for(int i=0;i<b.length();i++){
			if(character.equals(b.substring(i, i+1))){
				first=true;
			}
		}
		for(int i=0;i<c.length();i++){
			if(character.equals(c.substring(i, i+1))){
				second=true;
			}
		}
		return first && second;
	}


}
