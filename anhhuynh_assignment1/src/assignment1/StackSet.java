/**
 * COMP 410
 * See inline comment descriptions for methods we need that are
 * not described in the interface.
 *
*/
package assignment1;

public class StackSet implements StackSet_Interface {
	private Node head; // this will be the entry point to your linked list
						// ( it points to the first data cell, the top for a stack )
	private final int limit; // defines the maximum size the stackset may contain
	private int size; // current count of elements in the stackset

	private int count;
	private Node current;
	private Node preCurr;
	private boolean atHead;

	public StackSet(int maxNumElts) { // this constructor is needed for testing purposes.
		head = null; // Please don't modify what you see here!
		limit = maxNumElts; // you may add fields if you need to
		size = 0;
		count = 0;
		current = head;
		preCurr = head;
		atHead = false;
	}

	// implement all methods of the interface, and
	// also include the getRoot method below that we made for testing purposes.
	// Feel free to implement private helper methods!
	// you may add any fields you need to add to make it all work...

	public Node getRoot() { // leave this method as is, used by the grader to grab
		return head; // your data list easily.
	}

	@Override
	public boolean push(double elt) {
		// TODO Auto-generated method stub
		if (size == 0) {
			Node newNode = new NodeImpl(elt);
			this.head = newNode;

			size++;
			return true;
		}

		
		if (size != limit && !contains(elt)) {
			Node newNode = new NodeImpl(elt);

			newNode.setNext(this.head);

			this.head = newNode;
			size++;
			return true;

		} else if (contains(elt) && !atHead) {
			preCurr.setNext(current.getNext());

			current.setNext(this.head);

			this.head = current;
			return true;
		}
		// this.head = new NodeImpl(elt);
		// this.head.setNext(current);
		// this.current = this.head;

		return false;

	}

	@Override
	public boolean pop() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return false;
		}
		this.head = this.head.getNext();
		// current.setNext(null);
		current = this.head;
		size--;
		return true;
	}

	@Override
	public double peek() {
		// TODO Auto-generated method stub
		if (isEmpty()) {
			return Double.NaN;
		}
		return head.getValue();

	}

	@Override
	public boolean contains(double elt) {
		// TODO Auto-generated method stub
		if (size == 0) {
			return false;
		}
		this.current = this.head;
		this.preCurr = this.head;

		if (current.getValue() == elt) {
			atHead = true;
			return true;
		}
		atHead = false;

		while (preCurr.getNext() != null) {
			if (preCurr.getNext().getValue() == elt) {
				this.current = preCurr.getNext();
				return true;
			} else {
				preCurr = preCurr.getNext();

			}
		}

		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public int limit() {
		// TODO Auto-generated method stub
		return this.limit;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (size() == 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean isFull() {
		// TODO Auto-generated method stub
		if (size() == limit()) {
			return true;
		}
		return false;
	}

}