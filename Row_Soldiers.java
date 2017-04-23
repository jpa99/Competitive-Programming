import java.util.*;
import java.io.*;
import java.time.*;
import java.math.*;
import java.awt.*;
 
public class Row_Soldiers {
 
	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(new File("input.txt"));
		int numinputs=scan.nextInt();
		for(int cases=1;cases<=numinputs;cases++){
			String row=scan.next().replaceFirst("^0+(?!$)", "")+"1";
			int count=0;
			while(row.contains("0")){
				int index=row.indexOf('0');
				String sol=row.substring(0, index); 
				String fin=row.substring(index).replaceFirst("^0+(?!$)", "");
				count+=(sol.length()*(row.length()-(--index)-fin.length()));
				row=sol+fin;
			}
			System.out.println(count);
		}
	}
 
}