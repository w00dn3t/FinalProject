import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class LoginUI {
  	JFrame frameMain = new JFrame("Login");

	//Create Elements
	JLabel usernameLabel = new JLabel("Username");
	JTextField usernameTextField = new JTextField(20);

	JLabel passwordLabel = new JLabel("Password");
	JTextField passwordTextField = new JTextField(20);
	
	JButton loginButton = new JButton("Login");
	public LoginUI(final PrintWriter out, final BufferedReader in) {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frameMain.setSize(350, 150);
		frameMain.setVisible(true);
		frameMain.setLayout(layout);
		
		//Insert Elements
		c.gridx = 0; c.gridy = 0;
		c.fill = GridBagConstraints.HORIZONTAL;
		frameMain.add(usernameLabel, c);
		
		c.gridx = 1; c.gridy = 0;
		frameMain.add(usernameTextField, c);

		c.gridx = 0; c.gridy = 1;
		frameMain.add(passwordLabel, c);

		c.gridx = 1; c.gridy = 1;
		frameMain.add(passwordTextField, c);

		c.gridwidth = 2;
		c.gridx = 0; c.gridy = 2;
		frameMain.add(loginButton, c);
		//End Insert Elements
		
		//Function for button
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				out.println(usernameTextField.getText());
				out.println(passwordTextField.getText());
				try {
					String status;
					if ((status = in.readLine()).equals("proceed")){
						MatchBrowserUI browser = new MatchBrowserUI(out, in);
						System.out.println(status);
						frameMain.setVisible(false);
					} else if (status.equals("fail"))
						System.exit(0);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}
}
