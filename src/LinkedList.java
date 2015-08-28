/*
 * 
 */
import java.util.ListIterator;

/**
 * LinkedList implementation. A new list can be created with an object, or null.
 * Every time a node is added it becomes the current node.
 * 
 * @author Dan Kruse
 *
 * @param <T>
 *            - the dataType to use in this generic LinkedList.
 */
public class LinkedList<T> implements Cloneable, ListIterator<T> {
	private Node<T> head = null;
	private Node<T> tail;
	private Node<T> current;
	private int size = 1;

	/**
	 * Instantiates a new linked list.
	 *
	 * @param data
	 *            - This data will be the first node in the list
	 */
	public LinkedList(T data) {
		super();
		// List will always have a head node even if data is null in which case
		// size is zero
		this.head = new Node<T>(null, null, data);
		this.tail = this.head;
		if (data == null) {
			this.size = 0;
			// if head data is null hasNext will return false because current
			// will not have next.
			this.current = new Node<T>(null, null, null);
		} else {
			// this.current = new Node<T>(null, this.head, null);
			this.current = this.head;
		}
	}

	/**
	 * Resets the iterators cursor to the beginning of the list.
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
	 * Insert a node at the beginning of the list.
	 *
	 * @param data
	 *            - the data to be added to the beginning of the list.
	 */
	public void insertAtBeginning(T data) {
		this.resetCurrent();
		this.add(data);
	}

	/**
	 * Inserts a node at the end of the list.
	 *
	 * @param data
	 *            - the data to be added to the end of the list.
	 */
	public void insertAtEnd(T data) {
		if (this.size > 0) {
			this.current = this.tail;
		}
		this.add(data);
	}

	@Override
	public void add(T o) {
		if (this.size < 1) {// empty list
			this.head.setData(o);
			this.current = this.head;
			this.tail = this.head;
		} else {
			Node<T> newNode = new Node<T>(null, null, o);
			// list with at least 1 element
			if (this.current.getData() == null) {
				// we are beginning pointer, insert before current head
				newNode.setSucc(this.head);
				this.head.setPred(newNode);
				this.head = newNode;
				this.current = this.head;
			} else {
				// we are pointing at a node
				if (!this.hasNext()) {
					// current is tail which we will replace
					this.tail = newNode;
					this.tail.setPred(this.current);
					this.current.setSucc(this.tail);
					this.current = this.tail;
				} else {
					// we are adding a node after current node which exists and
					// before the next node which exists.
					newNode.setPred(this.current);
					newNode.setSucc(this.current.getSucc());
					this.current.setSucc(newNode);
					newNode.getSucc().setPred(newNode);
					this.current = newNode;
				}
			}

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
			if (this.current.getData() != null) {
				if (this.size == 1) {
					this.head.setData(null);
					this.tail = this.head;
					this.size--;
					this.resetCurrent();
				} else {
					if (this.current == this.head) {
						this.head = this.head.getSucc();
						this.head.setPred(null);
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
		}
	}

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
	 * @param data-
	 *            the first node found with this data will be removed from the
	 *            list.
	 */
	public void removeNode(T data) {
		this.resetCurrent();
		while (true) {
			if (this.next().equals(data)) {
				this.remove();
				break;
			}
			if ((this.current.getSucc() == null)) {
				break;
			}
		}
	}

	/**
	 * Removes all Nodes with specific data.
	 *
	 * @param data
	 *            - nodes with this data will be removed from the list.
	 */
	public void removeNodes(T data) {
		this.resetCurrent();
		while (true) {
			if (this.next().equals(data)) {
				this.remove();
			}
			if ((this.current.getSucc() == null)) {
				break;
			}
		}
	}

	/**
	 * Determines if the list contains a Node with specified data. If so it
	 * becomes the current element, otherwise the current element is reset to
	 * the beginning of the list.
	 *
	 * @param data
	 *            -The data to verify that the current List contains.
	 */
	public boolean contains(T data) {
		if (this.size < 1) {
			return false;
		}
		this.resetCurrent();
		while (true) {
			if (this.next().equals(data)) {
				return true;
			}
			if ((this.current.getSucc() == null)) {
				this.resetCurrent();
				return false;
			}
		}
	}

	/**
	 * Empties the LinkedList.
	 */
	public void clear() {
		this.head.setData(null);
		this.head.setSucc(null);
		this.size = 0;
		this.tail = this.head;
		this.resetCurrent();
	}

	@Override
	protected LinkedList<T> clone() throws CloneNotSupportedException {
		if (this.size < 1) {
			return new LinkedList<T>(null);
		}
		this.resetCurrent();
		LinkedList<T> clone = new LinkedList<T>(this.next());
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
		sb.append("LinkedList [ ");
		this.resetCurrent();
		while (this.hasNext()) {
			sb.append("Node [" + this.next().toString() + "] ");
		}
		sb.append("]");
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
	/**
	 * Returns true if both Lists contain the same quantity of nodes of the same
	 * type containing the same data in the same sequence.
	 */
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
		if (this.size != other.size) {
			return false;
		}
		this.resetCurrent();
		other.resetCurrent();
		while (this.hasNext()) {
			if (this.next() != other.next()) {
				return false;
			}
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
	public void set(Object o) {
	}
}
