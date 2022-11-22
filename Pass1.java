import java.io.*;
import java.util.*;

public class mayurpass1 {

	public static void main(String[] args) throws IOException {
		
		int loc=0, j=0, sym=0, lit=0, v=0;
		String s, sl; 
		String s1[] = new String[4];
		String s2[] = new String[4];
		String s5[][] = new String [4][2];
		
		BufferedReader b1 = new BufferedReader(new FileReader("assembly.txt"));
		BufferedWriter b3 = new BufferedWriter(new FileWriter("symbol.txt"));
		BufferedWriter b4 = new BufferedWriter(new FileWriter("inter_code.txt"));
		BufferedWriter b5 = new BufferedWriter(new FileWriter("literal.txt"));
		
		b3.write("#### SYMBOL TABLE ####\n");
		b4.write("#### INTERMEDIATE TABLE ####\n");
		b5.write("#### LITERAL TABLE ####\n");
		
		while((s=b1.readLine())!=null)
		{
			int flag = 0, m = 0;
			StringTokenizer st = new StringTokenizer(s);
			
			while(st.hasMoreTokens()) 
			{
				s1[m] = st.nextToken(); 
				m++;
			}
			if(s1[1].equals("START"))
			{
				b4.write("AD  01  ");
				b4.write("C  "+s1[2]+"\n");
				loc = Integer.parseInt(s1[2]);
				b4.newLine();
			}
			else if(s1[1].equals("END")) 
			{
				for(int i=1;i<=lit;i++)
				{
					b4.write(loc+"  AD  02  ");
					b4.write("C  "+i);
					loc = loc + 1;
					b4.newLine();
				}
			}
			else 
			{	
				b4.write(loc + "");
				if(s1[0].equals("-")!= true)
				{
					sym++;
					b3.write(sym +" "+s1[0]+" "+loc);
					b3.newLine();
				}
			}
			BufferedReader b2 = new BufferedReader(new FileReader("opcode.txt"));
			while((sl=b2.readLine())!=null) 
			{
				j=0;
				StringTokenizer se = new StringTokenizer(sl);
				while(se.hasMoreTokens()) {
					s2[j] = se.nextToken();
					j++;
				}
				if(s1[1].equals(s2[0])== true) {
					for(int a=1;a<3;a++) {
						b4.write("  "+s2[a]);
					}
				}
				if(s1[2].equals(s2[0])==true)
				{
					for(int a=1;a<2;a++) 
					{
						b4.write("  "+s2[a]);
					}
				}
			}
			if(s1[3]!=null) 
			{
				if(s1[3].contains("="))
				{
					int i; 
					flag=0;
					for (i=0;i<lit;i++)
					{
						if(s5[i][1].equals(s1[3]))
						{
							flag=1;
							break;
						}
					}
					if(flag!=1) {
						lit++;
						s5[v][0] = Integer.toString(lit);
						s5[v][1]=s1[3];
						v++;
						b5.write(lit+" "+s1[3]);
						b5.newLine();
						b4.write("  "+"L "+lit);
					}
					else {
						b4.write("  ");
						b4.write("L "+s5[i][0]);
					}
				}
				else if((s1[3]).matches("[a-zA-Z]")) {
					b4.write("  ");
					b4.write("S "+sym);
				}
				loc = loc+1;
				b4.newLine();
				b4.newLine();
			}	
			b2.close();
		}
		b1.close();
		b3.close();
		b4.close();
		b5.close();			
	}
}


/*
assembly.txt
- START 100
L1 MOVER AREG =3
- MOVEM BREG X
- SUB AREG =1
- LTORG
- MOVEM AREG Y
- BC any L1
- ADD CREG,4
X DC 6
Y DS 2
- END

Opcode.java
STOP IS 01
ADD IS 02
SUB IS 03
MUL IS 04
MOVER IS 05
MOVEM IS 06
START AD 01
END AD 02
ORIGIN AD 03
LTORG AD 04
AREG R1
BREG R2
CREG R3
DREG R4
DC DL 01
DS DL 02

/*
