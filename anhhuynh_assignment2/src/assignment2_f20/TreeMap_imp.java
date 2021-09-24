package assignment2_f20;

//--------------------------------------------------------------

public class TreeMap_imp implements TreeMap {
	private TMCell root;
	private boolean newKey;
	private Value oldVal;
	private int size;
	private String keys[];
	private int keysCounter;
	private TMCell next;
	private boolean isLeft;

	// add fields as you need to in order to provide the required behavior
	// also you may add private methods to assist you as needed
	// in implementing

	// -------------------------------------------------------------

	TreeMap_imp() {
		root = null;
		newKey = false;
		oldVal = null;
		size = 0;
		keys = null;
		keysCounter = 0;
		next = null;
		isLeft = true;

		// for added fields you can add appropriate initialization code here
	}

	// -------------------------------------------------------------

	// dont change, we need this for grading
	@Override
	public TMCell getRoot() {
		return this.root;
	}

	// -------------------------------------------------------------
	// "height" is a complete implementation
	// of the public interface method height
	// it is here to illustrate fr you how the textbook sets up
	// the method implementation as recursion
	// you may include this in your project directly

	public int height() { // public interface method signature
		// this method is the public interface method
		// it is not recursive, but it calls a recursive
		// private method and passes it access to the tree cells
		return height_r(this.getRoot());
	}

	private int height_r(TMCell c) {
		// inner method with different signature
		// this helper method uses recursion to traverse
		// and process the recursive structure of the tree of cells
		if (c == null)
			return -1;
		int lht = height_r(c.getLeft());
		int rht = height_r(c.getRight());
		return Math.max(lht, rht) + 1;
	}

	@Override
	public Value put(String k, Value v) {
		// TODO Auto-generated method stub

		newKey = false;
		oldVal = null;

		this.root = put_r(k, v, this.getRoot());
		if (newKey) {
			return null;
		} else {
			return oldVal;
		}

	}

	private TMCell put_r(String k, Value v, TMCell c) {
		if (c == null) {
			newKey = true;
			size++;
			return new TMCell_imp(k, v);
			// c.setLeft(null);
			// c.setRight(null);
		}

		int compareX = k.compareTo(c.getKey());

		if (compareX < 0)
			c.setLeft(put_r(k, v, c.getLeft()));
		else if (compareX > 0)
			c.setRight(put_r(k, v, c.getRight()));
		else {
			oldVal = c.getValue();
			c.setValue(v);
			newKey = false;
		}

		return c;
	}

	@Override
	public Value get(String k) {
		// TODO Auto-generated method stub

		return get_r(k, this.root);
	}

	private Value get_r(String k, TMCell c) {
		if (c == null) {
			return null;
		}

		int compareX = k.compareTo(c.getKey());

		if (compareX < 0)
			return get_r(k, c.getLeft());
		else if (compareX > 0)
			return get_r(k, c.getRight());
		else {
			return c.getValue();
		}
	}

	@Override
	public void remove(String k) {
		// TODO Auto-generated method stub
		isLeft = true;
		if (this.size() == 1) {
			this.root = null;
			return;
		}
		if (this.root!= null) {
			size --;
		}
		remove_r(k, this.root);
	}

	private void remove_r(String k, TMCell c) {
		isLeft = true;
		next = null;

		if (c == null) {
			return;
		}
		int compareX = k.compareTo(c.getKey());

		if (compareX < 0) {
			next = c.getLeft();
			isLeft = true;
		} else if (compareX > 0) {
			next = c.getRight();
			isLeft = false;
		} else if (compareX == 0) {
			next = c;

		}

		if (next == null) {
			return;
		}

		int compareY = k.compareTo(next.getKey());

		if (compareY != 0) {
			remove_r(k, next);

		} else if (compareY == 0 && isLeft == true) {
			if (next.getLeft() == null && next.getRight() == null) {
				c.setLeft(null);

			} else if (next.getLeft() == null) {
				if (next.getKey().compareTo(this.root.getKey()) == 0) {
					this.root = next.getRight();
					return;
				}
				c.setLeft(next.getRight());

			} else if (next.getRight() == null) {
				if (next.getKey().compareTo(this.root.getKey()) == 0) {
					this.root = next.getLeft();
					return;
				}
				c.setLeft(next.getLeft());
			} else {
				TMCell max = this.maxKey_r(next.getLeft());
				TMCell temp = next;

				this.remove(max.getKey());

				if (temp.getKey().compareTo(this.root.getKey()) == 0) {
					this.root = max;
					max.setLeft(temp.getLeft());
					max.setRight(temp.getRight());
					return;
				}

				c.setLeft(max);
				max.setLeft(temp.getLeft());
				max.setRight(temp.getRight());

				// max.setLeft(next.getLeft());
				// c.setLeft(max);
			}
		} else if (compareY == 0 && isLeft == false) {

			if (next.getLeft() == null && next.getRight() == null) {
				c.setRight(null);

			} else if (next.getLeft() == null) {
				c.setRight(next.getRight());

			} else if (next.getRight() == null) {
				c.setRight(next.getLeft());

			} else {

				TMCell max = this.maxKey_r(next.getLeft());
				TMCell temp = next;

				this.remove(max.getKey());

				c.setRight(max);
				max.setLeft(temp.getLeft());
				max.setRight(temp.getRight());
				// max.setLeft(next.getLeft());
				// c.setLeft(max);
			}

		}
		return;

	}

	@Override
	public boolean hasKey(String k) {
		// TODO Auto-generated method stub

		return hasKey_r(k, this.root);
	}

	private boolean hasKey_r(String k, TMCell c) {
		if (c == null) {
			return false;
		}
		int compareX = k.compareTo(c.getKey());

		if (compareX < 0)
			return hasKey_r(k, c.getLeft());
		else if (compareX > 0)
			return hasKey_r(k, c.getRight());
		else {
			return true;
		}

	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public String maxKey() {
		// TODO Auto-generated method stub
		if (this.root == null) {
			return null;
		} else {
			return maxKey_r(this.root).getKey();
		}
	}

	private TMCell maxKey_r(TMCell c) {
		if (c.getRight() == null) {
			return c;
		}
		return maxKey_r(c.getRight());
	}

	@Override
	public String minKey() {
		// TODO Auto-generated method stub
		if (this.root == null) {
			return null;
		} else {
			return minKey_r(this.root).getKey();
		}
	}

	private TMCell minKey_r(TMCell c) {
		if (c.getLeft() == null) {
			return c;
		}
		return minKey_r(c.getLeft());
	}

	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		// keys = new String[this.size()];
		keysCounter = 0;
		keys = new String[this.size()];
		if (this.root == null) {
			return keys;
		}

		getKeys_r(this.root);

		return keys;
	}

	private void getKeys_r(TMCell c) {
		if (c.getLeft() != null) {
			getKeys_r(c.getLeft());
		}

		keys[keysCounter] = c.getKey();
		this.keysCounter++;

		if (c.getRight() != null) {
			getKeys_r(c.getRight());
		}

		// return null;
	}

	// -------------------------------------------------------------
	// here down... you fill in the implementations for
	// the other interface methods
	// -------------------------------------------------------------
	//
	// remember to implement the required recursion as noted
	// in the interface definition
	//
	// -------------------------------------------------------------

}