// Java Program to illustrate reading from FileReader 
// using BufferedReader 
import java.io.*; 
public class Connect 
{ 
    public static void main(String[] args)throws Exception 
    { 
    // We need to provide file path as the parameter: 
    // double backquote is to avoid compiler interpret words 
    // like \test as \t (ie. as a escape sequence) 
    File file = new File("/dev/ttyACM0"); 

    BufferedReader br = new BufferedReader(new FileReader(file)); 

    String st; 
    while ((st = br.readLine()) != null) 
        System.out.println(st); 
    } 
} 
