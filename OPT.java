import java.util.*;
public class opt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of pages: ");
		int n=sc.nextInt();
		
		
		int pages[]=new int[n];
		
		System.out.println("Enter pages: ");
		for(int i=0;i<pages.length;i++)
		{
			pages[i]=sc.nextInt();
		}
		
		
		System.out.println("Enter size of frame: ");
		int framesize=sc.nextInt();
		
		int frame[]=new int[framesize];
		
		
		System.out.print("\nPages: ");
		for(int i=0;i<pages.length;i++)
		{
			System.out.print(" "+pages[i]);
		}
		
		
		System.out.print("\nFrame: ");
		
		
		for(int i=0;i<frame.length;i++)
		{
			frame[i]=-1;
			System.out.print(" "+frame[i]);
		} 
		System.out.println("\n");
		int pageHit=0,pageMiss=0;
		int array[]=new int[pages.length];

		int flag1,flag2,flag3=0,position=0,max;
		for(int i = 0; i < pages.length; ++i)
		{
			 flag1 = flag2 = 0;
			 for(int j = 0; j < frame.length; ++j)
			 {
				 if(frame[j] == pages[i])
				 {
					 pageHit++;
					 flag1 = flag2 = 1;
					 break;
				 }
			 }
			 if(flag1 == 0)
			 {
				 for(int j = 0; j < frame.length; ++j)
				 {
					 if(frame[j] == -1)
					 {
						 pageMiss++;
						 frame[j] = pages[i];
						 flag2 = 1;
						 break;
					 }
				 }
			 }
			 if(flag2 == 0)
			 {
				 flag3 =0;
				 for(int j = 0; j < frame.length; ++j)
				 {
					 array[j] = -1;
					 for(int k = i + 1; k < pages.length; ++k)
					 {
						 if(frame[j] == pages[k])
						 {
							 //pageHit++;
							 array[j] = k;
							 break;
						 }
					 }
				 }
				 for(int j = 0; j < frame.length; ++j)
				 {
					 if(array[j] == -1)
					 {
						 position = j;
						 flag3 = 1;
						 break;
					 }
				 }
				 if(flag3 ==0)
				 {
					 max = array[0];
					 position = 0;
					 for(int j = 1; j < frame.length; ++j)
					 {
						 if(array[j] > max)
						 {
							 max = array[j];
							 position = j;
						 }
					 }
				 }
				 frame[position] = pages[i];
				 pageMiss++;
			 }
			 System.out.print("Frame["+(i+1)+"]");
			 for(int k=0;k<frame.length;k++)
			 {
				 System.out.print("\t"+frame[k]);
			 }
		 System.out.println();
		 }
		 System.out.println("\nNumber of PageHit: "+pageHit);
		 System.out.println("Number of PageMiss(Page Fault): "+pageMiss);
		 float pagemiss=pageMiss,noofpages=pages.length;
		 System.out.println("Page fault ratio: "+pagemiss/noofpages);
	}

}
