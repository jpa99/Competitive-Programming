import java.io.File;
import java.util.*;
public class DryRun {

	public static void main(String[] args) throws Exception{
		Scanner scan=new Scanner(new File("dryrun.dat"));
		int n=Integer.parseInt(scan.nextLine());
		for(int i=0;i<n;i++){
			System.out.println("I like "+scan.nextLine()+".");
		}
	}

}
