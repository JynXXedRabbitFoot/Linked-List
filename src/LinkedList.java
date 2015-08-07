
/**
 * LinkedList implementation. A new list can be created with an object, or null.
 * Every time a node is added it becomes the current node.
 *
 */
public class LinkedList<T> {
	private Node head = null;
	private Node tail = head;
	private Node current = head;
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
			size = 0;
		}
		this.head = new Node(null, null, o);
	}

	/**
	 * Insert at beginning.
	 *
	 * @param o
	 *            the o
	 */
	public void insertAtBeginning(T o) {
		if (size > 0) {
			Node newNode = new Node(null, this.head, o);
			this.head.setPred(newNode);
			this.head = newNode;
		} else {
			head.setData(o);
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
		if (size > 0) {
			current = tail;
			insertAfterCurrent(o);
		} else {
			head.setData(o);
		}
		this.size++;
	}

	/**
	 * Insert after current.
	 *
	 * @param o
	 *            the o
	 */
	public void insertAfterCurrent(T o) {
		if (size < 1) {
			insertAtBeginning(o);
		} else {
			Node newNode = new Node(this.current, this.current.getSucc(), o);
			this.current.setSucc(newNode);
			if (current == tail) {
				tail = newNode;
			}
			this.current = newNode;
			this.size++;
		}
	}

	/**
	 * Next.
	 */
	public void next() {
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
}
