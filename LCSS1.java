import java.io.*;
import java.util.*;

public class LCSS1{
static List<LinkedList> str_bucket= new ArrayList<LinkedList>();//instance var

  static void input() {
    str_bucket=HASH1.bucket;//copied the whole bucket from HASH1 file 
       
          //sending two same lines of two files/ll 
           for(LinkedList l:str_bucket)
                 for(int i=1;i<l.size();i+=2)//send 2 string from each linked (1,2) (3,4) indexed ll value etc 
                 {
                   String s1=(String)l.get(i);
                   String s2=(String)l.get(i+1);
                  /* System.out.println("s1="+s1);
                   System.out.println("s2="+s2);*/
                   lcss(s1,s2);
                 }//for i
        }//input()

    static void lcss(String s1,String s2)
    {
       int r,c;
       c=s1.length();
       r=s2.length();
      /*
       System.out.println("s1="+s1);
       System.out.println("Lengths1="+c);
       System.out.println("s2="+s2);
       System.out.println("Lengths2="+r);*/
      
      //int [r+1][c+1] a;
      int [][] a= new int[r+1][c+1];//r+1,c+1 because in calc I need to store '0' in first row & column so,
     //initializing as '0' to avoid junk values
     /*for(int i=0;i<=r;i++)
       for(int j=0;j<=c;j++)
         a[i][j]=0;*/
     char[] c1=s1.toCharArray();  
     char[] c2=s2.toCharArray();
     //calc matrix's of lcss
   for(int i=1;i<=r;i++)//s2 as row
     for(int j=1;j<=c;j++)//s1 as column
     {
        if(c2[i-1]==c1[j-1])
            a[i][j]=a[i-1][j-1]+1;
        else
        {
          if(a[i-1][j]>a[i][j-1])
             a[i][j]=a[i-1][j];
          else
             a[i][j]=a[i][j-1];

        }//else if(c1[i-1]==c2[j-1])
     }//for j
//matrix printing
    /*  System.out.println("s1="+s1);
      System.out.println("s2="+s2);
      for(int i=0;i<=r;i++)// commented as to not display the matrix
   {
       for(int j=0;j<=c;j++)
          System.out.print(a[i][j]+"\t");
       System.out.println();
   }*/
   output(r,c,a,s1,s2);
    
    }//lcss()

 static void output(int r,int c,int[][] a,String s1,String s2)
{
  int l1=(int)s1.length();
  int l2=(int)s2.length();
  int s=a[r][c];
  if(l1!=l2)
  {
    System.out.println("Different lines");
    System.out.println("file1:"+s1);
    System.out.println("file2:"+s2);
    System.out.println("");
  }
  else if(l1==l2)
  {
    if(l2!=s)
    {
       System.out.println("Different lines");
       System.out.println("file1:"+s1);
       System.out.println("file2:"+s2);
       System.out.println("");
    }
  }
 /* if(l1==l2){
      if(l2==s)
   
     int u=0;
   }
  else
   {
     System.out.println("Different lines");
     System.out.println("file1:"+s1);
     System.out.println("file2:"+s2);
     System.out.println("");
   }*/

}
 }//class
