import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Share_Dropping {
	static String input="input.txt", out="output.txt";
	static Scan scan;
	//don't forget to change input to STDIN before submitting
	public static void main(String[] args) throws Exception{
		Scan scan=new Scan();
		int n=scan.nextInt();
		int k=scan.nextInt();

		int[] share=new int[n];
		for(int i=0;i<n;i++){
			share[i]=scan.nextInt();
		}
		long num=0;
		boolean impos=false;
		Arrays.sort(share);
		int min=share[0];
		for(int i=0;i<n;i++){
			int d=share[i]-min;
			if(d%k!=0){
				impos=true;
				break;
			}
			num+=d/k;
				
		}
		if(impos){
			System.out.println(-1);
		}else{
			System.out.println(num);
		}
		
	}
	public static boolean q(int[] s){
		for(int i=1;i<s.length;i++){
			if(s[i]!=s[i-1])
				return false;
		}
		return true;
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
