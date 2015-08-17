
/**
 * LinkedList implementation. A new list can be created with an object, or null.
 * Every time a node is added it becomes the current node.
 *
 */
public class LinkedList<T> implements Cloneable {
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
		if (o == null) {
			this.size = 0;
		}
		this.head = new Node<T>(null, null, o);
		this.current = this.head;
		this.tail = this.head;
	}

	/**
	 * Insert at beginning.
	 *
	 * @param o
	 *            the o
	 */
	public void insertAtBeginning(T o) {
		if (this.size > 0) {
			Node<T> newNode = new Node<T>(null, this.head, o);
			this.head.setPred(newNode);
			this.head = newNode;
			this.current = this.head;
		} else {
			this.head.setData(o);
		}
		this.size++;
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
			this.insertAfterCurrent(o);
		} else {
			this.head.setData(o);
			this.size++;
		}
	}

	/**
	 * Insert after current.
	 *
	 * @param o
	 *            the o
	 */
	public void insertAfterCurrent(T o) {
		if (this.size < 1) {
			this.insertAtBeginning(o);
		} else {
			Node<T> newNode = new Node<T>(this.current, this.current.getSucc(), o);
			this.current.setSucc(newNode);
			if (this.current == this.tail) {
				this.tail = newNode;
			}
			this.current = newNode;
			this.size++;
		}
	}

	/**
	 * Removes the current node if it exists. Advances the current node to the
	 * next Node.
	 */
	public void removeCurrent() {
		if (this.size > 0) {
			if (this.size == 1) {
				this.head.setData(null);
			} else if (this.current == this.head) {
				this.head = this.head.getSucc();
				this.advanceCurrent();
			} else if (this.current == this.tail) {
				this.advanceCurrent();
				this.tail = this.tail.getPred();
				this.tail.setSucc(null);
			} else {
				this.current.getPred().setSucc(this.current.getSucc());
				this.advanceCurrent();
			}
			this.size--;
		}
	}

	/**
	 * Removes the Node at the head of this list.
	 */
	public void removeHead() {
		this.current = this.head;
		this.removeCurrent();
	}

	/**
	 * Removes the Node at the tail of this list.
	 */
	public void removeTail() {
		this.current = this.tail;
		this.removeCurrent();
	}

	/**
	 * Removes a single Node with specific data.
	 *
	 * @param o
	 */
	public void removeNode(T o) {
		this.current = this.head;
		while (true) {
			if (this.current.getData().equals(o)) {
				this.removeCurrent();
				break;
			}
			if ((this.current.getSucc() == null)) {
				break;
			} else {
				this.advanceCurrent();
			}
		}
	}

	/**
	 * Removes all Nodes with specific data.
	 *
	 * @param o
	 */
	public void removeNodes(T o) {
		this.current = this.head;
		while (true) {
			if (this.current.getData().equals(o)) {
				this.removeCurrent();
			}
			if ((this.current.getSucc() == null)) {
				break;
			} else {
				this.advanceCurrent();
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
		this.current = this.head;
		while (true) {
			if (this.current.getData().equals(o)) {
				return true;
			}
			if ((this.current.getSucc() == null)) {
				return false;
			} else {
				this.advanceCurrent();
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
		this.current = this.head;
	}

	/**
	 * Advances current item to next in the list, if current item was tail it
	 * advances to the first item in the list.
	 */
	public void advanceCurrent() {
		if (this.current.getSucc() == null) {
			this.current = this.head;
		} else {
			this.current = this.current.getSucc();
		}
	}

	/**
	 * Retrieve the data from the current node.
	 *
	 * @return - The data from the current node, or null if this is an empty
	 *         list.
	 */
	@SuppressWarnings("unchecked")
	public T getCurrent() {
		return (T) this.current.getData();
	}

	@SuppressWarnings("unchecked")
	@Override
	protected Object clone() throws CloneNotSupportedException {
		if (this.size < 1) {
			return new LinkedList<T>(null);
		}
		LinkedList<T> clone = (LinkedList<T>) super.clone();
		this.current = this.head;

		while (true) {
			clone.insertAtEnd((T) this.current.getData());
			if ((this.current.getSucc() == null)) {
				return clone;
			} else {
				this.advanceCurrent();
			}
		}
	}

	public int getSize() {
		return this.size;
	}

	@Override
	// TODO
	public String toString() {
		return "LinkedList []";
	}

	@Override
	// TODO
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
	// TODO
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
		LinkedList other = (LinkedList) obj;
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

	// TODO
	/**
	 * Iterator
	 */
}
