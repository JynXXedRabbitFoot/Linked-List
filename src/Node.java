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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.data == null) ? 0 : this.data.hashCode());
		result = (prime * result) + ((this.pred == null) ? 0 : this.pred.hashCode());
		result = (prime * result) + ((this.succ == null) ? 0 : this.succ.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof Node)) {
			return false;
		}
		@SuppressWarnings("unchecked")
		Node<T> other = (Node<T>) obj;
		if (this.data == null) {
			if (other.data != null) {
				return false;
			}
		} else if (!this.data.equals(other.data)) {
			return false;
		}
		if (this.pred == null) {
			if (other.pred != null) {
				return false;
			}
		} else if (!this.pred.equals(other.pred)) {
			return false;
		}
		if (this.succ == null) {
			if (other.succ != null) {
				return false;
			}
		} else if (!this.succ.equals(other.succ)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Node [data=" + this.data + "]";
	}
}
