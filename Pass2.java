import java.io.*;
import java.util.*;
public class Pass2 {
	public static void main(String[] args) throws Exception {
		String s;
		String s1[]=new String[100];
		String s2[]=new String[100];
		String s3[]=new String[100];
		BufferedWriter b1 = new BufferedWriter(new FileWriter("machine_code.txt"));
		BufferedReader b2 = new BufferedReader(new FileReader("inter_code.txt"));
		BufferedReader b3 = new BufferedReader(new FileReader("symbol.txt"));
		BufferedReader b4 = new BufferedReader(new FileReader("literal.txt"));
		b1.write("*********** Machine Code ***********\n");
		int m=0;
		while((s=b2.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(s);
			while(st.hasMoreTokens())
			{
				s1[m]=st.nextToken();
				m++;
			}
		}
		
		int m1=0;
		while((s=b3.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(s);
			while(st.hasMoreTokens())
			{
				s2[m1]=st.nextToken();
				m1++;
			}
		}
		int m2=0;
		while((s=b4.readLine())!=null)
		{
			StringTokenizer st=new StringTokenizer(s);
			while(st.hasMoreTokens())
			{
				s3[m2]=st.nextToken();
				m2++;
			}
		}
		for(int i=0;i<m;i++)
		{
			if("R01".equals(s1[i])||"R02".equals(s1[i])||"R03".equals(s1[i])||
			"R04".equals(s1[i]))
			{
				String temp[] = new String[1];
				temp = s1[i].split("0");
				b1.write("\t0"+temp[1]);
				b1.write(" ");
			}
			if("IS".equals(s1[i]))
			{
				b1.write(s1[i-1]+"\t");
				b1.write(s1[i+1]);
			}
			if("L".equals(s1[i]))
			{
				for(int j=0;j<m2;j++)
				{
					if(s1[i+1].equals(s3[j]))
					{
						b1.write("\t");
						b1.write(s3[j+1]+"\n");
					}
				}
			}
			if("S".equals(s1[i]))
			{
				for(int j=0;j<m1;j++)
				{
					if(s1[i+1].equals(s2[j]))
					{
						b1.write("\t");
						b1.write(s2[j+2]+"\n");
					}
				}
			}
			if("DL".equals(s1[i])&&"01".equals(s1[i+1]))
			{ 
				b1.newLine();
				b1.write(s1[i-1]+"\t");
				b1.write("-"+"\t");
				b1.write("-");
				b1.write("\t");
				b1.write("00"+s1[i+3]+"\n");
			}
			if(s1[i].equals("AD") && s1[i+1].equals("02"))
			{
				b1.write(s1[i-1]+"\t");
				b1.write("-"+"\t");
				b1.write("-");
				b1.write("\t");
				b1.write("00"+s1[i+3]+"\n");
			}
		}
		b1.close();
		b2.close();
		b3.close();
		b4.close();
	}
}




/*
symbol.txt
******************* SYMBOL TABLE ***********************
1 L1 201
2 A 209
3 B 210

literal.txt
******************* LITERAL TABLE ***********************
1 =5
2 =4
3 =3
inter_code.txt
******************* INTERMEDIATE TABLE ***********************
AD 01 C 201
201 IS 05 R01 L 1
202 IS 06 R02 S 1
203 IS 05 R03 S 1
204 IS 03 R01 L 2
205 IS 04 R02 L 3
206 AD 04
207 IS 06 R01 S 1
208
209 DL 01
210 DL 02
211 AD 02 C 1
212 AD 02 C 2
213 AD 02 C 3


*/
