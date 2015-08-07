/**
 *
 */

/**
 * Node for a linked list.
 *
 * @author Dank
 *
 */
public class Node {
	private Node pred = null;
	private Node succ = null;
	private Object data = null;

	public Node(Node pred, Node succ, Object data) {
		super();
		this.pred = pred;
		this.succ = succ;
		this.data = data;
	}

	public Node getPred() {
		return this.pred;
	}

	public void setPred(Node pred) {
		this.pred = pred;
	}

	public Node getSucc() {
		return this.succ;
	}

	public void setSucc(Node succ) {
		this.succ = succ;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
