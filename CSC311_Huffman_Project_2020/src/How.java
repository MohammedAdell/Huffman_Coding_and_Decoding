/*
 * 
 * 
 * 
 * this page for window  How the user can use the app 
 * 
 * 
 * 
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class How implements ActionListener {

	JFrame thframe;
	JButton back;
	JPanel down;

	public How() {

		thframe = new JFrame("Huffman Encoder/Decoder ");

		thframe.setSize(750, 300);
		thframe.setVisible(true);
		Container c = thframe.getContentPane();
		c.setLayout(new BorderLayout());

		back = new JButton("Back");
		back.addActionListener(this);
		back.setActionCommand("Back");
		
		thframe.add(new JLabel("<html> To use this program, you can do the following:"
				+ "<br/> 1. Click Browse and choose the text file you wish to encode or decode."
				+ "<br/> 2. You can encode the text file by clicking on "
				+ "<br/> “Encode”, a text file containing the encoded message, "
				+ "<br/> a huffman tree (as text) and the size measured by byte will be saved and opened."
				+ "<br/> 3. You can build the tree by clicking on “Build”, "
				+ "<br/> only after encoding the decoded message (step #2)."
				+ "<br/> 4. You can decode the message by choosing the previously saved encoded file,"
				+ "<br/> or you can choose any file, however it must be the same layout as the previously saved encoded file."
				+ "<br/> you can change only the encoded message itself, the tree code, the size before and after.\r\n" + 
				"all other texts remain the same.\r\n" + 
				"</html>", SwingConstants.CENTER));
		
		thframe.setLocationRelativeTo(null);
		down = new JPanel();
		
		thframe.getContentPane().setBackground( Color.decode("#226666") ); 
		down.setBackground( Color.decode("#226666"));
		
		down.add(back);

		c.add(BorderLayout.SOUTH, down);
		thframe.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Back")) {
			//back.dispose();
			thframe.dispose();
		}
	}

}
