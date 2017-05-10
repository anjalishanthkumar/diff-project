//package diff1;
import java.io.*;
import java.util.*;
public class HASH1 {
    static List<LinkedList> bucket = new ArrayList<LinkedList>();//instance var
    static
    {
        for (int j=0; j<DIFF1.bucket_size; j++)
            bucket.add(new LinkedList());
        for(LinkedList s:bucket)
            s.add(1);
    }//static block
    static void input(String arg[]) throws  IOException
    {
        String file1,file2;
                 FileInputStream fin1=null;
                 FileInputStream fin2=null;
                 file1= "/home/anjali/"+arg[0];
                 file2= "/home/anjali/"+arg[1];
                 fin1=new FileInputStream(file1);    
                 BufferedReader br1= new BufferedReader(new InputStreamReader(fin1)); 
                 fin2=new FileInputStream(file2);    
                 BufferedReader br2= new BufferedReader(new InputStreamReader(fin2));                   
                 String file_1L, file_2L;//file line var
                 int count=0;
                 
                 //Read 2 files one by one where each file as Line By Line
                 while (((file_1L = br1.readLine()) != null)  && ((file_2L = br2.readLine()) != null))
                 {
                    hash(file_1L,file_2L);
                     //System.out.println ("file1:"+file_1L); 
                     //System.out.println ("file2:"+file_2L);
                }//while
                 
                 //Remaining extra lines in files 
                 if(file_1L==null)
                while( (file_2L = br2.readLine()) != null)
                    //REDIRECT TO OUTPUT FILE
                    System.out.println("Remain file2:"+file_2L);
                 
                  while(file_1L!=null)
                 {
                     //REDIRECT TO OUTPUT FILE
                     System.out.println("Remain file1:"+file_1L);
                     file_1L = br1.readLine();
                 }//while
    }//input
    
     static void hash(String s1,String s2) throws  IOException
     {
         int bucket_size=DIFF1.bucket_size;// from FILE1 file
       int line_number=0; 
       byte [] b;//to get the ASCII value of line(each letter ASCII code)
       int sum,hash_v_1 = 0,hash_v_2 = 0;//hash/mod performed value for both file lines
        //loop runs twice,as having two strings(which has to do same task so...)
       for(int i=0;i<2;i++)// 2 as always two only s1 s2
       {
           sum=0;
           if(i==0){
               b=s1.getBytes(); //string s1(file1)
               //System.out.println("file1:"+s1);
           }
           else{
               b=s2.getBytes(); //string s2(file2)
               //System.out.println("file2:"+s2);
           }
           
       for(int j=0;j<b.length;j++){
           sum=sum+b[j];
          //System.out.println("byte:"+b[j]);
       }
       //performing mod(hashing technique)
        if(i==0)
            hash_v_1=sum%bucket_size;
        else
            hash_v_2=sum%bucket_size;
       }//for i
       
       //placing value in the bucket(ArrayList<linkedlist>)
        //NOTE: placing the two file lines in bucket, which are having same hash value only
        //comparing the abjacent linkedlist index's in LCSS
        if(hash_v_1==hash_v_2)
        {
            // System.out.println("hash_v_1:"+hash_v_1+"hash_v_2:"+hash_v_2);
            LinkedList ll=new LinkedList();
            ll=bucket.get(hash_v_1);//particular linkedlist
            
            //incrementing the linkedlist first value(that will be the bucket value) 
            int inc=(int)ll.get(0);
            //System.out.println("inc:"+inc);//previous value of first index of linkedlist
            ll.set(0,(inc+=2));
            // System.out.println("inc linkedlist:"+(ll.get(0)));//inc value of first index of linkedlist
           
            //adding to the particular linkedlist
            ll.addLast(s1);
            ll.addLast(s2);
            
        }//if(hash_v_1==hash_v_2)
        else
        {
            //REDIRECT TO OUTPUT FILE
            System.out.println("Lines not same");
            System.out.println("file1 line:"+s1);
            System.out.println("file2 line:"+s2);
            System.out.println("");
           
        }//else (hash_v_1==hash_v_2)
        
        /* //printing hash bucket
         System.out.println("no of linkedlist:"+(bucket.size()));
            for(LinkedList l:bucket)
            {
                for(int i=0;i<l.size();i++)
                   System.out.println("values:"+l.get(i));
                System.out.println("next");
            }*/

        
     }//hash
     
}
