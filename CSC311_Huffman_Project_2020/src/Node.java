
class Node {
	public Node left, right;
	public double value;
	public char character;
	public int count;

	public Node(double value, char character) {
		this.value = value;
		this.character = character;
		left = null;
		right = null;
	}

	public Node(Node left, Node right) {
		this.value = left.value + right.value;

		if (left.value < right.value) {
			this.right = right;
			this.left = left;
		} else {
			this.right = left;
			this.left = right;
		}
	}

	public void setcount(int size) {
		this.count = size;

	}
}