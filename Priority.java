import java.util.*;
public class PRO {

	public static void main(String[] args) {
		int temp, n, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the No. of Process: ");
		n = sc.nextInt();
		int prior[] = new int[n];
		int tat[] = new int[n];
		int wt[] = new int[n];
		int bt[] = new int[n];
		System.out.println("Enter the CPU Time: ");
		for(i=0; i<n; i++)
		{
			System.out.println("P["+(i+1)+"]: ");
			bt[i] = sc.nextInt();
			System.out.println("Priority: ");
			prior[i] = sc.nextInt();
		}
		for(i=0; i<n-1; i++)
		{
			for(int j=i+1; j<n; j++)
				if(prior[j] > prior[i])
				{
					temp = prior[i];
					prior[i] = prior[j];
					prior[j] = temp;
					temp = bt[i];
					bt[i] = bt[j];
					bt[j] = temp;
				}
		}
		wt[0] = 0;
		for(i=1; i<n; i++)
		{
			wt[i] = wt[i-1] + bt[i-1];
		}
		for(i=0; i<n; i++) {
			tat[i] = wt[i] + bt[i];
		}
		System.out.println("Process\t\t Priority\t BT\t\t WT\t\t TAT");
		for(i=0; i<n; i++)
		{
			System.out.println("P"+(i+1)+"\t\t"+prior[i]+"\t\t"+bt[i]+"\t\t"+wt[i]+"\t\t"+tat[i]);
		}
		float totWT=0, totTAT=0;
		for(i=0; i<n; i++)
		{
			totWT = totWT + wt[i];
			totTAT = totTAT + tat[i];
		}
		System.out.println("Average Waiting Time: "+(totWT/n));
		System.out.println("Average Turn Around Time: "+(totTAT/n));
	}

}
