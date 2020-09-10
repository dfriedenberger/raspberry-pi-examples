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

            System.out.println("Current java version is: " + System.getProperty("java.version"));

            File file = new File(device); 

            String str = cmd+"\n";
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(str);
            
            writer.close();

            /*
            ProcessBuilder pb =
                    new ProcessBuilder("/bin/echo", cmd, ">" , device);

            System.out.println("Command is: " + pb.command());
        
            Process proc = pb.start();
        
            InputStream in = proc.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
        
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        
            int exitValue = proc.exitValue();
            System.out.println("Exit value: " + exitValue);
*/

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
