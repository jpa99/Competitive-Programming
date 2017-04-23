import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;

public class String_Shifting {
	static String input="input.txt";
	static String out="output.txt";
	static PrintWriter writer;
	static Scan scan;
	static int arr[][];

	public static void main(String[] args) throws Exception{
		Scan scan=new Scan(input);
		int numinputs=scan.nextInt();
		ArrayList<String> s=new ArrayList<String>();
		String[] str=new String[numinputs];
		for(int cases=0;cases<numinputs;cases++){
			str[cases]=scan.nextLine();
			s.add(str[cases]);
		}	
		
		String minlcs=str[0];
		for(int i=0;i<str.length;i++){
			for(int j=0;j<str.length;j++){
				minlcs=lcs(str[j], minlcs);
				System.out.println(minlcs);
			}
		}
		System.out.println(minlcs);
		
		//xzzwo
		//zzwox
		//---> zzwox
		//woxzz
		
		int ops=0;
		int past=1;
		while(!s.isEmpty()){
			String a= s.get(0), b=s.get(1);
			String lcs=lcs(s.get(0), s.get(1));
			int ind=a.indexOf(lcs);
			ops+=ind+b.indexOf(lcs);
			String n=a.substring(ind)+a.substring(0, ind);
			s.remove(0);
			s.set(0, n);
			past++;
		}
		
			
		System.out.println();
	}
	
	static Set<String> lcs(String s1, String s2, int len1, int len2) {
	    if (len1 == 0 || len2 == 0) {
	        Set<String> set = new HashSet<String>();
	        set.add("");
	        return set;
	    }
	    if (s1.charAt(len1 - 1) == s2.charAt(len2 - 1)) {
	        Set<String> set = lcs(s1, s2, len1 - 1, len2 - 1);
	        Set<String> set1 = new HashSet<>();
	        for (String temp : set) {
	            temp = temp + s1.charAt(len1 - 1);
	            set1.add(temp);
	        }
	        return set1;
	    } else {
	        Set<String> set = new HashSet<>();
	        Set<String> set1 = new HashSet<>();
	        if (arr[len1 - 1][len2] >= arr[len1][len2 - 1]) {
	            set = lcs(s1, s2, len1 - 1, len2);
	        }
	        if (arr[len1][len2 - 1] >= arr[len1 - 1][len2]) {
	            set1 = lcs(s1, s2, len1, len2 - 1);
	        }
	        for (String temp : set) {
	            set1.add(temp);
	        }
	        //System.out.println("In lcs" + set1);
	        return set1;

	    }
	}
	
	public static String lcs(String a, String b) {
	    int[][] lengths = new int[a.length()+1][b.length()+1];
	 
	    // row 0 and column 0 are initialized to 0 already
	 
	    for (int i = 0; i < a.length(); i++)
	        for (int j = 0; j < b.length(); j++)
	            if (a.charAt(i) == b.charAt(j))
	                lengths[i+1][j+1] = lengths[i][j] + 1;
	            else
	                lengths[i+1][j+1] =
	                    Math.max(lengths[i+1][j], lengths[i][j+1]);
	 
	    // read the substring out from the matrix
	    StringBuffer sb = new StringBuffer();
	    for (int x = a.length(), y = b.length();
	         x != 0 && y != 0; ) {
	        if (lengths[x][y] == lengths[x-1][y])
	            x--;
	        else if (lengths[x][y] == lengths[x][y-1])
	            y--;
	        else {
	            assert a.charAt(x-1) == b.charAt(y-1);
	            sb.append(a.charAt(x-1));
	            x--;
	            y--;
	        }
	    }
	 
	    return sb.reverse().toString();
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
