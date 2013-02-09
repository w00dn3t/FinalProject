import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.swing.*;

public class MatchBrowserUI {
  	JFrame frameMain = new JFrame("Match Browser");

	public MatchBrowserUI(final PrintWriter out, final BufferedReader in) {
		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		frameMain.setSize(500, 500);
		frameMain.setVisible(true);
		frameMain.setLayout(layout);
	}

}
