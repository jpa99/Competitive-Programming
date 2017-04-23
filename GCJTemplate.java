import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class GCJTemplate {
	static String input="input.txt", out="output.txt";

	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(out)));
		Scan scan=new Scan(input);
		int numinputs=scan.nextInt();
		//scan.nextLine();

		for(int cases=1;cases<=numinputs;cases++){
			String asdf=scan.nextLine();
			
			
			System.out.printf("Case #%s: %s\n", cases, asdf);
			writer.printf("Case #%s: %s\n", cases, asdf);
		}
		
		writer.close();
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
