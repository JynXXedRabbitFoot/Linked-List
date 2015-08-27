
/*
 *
 */
import java.util.ListIterator;

/**
 * LinkedList implementation. A new list can be created with an object, or null.
 * Every time a node is added it becomes the current node.
 *
 */
public class LinkedList<T> implements Cloneable, ListIterator<T> {
	private Node<T> head = null;
	private Node<T> tail;
	private Node<T> current;
	private int size = 1;

	/**
	 * Instantiates a new linked list.
	 *
	 * @param o
	 *            the o
	 */
	public LinkedList(T o) {
		super();
		// List will always have a head node even if data is null in which case
		// size is zero
		this.head = new Node<T>(null, null, o);
		this.tail = this.head;
		if (o == null) {
			this.size = 0;
			// if head data is null hasNext will return false because current
			// will not have next.
			this.current = new Node<T>(null, null, null);
		} else {
			this.current = new Node<T>(null, this.head, null);
		}
	}

	/**
	 * start iterator over
	 *
	 */
	public void resetCurrent() {
		if (this.size < 1) {
			this.current = new Node<T>(null, null, null);
		} else {
			this.current = new Node<T>(null, this.head, null);
		}
	}

	/**
	 * Insert at beginning.
	 *
	 * @param o
	 *            the o
	 */
	public void insertAtBeginning(T o) {
		this.resetCurrent();
		this.add(o);
	}

	/**
	 * Insert at end.
	 *
	 * @param o
	 *            the o
	 */
	public void insertAtEnd(T o) {
		if (this.size > 0) {
			this.current = this.tail;
		}
		this.add(o);
	}

	@Override
	public void add(T o) {
		if (this.size < 1) {// empty list
			this.head.setData(o);
			this.current = this.head;
		} else {// there is at least one node in list
			Node<T> newNode = new Node<T>(null, null, o);
			if (this.current.getSucc() != null) {// if current has successor
													// insert between current
													// and successor
				newNode.setSucc(this.current.getSucc());
				this.current.getSucc().setPred(newNode);
			} else {
				this.tail = newNode;
			}
			if (this.current.getData() != null) {// add after current
				this.current.setSucc(newNode);
				newNode.setPred(this.current);
			} else {// Inserting at beginning
				this.head = newNode;
			}
			this.current = newNode;
		}
		this.size++;
	}

	/**
	 * Removes the current node if it exists. Backs up the current node to the
	 * previous Node to maintain next Node consistency.
	 */
	@Override
	public void remove() {
		if (this.size > 0) {
			if (this.size == 1) {
				this.head.setData(null);
				this.tail = this.head;
				this.resetCurrent();
				// At beginning of 2 or more nodes.
			} else if (this.current == this.head) {
				this.head = this.head.getSucc();
				this.resetCurrent();
				// At end of 2 or more nodes.
			} else if (this.current == this.tail) {
				this.resetCurrent();
				this.tail = this.tail.getPred();
				this.tail.setSucc(null);
				// In between Nodes.
			} else {
				this.current.getPred().setSucc(this.current.getSucc());
				this.current.getSucc().setPred(this.current.getPred());
				this.current = this.current.getPred();
			}
			this.size--;
		}
	}

	/**
	 * Advances and returns the next Node in the list. If current item was tail
	 * it returns null.
	 */

	@SuppressWarnings("unchecked")
	@Override
	public T next() {
		if (this.current.getSucc() == null) {
			return null;
		} else {
			this.current = this.current.getSucc();
			return (T) this.current.getData();
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T previous() {
		if (this.current.getPred() == null) {
			return null;
		} else {
			this.current = this.current.getPred();
			return (T) this.current.getData();
		}
	}

	/**
	 * Removes the Node at the head of this list.
	 */
	public void removeHead() {
		this.current = this.head;
		this.remove();
	}

	/**
	 * Removes the Node at the tail of this list.
	 */
	public void removeTail() {
		this.current = this.tail;
		this.remove();
	}

	/**
	 * Removes a single Node with specific data.
	 *
	 * @param o
	 */
	public void removeNode(T o) {
		this.resetCurrent();
		while (true) {
			if (this.current.getData().equals(o)) {
				this.remove();
				break;
			}
			if ((this.current.getSucc() == null)) {
				break;
			} else {
				this.next();
			}
		}
	}

	/**
	 * Removes all Nodes with specific data.
	 *
	 * @param o
	 */
	public void removeNodes(T o) {
		this.resetCurrent();
		while (true) {
			if (this.current.getData().equals(o)) {
				this.remove();
			}
			if ((this.current.getSucc() == null)) {
				break;
			} else {
				this.next();
			}
		}
	}

	/**
	 * Determines if the list contains a Node with specified data.
	 *
	 * @param o
	 */
	public boolean contains(T o) {
		if (this.size < 1) {
			return false;
		}
		this.resetCurrent();
		while (true) {
			if (this.current.getData().equals(o)) {
				return true;
			}
			if ((this.current.getSucc() == null)) {
				return false;
			} else {
				this.next();
			}
		}
	}

	/**
	 * Empties the list.
	 */
	public void clear() {
		this.head.setData(null);
		this.head.setSucc(null);
		this.size = 0;
		this.tail = this.head;
		this.resetCurrent();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected LinkedList<T> clone() throws CloneNotSupportedException {
		if (this.size < 1) {
			return new LinkedList<T>(null);
		}
		LinkedList<T> clone = (LinkedList<T>) super.clone();
		this.resetCurrent();
		while (this.hasNext()) {
			clone.add(this.next());
		}
		return clone;
	}

	public int getSize() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("LinkedList [");
		this.resetCurrent();
		while (this.hasNext()) {
			sb.append(this.next().toString());
		}
		sb.append(" ]");
		return sb.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = (prime * result) + ((this.current == null) ? 0 : this.current.hashCode());
		result = (prime * result) + ((this.head == null) ? 0 : this.head.hashCode());
		result = (prime * result) + this.size;
		result = (prime * result) + ((this.tail == null) ? 0 : this.tail.hashCode());
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
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		@SuppressWarnings("unchecked")
		LinkedList<T> other = (LinkedList<T>) obj;
		if (this.current == null) {
			if (other.current != null) {
				return false;
			}
		} else if (!this.current.equals(other.current)) {
			return false;
		}
		if (this.head == null) {
			if (other.head != null) {
				return false;
			}
		} else if (!this.head.equals(other.head)) {
			return false;
		}
		if (this.size != other.size) {
			return false;
		}
		if (this.tail == null) {
			if (other.tail != null) {
				return false;
			}
		} else if (!this.tail.equals(other.tail)) {
			return false;
		}
		return true;
	}

	@Override
	public boolean hasNext() {
		return (this.current.getSucc() != null);
	}

	@Override
	public boolean hasPrevious() {
		return (this.current.getPred() != null);
	}

	@Override
	/**
	 * Unused
	 *
	 * @return - Always returns 0.
	 */
	public int nextIndex() {
		return 0;
	}

	@Override
	/**
	 * Unused
	 *
	 * @return - Always returns 0.
	 */
	public int previousIndex() {
		return 0;
	}

	@Override
	/**
	 * Unused
	 */
	public void set(Object arg0) {
	}
}
