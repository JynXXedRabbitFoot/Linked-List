
public class LLTester {

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>(5);
		System.out.println(list.getCurrent());
		list.advanceCurrent();
		System.out.println(list.getCurrent());
		list.insertAtBeginning(1);
		System.out.println(list.getCurrent());
		list.advanceCurrent();
		System.out.println(list.getCurrent());
		list.insertAtEnd(10);
		System.out.println(list.getCurrent());
		list.advanceCurrent();
		System.out.println(list.getCurrent());
		System.out.println(list.toString());
	}
}
