import java.util.*;
public class RoundRobin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of Process: ");
		n = sc.nextInt();
		int bt[] = new int[n];
		int wt[] = new int[n];
		int tat[] = new int[n];
		int rtime[] = new int[n];
		System.out.println("Enter the CPU time: ");
		for(i=0; i<n; i++) {
			System.out.println("P["+(i+1)+"]: ");
			bt[i] = sc.nextInt();
			rtime[i] = bt[i];
		}
		System.out.println("Enter the Quantum Time: ");
		int q = sc.nextInt();
		int r=n; 
		i=0;
		int time = 0;
		int totwt=0, tottat=0;
		while(r!=0)
		{
			if(rtime[i]>q)
			{
				rtime[i] = rtime[i]-q;
				System.out.print("| P[" + (i+1) + "] |");
				time = time + q;
				System.out.print(time);
			}
			else if(rtime[i]<=q && rtime[i]>0)
			{
				time = time + rtime[i];
				rtime[i] = rtime[i] - rtime[i];
				System.out.print("| P[" + (i+1) + "] |");
				r--;
				wt[i] = time - bt[i];
				totwt = totwt + wt[i];
				tat[i] = time;
				tottat = tottat + tat[i];
				System.out.print(time);
			}
			i++;
			if(i==n)
			{
				i=0;
			}
		}
		System.out.println("\n");
		System.out.println("Process\t\t BT \t\t WT \t\t TAT");
		for(i=0; i<n; i++) {
			System.out.println("P["+(i+1)+"]\t\t" + bt[i]+"\t\t\t"+wt[i]+"\t\t"+tat[i]);
		}
		float avgWT = totwt/n;
		float avgTAT = tottat/n;
		System.out.println("Waiting average time: "+avgWT);
		System.out.println("Turnaround average time: "+avgTAT);
	}

}
