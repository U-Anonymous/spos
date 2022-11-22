import java.io.*;
import java.util.*;
public class Pass2 {
	public static void main(String[] args) throws Exception {
		BufferedReader mot = new BufferedReader(new FileReader("inter_code.txt"));
		 BufferedReader sym = new BufferedReader(new FileReader("symbol.txt"));
		 BufferedReader lit = new BufferedReader(new FileReader("literal.txt"));
		 BufferedWriter mac = new BufferedWriter(new FileWriter("output.txt"));
		 String s,symboltab,literaltab;
		 int m=0;
		 String array[]=new String[4];
		 String array2[]=new String[4];
		 String array3[]=new String[4];
		 mac.write("*********** MOT TABLE ***************\n");
		while((s = mot.readLine())!=null)
		{
			 array=s.split(" ");
			 if(array.length>2 && array[0].equals("AD")!=true) 
			 {
				 mac.write(array[0]);
				 mac.write(" " + array[2]);
				 if(array.length>=4)
				 {
					 mac.write(" "+array[3]);
					 
					 if(array[4].equals("L"))
					 {
						 while((literaltab=lit.readLine())!=null)
						 {
							 array3=literaltab.split(" ");
							 if(array3.length>0) {
								 mac.write(" "+ array3[1]);
							 }
							 break;
						 }
					 }
					 
					 if(array[4].equals("S"))
					 {
						 while((symboltab=sym.readLine())!=null)
						 {
							 array2=symboltab.split(" ");
							 if(array2.length>0) {
								 mac.write(" "+ array2[1]);
							 }
							 break;
						 }
					 }
				 }
				 mac.newLine();
			}
		}
		mac.close();
	}
}





/*
symbol.txt
L2 200 
A 207 
B 208


literal.txt
1 =7
2 =5


inter_code.txt
AD 01 C 200
200 IS 05 RG1 L 1
201 IS 06 RG2 S 1
202 IS 03 RG1 L 2
203 AD 04
204 IS 06 RG1 S 1
205
206 IS 02
207 DL 01
208 DL 02
AD 02 C 1
AD 02 C 2


*/
