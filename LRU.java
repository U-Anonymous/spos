import java.util.*;
public class LRU {

	public static void main(String[] args) {
		//LRU - List Recent Use
		
		int pageHit=0, pageMiss=0;
		
		int p, f, i, j;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter the no. of Pages: ");
		p = sc.nextInt();
		
		int pages[] = new int[p];
		
		System.out.println("Enter the pages: ");
		for(i=0; i<p; i++)
		{
			pages[i] = sc.nextInt();
		}
		
		//frame
		System.out.println("Enter the size of frame: ");
		f = sc.nextInt();
		
		int frames[] = new int[f];
		int newFrame[] = new int[f];
		
		//frame -1 and newFrame 0
		for(i=0; i<f; i++)
		{
			frames[i] = -1;
			newFrame[i] = 0;
		}
		
		int flag;
		
		for(i=0, j=0; j<f && i<p; j=j%f, i++)
		{
			
			flag=0;
			
			for(int x=0; x<f; x++)
			{
				if(frames[x] == pages[i])
				{
					flag = 1;
					pageHit++;
					newFrame[x] = 0;
				}
			}
			
			if(flag==0)
			if(frames[j] == -1) {
				frames[j] = pages[i];
				pageMiss++;
				j++;
			}
			else
			{
				int max = newFrame[0], loc=0;
				pageMiss++;
				for(int b=0; b<f; b++)
				{
					if(newFrame[b]>max)
					{
						max = newFrame[b];
						loc=b;
					}
				}
				
				frames[loc] = pages[i];
				newFrame[loc] = 0;
				j++;
			}
			
			System.out.print("Frame["+(i+1)+"]: ");
			for(int k=0; k<f; k++)
			{
				System.out.print("\t"+frames[k]);
			}
			
			System.out.println();
			for(int a=0; a<f; a++)
			{
				if(frames[a] == -1)
				{
					newFrame[a] = 0;
				}
				else
				{
					newFrame[a]++;
				}
			}
		}
		
		System.out.println("\nNumber of PageHit: "+pageHit);
		System.out.println("Number of PageMiss (Page Fault): "+pageMiss);
		float Miss = pageMiss, noofpages=p;
		System.out.println("Page fault ratio: "+Miss/noofpages);
		
		
	}

}
