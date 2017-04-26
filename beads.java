/*
LANG: JAVA
PROB: beads
*/
import java.util.*;
import java.util.List;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class beads {
	static String input="beads.in", out="beads.out";

	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(out)));
		Scan scan=new Scan(input);
		scan.nextLine();
		char[] neck=scan.nextLine().toCharArray();
		int n=neck.length;
		int max=0;
		for(int numtimes=0;numtimes < n;numtimes++){
			int x=num(neck);
			max=Math.max(max, x);
			char temp=neck[n-1];
			for (int i = n-1; i > 0; i--) {                
			    neck[i] = neck[i-1];
			}
			neck[0]=temp;
		}
		
		if(max > n){
			max=n;
		}
		System.out.println(max);
		writer.println(max);
		writer.close();
	}
	public static int num(char[] neck){
		int n=neck.length;
		char right = ' ', left = ' ';
		int rin=0, lin=0;
		for (int i = 0; i < neck.length; i++) {
			if(neck[i]!='w' && right==' '){
				right=neck[i];
			}
			if(neck[n-i-1]!='w' && left==' '){
				left=neck[n-i-1];
			}
		}
		int ri=0, le=0;
		for (int i = 0; i < neck.length; i++) {
			if((neck[i]=='w' || neck[i]==right) && ri==i){
				ri++;
			}
			if((neck[n-i-1]=='w' || neck[n-i-1]==left) && le==i){
				le++;
			}
		}
		return ri+le;
	}
	
	//Optimized Scanner Class, includes next String, int, Long, double, line
	static class Scan{
		        BufferedReader br;
		        StringTokenizer st;
		 
		        public Scan(String file) throws IOException{
		            br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
		            
		        }
		 
		        public Scan() throws IOException{
		            br = new BufferedReader(new InputStreamReader(System.in));
		        }
		        
		        String next(){
		            while (st == null || !st.hasMoreElements()){
		                try{
		                    st = new StringTokenizer(br.readLine());
		                }
		                catch (IOException  e){
		                    e.printStackTrace();
		                }
		            }
		            return st.nextToken();
		        }
		 
		        int nextInt(){
		            return Integer.parseInt(next());
		        }
		 
		        long nextLong(){
		            return Long.parseLong(next());
		        }
		 
		        double nextDouble(){
		            return Double.parseDouble(next());
		        }
		 
		        String nextLine(){
		            String str = "";
		            try{
		                str = br.readLine();
		            }
		            catch (IOException e){
		                e.printStackTrace();
		            }
		            return str;
		        }
		    }

}
