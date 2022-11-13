import java.util.Scanner;

public class SJF_self {

	public static void main(String[] args) {
		//Shortest Job First (SJF)
		int n, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Number of Process: ");
		n = sc.nextInt();
		int bt[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		System.out.println("Enter the CPU time: ");
		for(i=0; i<n; i++)
		{
			System.out.println("P[" + (i+1) + "]:");
			
			bt[i] = sc.nextInt();
			
		}
		int j;
		for(i=0; i<n; i++) {
			int a=i;
			for(j=i+1; j<n; j++)
			{
				if(bt[j] < bt[i]) {
					a = j;
				}
			}
			int temp = bt[i];
			bt[i] = bt[a];
			bt[a] = temp;
			
		}
				wt[0] = 0;
				
				for(i=1; i<n; i++)
				{
					wt[i] = wt[i-1] + bt[i-1];
				}
				for(i=0; i<n; i++) {
					tat[i] = wt[i] + bt[i];
				}
				System.out.println("Process \t BT \t\t WT \t\t TAT");
				
				for(i=0; i<n; i++)
				{
					System.out.println("P[" + (i+1) + "] \t\t " + bt[i] + "\t\t" + wt[i] + "\t\t" + tat[i]);
				}
				float tot_wt = 0;
				for(i=0; i<n; i++)
				{
					tot_wt = tot_wt + wt[i];
				}
				System.out.println("Average Waiting Time: " + (tot_wt/n));
				float tot_tat = 0;
				for(i=0; i<n; i++)
				{
					tot_tat = tot_tat + tat[i];
				}
				System.out.println("Average Turn Around Time: " + (tot_tat/n));
	}
}
