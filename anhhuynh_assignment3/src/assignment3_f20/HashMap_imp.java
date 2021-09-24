package assignment3_f20;

public class HashMap_imp implements HashMap {
	private HMCell[] tab; // FIXXXXX
	private int nelts;
	private int size;
	private HMCell firstPointer;
	private HMCell[] newTab;

	// -------------------------------------------------------------

	HashMap_imp(int num) {
		this.tab = new HMCell[num];
		// for (int i=0; i<num; i++) { tab[i] = null; }
		// we can rely on the Java compiler to fill the table array with nulls
		// another way would be Array.fill()
		this.nelts = 0;
		this.size = num;
		firstPointer = null;
		this.newTab = null;
	}

	// -------------------------------------------------------------

	public int hash(String key, int tabSize) {
		int hval = 7;
		for (int i = 0; i < key.length(); i++) {
			hval = (hval * 31) + key.charAt(i);
		}
		hval = hval % tabSize;
		if (hval < 0) {
			hval += tabSize;
		}
		return hval;
	}

	// -------------------------------------------------------------

	// dont change
	@Override
	public HMCell[] getTable() {
		return this.tab;
	}
	//

	@Override
	public Value put(String k, Value v) {
		// TODO Auto-generated method stub
		int index;
		index = this.hash(k, this.size);

		if (tab[index] == null) {
			tab[index] = new HMCell_imp(k, v);
			nelts++;
		} else {

			firstPointer = tab[index];
			while (firstPointer.getNext() != null) {

				if (firstPointer.getKey().compareTo(k) == 0) {
					Value returnVal = firstPointer.getValue();
					firstPointer.setValue(v);
					
					if(this.lambda() >= 1) {
						this.extend();
					}
					return returnVal;
				}

				firstPointer = firstPointer.getNext();
			}

			if (firstPointer.getKey().compareTo(k) == 0) {
				Value returnVal = firstPointer.getValue();
				firstPointer.setValue(v);
				
				if(this.lambda() >= 1) {
					this.extend();
				}
				return returnVal;
			}

			firstPointer.setNext(new HMCell_imp(k, v));
			nelts++;

		}
		if(this.lambda() >= 1.0) {
			this.extend();
		}
		
		return null;
	}

	@Override
	public Value get(String k) {
		// TODO Auto-generated method stub
		if (nelts == 0) {
			return null;
		}

		int index = this.hash(k, this.size);
		HMCell pointer = this.tab[index];

		while (pointer != null) {
			if (pointer.getKey().compareTo(k) == 0) {
				return pointer.getValue();
			} else {
				pointer = pointer.getNext();
			}
		}

		return null;
	}

	@Override
	public void remove(String k) {
		// TODO Auto-generated method stub
		int index = this.hash(k, this.size);
		HMCell pointer = this.tab[index];

		if (pointer != null) {
			if (pointer.getKey().compareTo(k) == 0) {
				this.tab[index] = pointer.getNext();
				nelts--;
			} else {
				while (pointer.getNext() != null) {
					if (pointer.getNext().getKey().compareTo(k) == 0) {
						pointer.setNext(pointer.getNext().getNext());
						nelts--;
					} else {
						pointer = pointer.getNext();
					}
				}
			}
		}
	}

	@Override
	public boolean hasKey(String k) {
		// TODO Auto-generated method stub
		if (nelts == 0) {
			return false;
		}

		int index = this.hash(k, this.size);
		HMCell pointer = this.tab[index];

		while (pointer != null) {
			if (pointer.getKey().compareTo(k) == 0) {
				return true;
			} else {
				pointer = pointer.getNext();
			}
		}

		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.nelts;
	}

	@Override
	public String maxKey() {
		// TODO Auto-generated method stub
		if (this.nelts == 0) {
			return null;
		}
		String key = null;
		HMCell pointer = null;
		int index = 0;

		for (int i = 0; i < this.size; i++) {
			if (this.tab[i] != null) {
				key = this.tab[i].getKey();
				index = i;
				break;
			}
		}

		for (int i = index; i < this.size; i++) {
			if (this.tab[i] != null) {
				pointer = this.tab[i];
				while (pointer != null) {
					if (pointer.getKey().compareTo(key) > 0) {
						key = pointer.getKey();
					}
					pointer = pointer.getNext();
				}
			}
		}

		return key;
	}

	@Override
	public String minKey() {
		// TODO Auto-generated method stub
		if (this.nelts == 0) {
			return null;
		}
		String key = null;
		HMCell pointer = null;
		int index = 0;

		for (int i = 0; i < this.size; i++) {
			if (this.tab[i] != null) {
				key = this.tab[i].getKey();
				index = i;
				break;
			}
		}

		for (int i = index; i < this.size; i++) {
			if (this.tab[i] != null) {
				pointer = this.tab[i];
				while (pointer != null) {
					if (pointer.getKey().compareTo(key) < 0) {
						key = pointer.getKey();
					}
					pointer = pointer.getNext();
				}
			}
		}

		return key;
	}

	@Override
	public String[] getKeys() {
		// TODO Auto-generated method stub
		String[] keys = new String[this.nelts];
		int index = 0;
		
		HMCell pointer = null;
		
		for(int i = 0; i < this.size; i ++) {
			pointer = this.tab[i];
			while (pointer != null) {
				keys[index] = pointer.getKey();
				index ++;
				pointer = pointer.getNext();
			}
			
		}
		
		return keys;
	}

	@Override
	public double lambda() {
		// TODO Auto-generated method stub
		return (double) nelts / this.size;
	}

	@Override
	public double extend() {
		// TODO Auto-generated method stub
		this.newTab = new HMCell[size*2];
		
		HMCell pointer = null;
		
		for(int i = 0; i < this.size; i ++) {
			pointer = tab[i];
			while (pointer != null) {
				int index = this.hash(pointer.getKey(), size*2);
				if(newTab[index] == null) {
					newTab[index] = pointer;
					pointer = pointer.getNext();
					newTab[index].setNext(null);
				} else {
					HMCell temp = pointer;
					pointer = pointer.getNext();
					temp.setNext(newTab[index]);
					newTab[index] = temp;
				}
			}
		}
		
		this.tab = newTab;
		size = size*2;
		
		
		return this.lambda();
	}

	// -------------------------------------------------------------
	// -------------------------------------------------------------
	// here down... you fill in the implementations for
	// the other interface methods
	// -------------------------------------------------------------

}
