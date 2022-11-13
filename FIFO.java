import java.util.*;
public class FIFO {
	public static void main(String[] args) {
		int pageHit = 0, pageMiss = 0, p, f, i;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the No. of Pages: ");
		p = sc.nextInt();
		int pages[] = new int[p];
		System.out.println("Enter the pages: ");
		for(i=0; i<p; i++)
		{
			pages[i] = sc.nextInt();
		}
		System.out.println("\nEnter the Frame Size: ");
		f = sc.nextInt();
		int frame[] = new int[f];
		System.out.print("Pages: ");
		for(i=0; i<p; i++)
		{
			System.out.print(pages[i] + " ");
		}
		System.out.print("Frame: ");
		for(i=0; i<f; i++) {
			frame[i] = -1;
			System.out.print(frame[i] + " ");
		}
		int flag = 0;
		int count = 0;
		for(i=0; i<p; i++)
		{
			flag = 1;
			int page = pages[i];
			for(int j=0; j<f; j++)
			{
				if(page == frame[j])
				{
					flag = 0;
					pageHit++;
				}
			}
			if(flag == 1)
			{
				frame[count] = page;
				pageMiss++;
				count++;
				if(count == f) {
					count = 0;
				}
			}
			System.out.print("\n");
			System.out.print("Frame[" + (i+1) + "]: ");
			for(int j=0; j<f; j++) {
				System.out.print("\t" + frame[j]);
			}
		}
		System.out.println("\nPageHit: " + pageHit);
		System.out.println("PageMiss: " + pageMiss);
		float pagefault = (float)pageMiss / p;
		System.out.println("PageFault: " + pagefault);
	}
}
