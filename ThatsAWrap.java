import java.io.File;
import java.util.*;
import java.util.Scanner;

public class ThatsAWrap {

	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(new File("wrap.dat"));
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		String s;
		int num;
		while(scan.hasNextLine()){
			char[] arr=scan.nextLine().toCharArray();
			num=arr[0]-64;
			do{
				if(num<='e'-96){
					num*=2;
				}
				
				else if(num<='j'-96){
					num=(num%3)*5;
				}
				
				else if(num<='o'-96){
					num=(num/4)*8;
				}
				
				else if(num<='t'-96){
					String[] x=String.valueOf(num).split("");
					num=Integer.parseInt(x[0])+Integer.parseInt(x[1]);
					num*=10;
				}
				 
				else if(num<='z'-96){
					for(int i=num/2;i>=1;i--){
						if(num%i==0){
							num=i*12;
							break;
						}
					}
				}
				num%=26;
				
			}while(num>26);
			
			System.out.println(String.valueOf(arr[0])+"==>"+String.valueOf((char)(num+64)));
		}
	}

}
