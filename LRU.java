import java.util.*;
public class opt {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter no of pages: ");
		int n=sc.nextInt();
		
		
		int page[]=new int[n];
		
		System.out.println("Enter pages: ");
		for(int i=0;i<page.length;i++)
		{
			page[i]=sc.nextInt();
		}
		
		
		System.out.println("Enter size of frame: ");
		int framesize=sc.nextInt();
		
		int frame[]=new int[framesize];
		
		
		System.out.print("\nPages: ");
		for(int i=0;i<page.length;i++)
		{
			System.out.print(" "+page[i]);
		}
		
		
		System.out.print("\nFrame: ");
		
		
		for(int i=0;i<frame.length;i++)
		{
			frame[i]=-1;
			System.out.print(" "+frame[i]);
		} 
		System.out.println("\n");
		int flag=0,pageHit=0,pageMiss=0;
		 
		 
		 int array[]=new int[frame.length];
		 for(int i=0;i<frame.length;i++)
			 array[i]=0;
		 
		 
		 for(int j=0,i=0; j<frame.length && i<page.length; j=j%frame.length, i++)
		 {
			 flag=0;
			 for(int x=0;x<frame.length;x++)
			 {
				 if(frame[x]==page[i])
				 {
					 flag=1;
					 pageHit++;
					 array[x]=0;
				 }
			 }
			 if(flag==0)
			 if(frame[j]==-1)
			 {
				 frame[j]=page[i];
				 pageMiss++;
//				 rear++;
				 j++;
			 }
			 else
			 {
				 int max=array[0],loc=0;
				 pageMiss++;
				 for(int b=0;b<frame.length;b++)
				 if(array[b]>max)
				 {
					 max=array[b];loc=b;
				 }
				 frame[loc]=page[i];
				 array[loc]=0;
				 j++;
			 }
			 System.out.print("Frame["+(i+1)+"]: ");
			 for(int k=0;k<frame.length;k++)
			 System.out.print("\t"+frame[k]);
			 System.out.println();
			 for(int a=0;a<frame.length;a++)
			 {
				 if(frame[a]==-1)
				 array[a]=0;
				 else
				 array[a]++;
			 }
		 }
		 System.out.println("\nNumber of PageHit: "+pageHit);
		 System.out.println("Number of PageMiss(Page Fault): "+pageMiss);
		 float pagemiss=pageMiss,noofpages=page.length;
		 System.out.println("Page fault ratio: "+pagemiss/noofpages);
	}

}
