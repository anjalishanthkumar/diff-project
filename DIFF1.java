//package diff1;
import java.util.*;
import java.io.*;
public class DIFF1 {
    static int bucket_size=13;
    public static void main(String[] args)  throws IOException{
         String[] arg=new String[10] ;
                 Scanner sc=new Scanner(System.in); 
                 arg[0]=sc.next();
                 arg[1]=sc.next();
       /*Scanner sc1=new Scanner(System.in); 
      bucket_size=sc1.nextInt();*/
                 HASH1.input(arg);
                 LCSS1.input();

    }
}

