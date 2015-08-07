
public class LinkedList {
	private Node head = null;
	private Node tail = null;
	private Node current;
	private int size;

	public LinkedList(Object o) {
		super();
		this.head = new Node(null, null, o);
		this.current = this.head;
		this.tail = this.head;
	}

	/**
	 * Adds an element to the beginning of the list.
	 *
	 * @param o
	 */
	public void insertAtBeginning(Object o) {
		Node newNode = new Node(null, this.head, o);
		this.head.setPred(newNode);
		this.head = newNode;
		this.size++;
	}

	public void insertAfterCurrent(Object o) {
		Node newNode = new Node(this.current, this.current.getSucc(), o);
		this.current.setSucc(newNode);
		this.current = newNode;
	}

	public void next() {
		if (this.current.getSucc() == null) {
			this.current = this.head;
		} else {
			this.current = this.current.getSucc();
		}
	}

	public Object getCurrent() {
		return this.current.getData();
	}
}
