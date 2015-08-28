/**
 * Runs unit tests on each method in the LinkedList implementation
 *
 * @author Dan KRuse
 *
 */
public class LLUnitTester {
	static LinkedList<Integer> cloneOriginal;
	static LinkedList<Integer> clone;
	static LinkedList<Integer> main;

	public static void main(String[] args) throws CloneNotSupportedException {

		testConstructor();
		System.out.println("testConstructor \t\t Passed");
		testClone();
		testResetCurrent();
		testNextAndHasNext();
		testPreviousAndHasPrevious();
		testClear();
		testRemoveNode();
		testContains();
		testRemoveNodes();
		testRemoveTailAndHead();
		testRemove();
		testInsertBeginning();
		testInsertEnd();
		testEquals();

	}

	private static void testInsertBeginning() {
		main = testConstructor();
		main.resetCurrent();
		assert main.next() == 1;
		main.insertAtBeginning(77);
		main.resetCurrent();
		assert main.next() == 77;
		System.out.println("testInsertBeginning \t\t Passed");
	}

	private static void testInsertEnd() {
		main = testConstructor();
		main.resetCurrent();
		main.insertAtEnd(77);
		main.resetCurrent();
		assert main.next() == 1;
		assert main.next() == 3;
		assert main.next() == 5;
		assert main.next() == 77;
		System.out.println("testInsertEnd \t\t\t Passed");
	}

	private static void testRemove() {
		main = testConstructor();
		main.resetCurrent();
		main.remove();
		assert main.contains(1);
		assert main.contains(3);
		assert main.contains(5);
		main.resetCurrent();
		assert main.next() == 1;
		main.remove();
		assert!main.contains(1);
		assert main.contains(3);
		assert main.contains(5);
		main.resetCurrent();
		assert main.next() == 3;
		assert main.next() == 5;
		main.remove();
		assert!main.contains(1);
		assert main.contains(3);
		assert!main.contains(5);
		System.out.println("testRemove \t\t\t Passed");
	}

	private static void testRemoveTailAndHead() {
		main = testConstructor();
		main.resetCurrent();
		main.removeTail();
		assert!main.contains(5);
		main.removeHead();
		assert!main.contains(1);
		assert main.contains(3);
		System.out.println("testRemoveTailAndHead \t\t Passed");
	}

	private static void testEquals() {
		// Lists of different sizes
		main = testConstructor();
		clone = testConstructor();
		assert clone.equals(main);
		main.add(1);
		assert!clone.equals(main);

		main = testConstructor();
		clone = testConstructor();
		assert clone.equals(main);
		main.removeNode(1);
		assert!clone.equals(main);

		// Lists of same size different content
		main = testConstructor();
		clone = testConstructor();
		assert clone.equals(main);
		main.add(1);
		clone.add(2);
		assert!clone.equals(main);

		// Lists of same size and content different order
		main = testConstructor();
		clone = testConstructor();
		assert clone.equals(main);
		main.insertAtBeginning(88);
		clone.insertAtEnd(88);
		assert!clone.equals(main);

		// one null list
		main = testConstructor();
		clone = null;
		assert!main.equals(clone);

		// same object
		main = testConstructor();
		clone = main;
		assert main.equals(clone);

		// different data types
		main = testConstructor();
		LinkedList<String> newList = new LinkedList<String>(null);
		newList.add("1");
		newList.add("3");
		newList.add("5");
		assert!main.equals(newList);

		System.out.println("testEquals \t\t\t Passed");
	}

	private static void testRemoveNode() {
		main = testConstructor();
		main.resetCurrent();
		assert main.contains(1);
		assert main.contains(3);
		assert main.contains(5);
		main.removeNode(3);
		assert main.contains(1);
		assert!main.contains(3);
		assert main.contains(5);
		main.removeNode(1);
		assert!main.contains(1);
		assert!main.contains(3);
		assert main.contains(5);
		System.out.println("testRemoveNode \t\t\t Passed");
	}

	private static void testRemoveNodes() {
		main = testConstructor();
		main.resetCurrent();
		main.add(1);
		main.resetCurrent();
		assert main.next() == 1;
		assert main.next() == 1;
		main.removeNodes(1);
		assert!main.contains(1);
		System.out.println("testRemoveNodes \t\t Passed");
	}

	private static void testContains() {
		main = testConstructor();
		main.resetCurrent();
		assert main.contains(1);
		assert main.contains(3);
		assert main.contains(5);
		assert!main.contains(10);
		assert!main.contains(2);
		assert!main.contains(8);
		System.out.println("testContains \t\t\t Passed");
	}

	private static void testClear() {
		main = testConstructor();
		main.resetCurrent();
		main.clear();
		assert!main.hasPrevious();
		assert!main.hasNext();
		assert main.getSize() == 0;
		System.out.println("testClear \t\t\t Passed");
	}

	private static void testPreviousAndHasPrevious() {
		main = testConstructor();
		main.resetCurrent();
		assert!main.hasPrevious();
		assert main.next() == 1;
		assert!main.hasPrevious();
		assert main.next() == 3;
		assert main.hasPrevious();
		assert main.next() == 5;
		assert main.hasPrevious();
		assert main.previous() == 3;
		assert main.hasPrevious();
		assert main.previous() == 1;
		assert!main.hasPrevious();
		System.out.println("testPreviousAndHasPrevious \t Passed");
	}

	private static void testNextAndHasNext() {
		main = testConstructor();
		main.resetCurrent();
		assert main.hasNext();
		assert main.next() == 1;
		assert main.next() == 3;
		assert main.next() == 5;
		assert!main.hasNext();
		assert main.next() == null;
		main.resetCurrent();
		assert main.next() == 1;
		System.out.println("testNextAndHasNext \t\t Passed");
	}

	private static LinkedList<Integer> testConstructor() {
		LinkedList<Integer> newList = new LinkedList<Integer>(null);
		newList.add(1);
		newList.add(3);
		newList.add(5);
		assert"LinkedList [ Node [1] Node [3] Node [5] ]".equals(newList.toString());
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
		System.out.println("testClone \t\t\t Passed");
	}

	private static void testResetCurrent() {
		main = testConstructor();
		main.resetCurrent();
		assert main.hasNext();
		assert main.next() == 1;
		assert main.next() == 3;
		main.resetCurrent();
		assert main.next() == 1;
		System.out.println("testResetCurrent \t\t Passed");
	}

}
