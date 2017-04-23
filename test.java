import java.util.HashMap;

public class test {

	public static void main(String[] args) {
		int i;
		Character.toChars(1);
		int num='G'-64;
		char b=(char)(num+64);
		System.out.println(156%26);
		
		
		
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
