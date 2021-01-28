
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.File;


public class Interface implements ActionListener {

	JFrame Frame;
	JButton Start, AboutUs, HowToUse;
	JPanel east, west, south, north;
	File f;
	public Interface() {

		Frame = new JFrame("Huffman Encoder/Decoder ");
		Frame.setSize(350, 150);
		Frame.setLocationRelativeTo(null);
		Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container c = Frame.getContentPane();
		c.setLayout(new BorderLayout());

		Start = new JButton("Start");
		Start.addActionListener(this);
		Start.setActionCommand("Start");

		AboutUs = new JButton("about us");
		AboutUs.addActionListener(this);
		AboutUs.setActionCommand("about us");

		HowToUse = new JButton("How to use");
		HowToUse.addActionListener(this);
		HowToUse.setActionCommand("How to use");

		north = new JPanel();
		west = new JPanel();
		east = new JPanel();
		Frame.getContentPane().setBackground( Color.decode("#226666") ); 
		north.setBackground( Color.decode("#226666") );
		west.setBackground( Color.decode("#226666") );
		east.setBackground( Color.decode("#226666") );
		// south = new JPanel();

		north.add(Start);
		west.add(AboutUs);
		east.add(HowToUse);
		
		c.add(BorderLayout.NORTH, north);
		c.add(BorderLayout.WEST, west);
		c.add(BorderLayout.EAST, east);

		Frame.setVisible(true);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Start")) {
			SecondWindow c = new SecondWindow();
			// c.actionPerformed(e);

		} else {
			if (e.getActionCommand().equals("about us")) {
				AboutUs m = new AboutUs();
			} else {
				if (e.getActionCommand().equals("How to use")) {
					How h = new How();
				}
			}

		}
	}

}
