/*
 * 
 * 
 * 
 * this page for window  About Us 

 * 
 * 
 * 
 */
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AboutUs implements ActionListener {

	JFrame thframe;//thframe for creat a window 
	JButton back;
	JPanel down; // for location of buttton 

	public AboutUs() {

		thframe = new JFrame("Huffman Encoder/Decoder ");
		thframe.setSize(500, 200);
		thframe.setVisible(true);
		Container c = thframe.getContentPane();
		c.setLayout(new BorderLayout());
		back = new JButton("Back");// creat a button 
		back.addActionListener(this);
		back.setActionCommand("Back");
		thframe.add(new JLabel("<html>This program was made by Mohammed Thabit and"
				+ "<br/> Abdullaziz Alsannat. It is a requirement for the "
				+ "<br/>project of the course CSC311 Algorithms Design" 
				+ "<br/>and Analysis, instructed by Professor Mohammed Maher Ben Ismail.</html>", SwingConstants.CENTER));
		
		
		thframe.setLocationRelativeTo(null); // to open a window at  center 
		down = new JPanel();
		
		thframe.getContentPane().setBackground( Color.decode("#226666") ); // change color of all page 
		down.setBackground( Color.decode("#226666")); // change a color at location of button 
		down.add(back);

		c.add(BorderLayout.SOUTH, down);// location of the button
	
	}
	
	
	/*
	 * this methode to make action on the button and location of a another window 
	 */
	public void actionPerformed(ActionEvent e) { 

		if (e.getActionCommand().equals("Back")) {
			//back.dispose();
			thframe.dispose();

		}
	}

}
