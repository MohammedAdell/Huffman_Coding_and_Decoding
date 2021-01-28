
/*
 * 
 * 
 * 
 * this page for window Second window   for doing a operation  
 * 
 * 
 * 
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class SecondWindow implements ActionListener {

	JFrame secframe;
	JButton browse, encode, build, decode, back;
	JPanel seceast, secwest, secsouth, secnorth, southwest;
	public static File M;

	String sectext, a = "";

	public SecondWindow() {

		secframe = new JFrame("Huffman Encoder/Decoder ");

		//secframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		secframe.setSize(350, 150);
		secframe.setLocationRelativeTo(null); // set a window at center
		secframe.setVisible(true);
		Container c = secframe.getContentPane();
		c.setLayout(new BorderLayout());

		browse = new JButton("Browse");
		browse.addActionListener(this);
		browse.setActionCommand("browse");

		encode = new JButton("Encode");
		encode.addActionListener(this);
		encode.setActionCommand("encode");

		decode = new JButton("Decode");
		decode.addActionListener(this);
		decode.setActionCommand("decode");

		build = new JButton("Build");
		build.addActionListener(this);
		build.setActionCommand("build");

		back = new JButton("Back");
		back.addActionListener(this);
		back.setActionCommand("Back");

		secnorth = new JPanel();
		secwest = new JPanel();
		seceast = new JPanel();
		secsouth = new JPanel();
		southwest = new JPanel();

		secnorth.add(decode);
		secwest.add(browse);
		seceast.add(encode);
		secsouth.add(build);
		southwest.add(back);

		secframe.getContentPane().setBackground(Color.decode("#226666"));
		secnorth.setBackground(Color.decode("#226666"));
		secwest.setBackground(Color.decode("#226666"));
		seceast.setBackground(Color.decode("#226666"));
		secsouth.setBackground(Color.decode("#226666"));
		southwest.setBackground(Color.decode("#226666"));

		c.add(BorderLayout.NORTH, secnorth);
		c.add(BorderLayout.WEST, secwest);
		c.add(BorderLayout.EAST, seceast);
		c.add(BorderLayout.CENTER, secsouth);
		c.add(BorderLayout.SOUTH, southwest);

		secframe.setVisible(true);
	}

	/*
	 * this method to set a operation for every button in window .
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("Back")) {
			secframe.dispose();
		} else if (e.getActionCommand().equals("browse")) {
				JFileChooser fc = new JFileChooser("choose file");
				fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int result = fc.showOpenDialog(secframe);
				if (result == JFileChooser.APPROVE_OPTION)
					M = fc.getSelectedFile();

			} else if (e.getActionCommand().equals("encode")) {
				try {
					//Display m = new Display(1);
					Huffman huf = new Huffman(M);
					
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
					
				}
			} else if (e.getActionCommand().equals("decode")) {
				try {
					
					Huffman huf = new Huffman(M);

				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
			} else if (e.getActionCommand().equals("build")) {

				try {
					Display m = new Display(0);
					Scanner s1 = new Scanner(M);
					while (s1.hasNextLine()) {
						
						sectext = s1.nextLine();
						
					}

					Huffman huf = new Huffman();
					Node Q = huf.Nodes.peek();

					NewWindow NW = new NewWindow(Q);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
				
					e1.printStackTrace();
				}

			}
		}

	

}
