
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Display implements ActionListener {

	JFrame thframe;
	JButton OK;
	JPanel down;

	public Display(int i) {

		thframe = new JFrame("Huffman Encoder/Decoder ");
		thframe.setSize(330, 150);
		thframe.setVisible(true);
		Container c = thframe.getContentPane();
		c.setLayout(new BorderLayout());
		OK = new JButton("OK");
		OK.addActionListener(this);

		OK.setActionCommand("OK");
		if (i == 1) {
			thframe.add(new JLabel("<html>If you did not choose a text file to encode, please "
					+ "<br/>go back to the home page and click on “how to use”</html>", SwingConstants.CENTER));
		} else {
			thframe.add(new JLabel("<html>If you did not encode a text file, please go back  "
					+ "<br/>back to the home page and click on “how to use”.</html>"

					, SwingConstants.CENTER));
		}
		thframe.setLocationRelativeTo(null);
		down = new JPanel();

		thframe.getContentPane().setBackground(Color.decode("#226666"));
		down.setBackground(Color.decode("#226666"));
		down.add(OK);

		c.add(BorderLayout.SOUTH, down);
		thframe.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {

		if (e.getActionCommand().equals("OK")) {
			// back.dispose();
			thframe.dispose();

		}
	}
}
