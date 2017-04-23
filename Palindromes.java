import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class Palindromes {
	static String input="input.txt";
	static String out="output.txt";
	static PrintWriter writer;
	static Scan scan;

	public static void main(String[] args) throws Exception{
		writer = new PrintWriter(new BufferedOutputStream(System.out));
		char[] s=new Scan().nextLine().toCharArray();
		int num=0;
		for(int i=0;i<s.length/2;i++){
			if(s[i]!=s[s.length-i-1])
				num++;
			if(num>1)
				break;
		}
		if(num==1)
			writer.println("YES");
		else if(num==0 && !div2(s.length))
			writer.println("YES");
		else
			writer.println("NO");
		writer.close();
	}
	
	public static boolean div2(int n){
		return (n & 1) == 0 && n!=0;
	}
	
	//Print line
	public static <T> void print(T t){
		   System.out.println(t);
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
