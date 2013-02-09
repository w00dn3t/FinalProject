import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class SystemMain {
	public static void main(String[] args){
		Socket sock = null;
        PrintWriter out = null;
        BufferedReader in = null;
 
        try {
        	sock = new Socket("horsetamer.no-ip.org", 7777);
            out = new PrintWriter(sock.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            System.err.println("Successful connect!");
        } catch (UnknownHostException e) {
            System.err.println("Couldn't connect to horsetamer.no-ip.org on port 7777");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to: taranis.");
            System.exit(1);
        }
        
        LoginUI loginScr = new LoginUI(out, in);
        
        
        
	}

}
