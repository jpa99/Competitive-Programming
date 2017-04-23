import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Stable_Neighbors {
	static String input="input.txt", out="output.txt";

	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(out)));
		Scanner scan=new Scanner(new File(input));
		int numinputs=scan.nextInt();
		for(int cases=1;cases<=numinputs;cases++){
			int n = scan.nextInt();
			int[] uni=new int[3];
			uni[0]=scan.nextInt();
			scan.nextInt();
			uni[1]=scan.nextInt();
			scan.nextInt();
			uni[2]=scan.nextInt();
			scan.nextInt();
			
			StringBuilder s=new StringBuilder();
			
			boolean poss=true;
			for( int i=0;i<uni.length;i++){
				if(uni[i] > n/2){
					poss=false;
					break;
				}
			}
			if(!poss){
				System.out.printf("Case #%s: IMPOSSIBLE0\n", cases);
				writer.printf("Case #%s: IMPOSSIBLE\n", cases);
				continue;
			}
			
			String ans="";
			while(uni[0]>0 && uni[1] >0 && uni[2]>0){
				s.append("RYB");
				uni[0]--;
				uni[1]--;
				uni[2]--;
			}
			
			if(uni[0]==0){
				while(uni[1] > 0 && uni[2]>0){
					s.append("YB");
					uni[1]--;
					uni[2]--;
				}
				
				if(uni[1]==0){
					ans=fillIn(s, 'B', uni[2]).toString();
				}else{
					ans=fillIn(s, 'Y', uni[1]).toString();
				}
				
			}
			else if(uni[1]==0){
				while(uni[0] >0 && uni[2]>0){
					s.append("RB");
					uni[0]--;
					uni[2]--;
				}
				
				if(uni[0]==0){
					ans=fillIn(s, 'B', uni[2]).toString();
				}else{
					ans=fillIn(s, 'R', uni[0]).toString();
				}
				
			}else{
				while(uni[0] >0 && uni[1]>0){
					s.append("RY");
					uni[0]--;
					uni[1]--;
				}
				
				if(uni[0]==0){
					ans=fillIn(s, 'Y', uni[1]).toString();
				}else{
					ans=fillIn(s, 'R', uni[0]).toString();
				}
			}
			
			if(ans.equals("IMPOSSIBLE")){
				System.out.printf("Case #%s: %s\n", cases, ans);
				writer.printf("Case #%s: %s\n", cases, ans);
				continue;
			}
				
			if(ans.charAt(0) == ans.charAt(ans.length()-1)){
				char x = ans.charAt(ans.length()-1);
				ans=ans.substring(0, ans.length()-1);
				ans = fillIn(new StringBuilder(ans), x, 1).toString();
			}
			
			System.out.printf("Case #%s: %s\n", cases, ans);
			writer.printf("Case #%s: %s\n", cases, ans);
		}
		
		writer.close();
	}
	
	public static String copy(String str, int n){
		StringBuilder s=new StringBuilder(str);
		for(int i=1;i<n;i++)
			s.append(str);
		
		return s.toString();
	}
	
	public static StringBuilder fillIn(StringBuilder str, char c, int n){
		for(int i=str.length()-1;i>0 && n>0;i--){
			if(str.charAt(i-1)!=c && str.charAt(i)!=c){
				str.insert(i, c);
				i++;
			}
		}
		if(n > 0){
			if(str.charAt(0)!=c && str.charAt(str.length()-1)!=c){
				str.insert(0, c);
			}
		}
		if(n==0)
			return str;
		else
			return new StringBuilder("IMPOSSIBLE3");
	}
}

/*
 


 RYBRYBRYB-- 
 
 
 1 1 1    RYB
 1 1 2    RBYB
 1 2 1    
 2 1 1
 1 2 3  0    0 0 1
 
RBYBYB
 
 1. ADD RYB
 2. ADD YB, RB, RY
 3. FILL IN R, Y, B
 
 
 IMPOSSIBL IF # OF A > N/2
 
 N=3 
 

*/





