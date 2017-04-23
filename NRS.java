import java.io.File;
import java.util.*;
public class NRS {

	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(new File("nrs.dat"));
		String name, rank, number;
		String[] s;
		while(scan.hasNextLine()){
			s=scan.nextLine().split(" ");
			System.out.println("My name is "+s[0]+" "+ s[1]+", "+s[2]+",\nserial number "+words(s[3])+"!");
		}
	}
	
	public static String words(String n){
		String q="";
		String[] num=n.split("");
		HashMap<String, String> map=new HashMap<String, String>();
		map.put("1",  "one");
		map.put("2",  "two");
		map.put("3",  "three");
		map.put("4",  "four");
		map.put("5",  "five");
		map.put("6",  "six");
		map.put("7",  "seven");
		map.put("8",  "eight");
		map.put("9",  "nine");
		map.put("0",  "zero");
		for(int i=0;i<num.length;i++){
			if(i==4){
				q+=map.get(num[i]);
			}
			else{
				q+=map.get(num[i])+" ";
			}
		}
		return q;
	}

}
