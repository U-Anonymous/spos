import java.util.*;
public class FCFS2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the No. of Process: ");
		n = sc.nextInt();
		int bt[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		System.out.println("Enter the CPU time: ");
		for(i=0; i<n; i++)
		{	
			System.out.println("P[" + (i+1) + "]: ");
			bt[i] = sc.nextInt();
		}
		wt[0]=0;
		for(i=1; i<n; i++)
		{
			wt[i] = wt[i-1] + bt[i-1];
		}
		for(i=0; i<n; i++)
		{
			tat[i] = wt[i] + bt[i];
		}
		System.out.println("Process\t\t WT \t\t BT\t\t TAT");
		for(i=0; i<n; i++)
		{
			System.out.println("P[" + (i+1) + "]\t\t" + wt[i] + "\t\t" + bt[i] + "\t\t" + tat[i]);	
		}
		float tot_wt=0, tot_tat=0;
		for(i=0; i<n; i++)
		{
			tot_wt = tot_wt + wt[i];
			tot_tat = tot_tat + tat[i];
		}
		System.out.println("Average Waiting Time: "+(tot_wt/n));
		System.out.println("Average Turn Around Time: "+(tot_tat/n));	
	}

}
