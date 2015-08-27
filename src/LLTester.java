
public class LLTester {
	static LinkedList<Integer> cloneOriginal;
	static LinkedList<Integer> clone;

	public static void main(String[] args) throws CloneNotSupportedException {

		testConstructor();

		testClone();

		testResetCurrent();
		testEquals();
		testInsertBeginning();
		testInsertEnd();
		testRemove();
		testNext();
		testPrevious();
		testRemoveHead();
		testRemoveTail();
		testRemoveNode();
		testRemoveNodes();
		testContains();
		testClear();
		testHasPrevious();
		testHasNext();

	}

	private static void testResetCurrent() {
		// TODO
	}

	private static void testEquals() {
		// TODO
	}

	private static void testInsertBeginning() {
		// TODO
	}

	private static void testInsertEnd() {
		// TODO
	}

	private static void testRemove() {
		// TODO
	}

	private static void testNext() {
		// TODO
	}

	private static void testPrevious() {
		// TODO
	}

	private static void testRemoveHead() {
		// TODO
	}

	private static void testRemoveTail() {
		// TODO
	}

	private static void testRemoveNode() {
		// TODO
	}

	private static void testRemoveNodes() {
		// TODO
	}

	private static void testContains() {
		// TODO
	}

	private static void testClear() {
		// TODO
	}

	private static void testHasPrevious() {
		// TODO
	}

	private static void testHasNext() {
		// TODO
	}

	private static LinkedList<Integer> testConstructor() {
		LinkedList<Integer> newList = new LinkedList<Integer>(null);
		newList.add(1);
		newList.add(3);
		newList.add(5);
		assert"LinkedList [ Node [1] Node [3] Node [5] ]".equals(newList.toString());
		System.out.println("testConstructor \t Passed");
		return newList;
	}

	private static void testClone() throws CloneNotSupportedException {
		cloneOriginal = new LinkedList<Integer>(null);
		cloneOriginal.add(1);
		cloneOriginal.add(3);
		cloneOriginal.add(5);
		clone = cloneOriginal.clone();
		assert"LinkedList [ Node [1] Node [3] Node [5] ]".equals(clone.toString());
		cloneOriginal.add(5);
		assert"LinkedList [ Node [1] Node [3] Node [5] ]".equals(clone.toString());
		System.out.println("testClone \t\t Passed");
	}

}
