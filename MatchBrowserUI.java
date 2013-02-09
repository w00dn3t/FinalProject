import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;
import javax.swing.text.DefaultCaret;

public class MatchBrowserUI {
  	JFrame frameMain = new JFrame("Match Browser");
  	JTextArea userTextArea = new JTextArea();
  	JLabel userLabel = new JLabel("Users");
  	boolean check = true;
	String outLine = "";

	public MatchBrowserUI(final PrintWriter out, final BufferedReader in) throws IOException {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frameMain.setSize(500, 500);
		frameMain.setVisible(true);
		frameMain.setLayout(layout);
		
		//Add elements
		userTextArea.setSize(100,100);
		c.gridx = 0; c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;

		frameMain.add(userLabel, c);
		
		
		c.gridx = 0; c.gridy = 1;
		c.ipady = 200;
		c.ipadx = 100;
		userTextArea.setBorder(BorderFactory.createMatteBorder(2, 2, 2, 2, Color.magenta));
		DefaultCaret caret = (DefaultCaret) userTextArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		frameMain.add(userTextArea, c);
		//End Add Elements


		frameMain.addWindowListener(new WindowAdapter(){
			 public void windowClosing(WindowEvent e){
				 outLine = "quit";
				 out.print(outLine);
				 System.exit(0);
			 }
		});
		

		userTextArea.append("\n" + in.readLine());

		
//		while (!outLine.equals("quit"))
//		{
//			try {
//				userTextArea.append("\n" + in.readLine());
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//			
//		}
	}

}
