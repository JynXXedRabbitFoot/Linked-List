/**
 * Generic Node for a linked list.
 *
 * @author Dank
 *
 */
public class Node<T> {

	private Node<T> pred = null;
	private Node<T> succ = null;
	private T data = null;

	/**
	 * Instantiates a new Node.
	 *
	 * @param pred
	 *            - The Node preceding this one.
	 * @param succ
	 *            - The Node succeeding this one.
	 * @param data
	 *            - this Nodes data.
	 */
	public Node(Node<T> pred, Node<T> succ, T data) {
		super();
		this.pred = pred;
		this.succ = succ;
		this.data = data;
	}

	public Node<T> getPred() {
		return this.pred;
	}

	public void setPred(Node<T> pred) {
		this.pred = pred;
	}

	public Node<T> getSucc() {
		return this.succ;
	}

	public void setSucc(Node<T> succ) {
		this.succ = succ;
	}

	public Object getData() {
		return this.data;
	}

	public void setData(T data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Node [data=" + this.data + "]";
	}
}
