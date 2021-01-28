
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class HuffmanFrame {

	File f;
	String text, a = "";

	public static void main(String[] args) {
		Interface h = new Interface();
	}

}

class Tree extends JFrame {

	public static int[] freqCount(String S) {

		int[] f = new int[10000];
		for (int i = 0; i < S.length(); i++) {

			f[S.charAt(i)]++;

		}
		System.out.println(f[S.charAt(0)] + " " + S.charAt(0));
		for (int i = 0; i < 9; i++) {
			System.out.println(f[S.charAt(i)] + " " + S.charAt(i));
		}
		return f;
	}

}

class NewWindow {
	String encoded = "";
	Node ab;
	ArrayList<Node> node = new ArrayList<Node>();
	public int width = 700; // this may be changed accordingly to fit the tree in the screen//
	public int height = 10;
	ArrayList<Integer> x = new ArrayList<Integer>(); // list of x coordinates of the nodes in the tree//
	ArrayList<Integer> y = new ArrayList<Integer>(); // list of y coordinates of the nodes in the tree//

	public int index(Node n) {
		int a = 0;
		for (int i = 0; i < node.size(); i++) {
			if (n == node.get(i)) {
				a = i;
				break;
			}
		}
		return a;
	}

	public void bfs(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		int c = 1;

		q.add(root);
		while (!q.isEmpty()) {
			Node n = (Node) q.remove();
			node.add(n);
			if (n.left != null)
				q.add(n.left);
			if (n.right != null)
				q.add(n.right);
		}
		for (int i = 0; i < node.size(); i++) {
			x.add(0);
			y.add(0);
		}
		x.set(0, width);
		y.set(0, height);

		for (int j = 0; j < node.size(); j++) {
			if (node.get(j).left != null && node.get(j).right != null) {
				x.set(index(node.get(j).left), x.get(j) - 25 * c);
				x.set(index(node.get(j).right), x.get(j) + 25 * c);

				y.set(index(node.get(j).left), y.get(j) + 100);
				y.set(index(node.get(j).right), y.get(j) + 100);
				c++;
			}

		}

		ab.setcount(node.size());
	}

	public NewWindow(Node b) {

		ab = b;
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
				} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
						| UnsupportedLookAndFeelException ex) {
				}

				JFrame frame = new JFrame("HUFFMAN TREE GENERATION");

				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLayout(new BorderLayout());

				frame.add(new TestPane());
				frame.pack();
				frame.setLocationRelativeTo(null);
				frame.setVisible(true);

			}
		});
		bfs(ab);

	}

	public class TestPane extends JPanel {

		private int b = node.size();

		@Override
		public Dimension getPreferredSize() {
			return new Dimension(2800, 2800);
		}

		public TestPane() {
			ActionListener animate = new ActionListener() {
				public void actionPerformed(ActionEvent ae) {
					repaint();
					b--;
				}
			};
			Timer timer = new Timer(100, animate);
			timer.start();
			setBackground(Color.WHITE);
		}

		@Override

		protected void paintComponent(Graphics g) {

			super.paintComponent(g);
			Graphics2D g2d = (Graphics2D) g;
			g.setColor(Color.RED);

			for (int j = node.size() - 1; j >= 0; j--) {
				if (node.get(j).count < node.size() - b) {
					g2d.setColor(Color.CYAN);
					g2d.fillRect(x.get(j), y.get(j), 23, 23);

					g2d.setColor(Color.BLACK);
					g2d.drawRect(x.get(j), y.get(j), 23, 23);
					g2d.setColor(Color.BLACK);
					g2d.drawString(Integer.toString((int) node.get(j).value), x.get(j) + 5, y.get(j) + 13);
					g2d.drawString(Character.toString(node.get(j).character), x.get(j) + 10, y.get(j) + 20);
					g2d.setColor(Color.BLACK);
					if ((node.get(j)).left != null) {

						g2d.drawLine(x.get(j) + 20, y.get(j) + 20, x.get(index(node.get(j).left)),
								y.get(index(node.get(j).left)));

						g2d.drawString("0", (x.get(j) + x.get(index(node.get(j).left))) / 2,
								(y.get(j) + y.get(index(node.get(j).left))) / 2);
						g2d.setColor(Color.BLACK);

					}
					if ((node.get(j)).right != null) {

						g2d.drawLine(x.get(j) + 20, y.get(j) + 20, x.get(index(node.get(j).right)),
								y.get(index(node.get(j).right)));
						g2d.drawString("1", (x.get(j) + x.get(index(node.get(j).right))) / 2,
								(y.get(j) + y.get(index(node.get(j).right))) / 2);
						g2d.setColor(Color.BLACK);
					}
				}
			}

		}
	}
}
