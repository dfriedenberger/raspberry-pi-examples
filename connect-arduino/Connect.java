// Java Program to illustrate reading from FileReader 
// using BufferedReader 
import java.io.*; 
public class Connect extends Thread
{ 

    private final String device;
    public Connect(String device) 
    { 
        this.device =device;
    }

    public void run()
    {
        File file = new File(device); 
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(file)); 

            String st; 
            while ((st = br.readLine()) != null) 
                System.out.println(st); 
            
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally 
        {
            if(br != null)
            try {
                	br.close();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void send(String cmd) {
        try {
        /* Process p = */ Runtime.getRuntime().exec(new String[]{"echo", cmd, device });
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args)throws Exception 
    { 
       Connect connect = new Connect("/dev/ttyACM0");
       connect.start();
       while(true)
       {
          Thread.sleep(10000);
          connect.send("ON");
          Thread.sleep(10000);
          connect.send("OFF");
       }
    }

   
} 
