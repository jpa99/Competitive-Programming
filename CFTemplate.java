import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class CFTemplate {
	static String input="input.txt", out="output.txt";
	static Scan scan;
	//don't forget to change input to STDIN before submitting
	public static void main(String[] args) throws Exception{
		Scan scan=new Scan(input);
		int numinputs=scan.nextInt();
		//scan.nextLine();

		for(int cases=0;cases<numinputs;cases++){
			String s=scan.nextLine();
			
			
			System.out.printf(s);
		}

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
