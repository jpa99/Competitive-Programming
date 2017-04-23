import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Similar_Dishes {
	static String input="input.txt";
	static String out="output.txt";
	static PrintWriter writer;
	static Scan scan;

	public static void main(String[] args) throws Exception{
		writer=new PrintWriter(new BufferedWriter(new FileWriter(out)));
		Scan scan=new Scan(input);
		int numinputs=scan.nextInt();
		//scan.nextLine();

		for(int cases=1;cases<=numinputs;cases++){
			HashSet<String> str=new HashSet<String>();
			HashSet<String> str2=new HashSet<String>();
			for(String s:scan.nextLine().split(" "))
				str.add(s);
			for(String u:scan.nextLine().split(" "))
				str2.add(u);

			str.retainAll(str2);
			
			String output = str.size() >=2 ? "similar": "dissimilar";
			
			System.out.println(output);
			writer.println(output);
		}
		
		writer.close();
	}
	
	//Optimized Scanner Class, includes next String, int, Long, double, line
	static class Scan{
        BufferedReader br;
        StringTokenizer st;
 
        public Scan(){
            br = new BufferedReader(new InputStreamReader(System.in));     
        }
        
        public Scan(String file) throws IOException{
            br = new BufferedReader(new InputStreamReader(new FileInputStream(file))); 
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
