import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.*;

public class overtime {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner scan=new Scanner(new File("overtime.dat"));
		double pay=0.0, hours=0.0, over=0.0, temp=0.0;
		while(scan.hasNextLine()){
			pay=0.0;
			hours=0.0;
			temp=0.0;
			over=0.0;
		
			String[] s=scan.nextLine().split(" ");
			Double[] num=new Double[7];
			for(int i=0;i<7;i++){
				num[i]=Double.parseDouble(s[i]);
			}
			
			for (int i =0; i < num.length; i++)
			{
				if (i == 0)
				{
					if (num[i] <= 8)
					{
						temp = num[i] * 10.0;
						hours += num[i];
					}
			
					else{
						over = num[i] - 8.0;
						temp = (8.0*10.0) + (over*11.5);
						hours+= num[i];
					}
					
					pay += temp + (.5*temp);
				}
				
				if (i == 6)
				{
					if (num[i] <= 8)
					{
						temp = num[i] * 10.0;
						hours += num[i];
					}
					else{
						over = num[i] - 8.0;
						temp = (8.0*10.0) + (over*9.5);
						hours += num[i];
					}
				
					pay += temp + (temp*1.25);
				
				}
				
				if(i>=1 && i<6){
						if (num[i] <= 8)
						{
							pay += (num[i] * 10.0);
							hours += num[i];
						}
						else
						{
							over = num[i] - 8.0;
							temp = (8.0*10.0) + (over*9.5);
							pay+=temp;
							hours += num[i];
						}
					}
				
				}
				
			if (hours > 40)	
			{
				pay += 2.5*hours-2.5*40;
			}
			System.out.println(pay);
				
			}//while end
			
		}		
		
	}



