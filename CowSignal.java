import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class CowSignal {
	static String name="10";
	public static void main(String[] args) throws Exception{
		PrintWriter writer=new PrintWriter(new BufferedWriter(new FileWriter(name+".out")));
		Scan scan=new Scan(name+".in");
		int r=scan.nextInt(); scan.nextInt();
		int k=scan.nextInt();
		for(int i=0;i<r;i++){
			char[] arr=scan.nextLine().toCharArray();
			for(int a=0;a<k;a++){
				for(char x: arr)
					writer.print(String.join("", Collections.nCopies(k, String.valueOf(x))));
				writer.print("\n");
			}
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
