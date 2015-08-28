/**
 * Generic Node for a LinkedList.
 *
 * @author Dank
 *
 */
public class Node<T> {

	private Node<T> predecessor = null;
	private Node<T> succesor = null;
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
		this.predecessor = pred;
		this.succesor = succ;
		this.data = data;
	}

	public Node<T> getPred() {
		return this.predecessor;
	}

	public void setPred(Node<T> pred) {
		this.predecessor = pred;
	}

	public Node<T> getSucc() {
		return this.succesor;
	}

	public void setSucc(Node<T> succ) {
		this.succesor = succ;
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
		result = (prime * result) + ((this.predecessor == null) ? 0 : this.predecessor.hashCode());
		result = (prime * result) + ((this.succesor == null) ? 0 : this.succesor.hashCode());
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
		if (this.predecessor == null) {
			if (other.predecessor != null) {
				return false;
			}
		} else if (!this.predecessor.equals(other.predecessor)) {
			return false;
		}
		if (this.succesor == null) {
			if (other.succesor != null) {
				return false;
			}
		} else if (!this.succesor.equals(other.succesor)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Node [data=" + this.data + "]";
	}
}
