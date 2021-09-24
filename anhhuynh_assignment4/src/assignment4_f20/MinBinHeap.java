package assignment4_f20;

public class MinBinHeap implements Heap {
	private CacheFrame[] array; // load this array
	private int size; // how many items currently in the heap
	private int arraySize; // Everything in the array will initially
							// be null. This is ok! Just build out
							// from array[1]
	private int insertIndex;

	public MinBinHeap(int nelts) {
		this.array = new CacheFrame[nelts + 1]; // remember we dont use slot 0
		this.arraySize = nelts + 1;
		this.size = 0;
		this.array[0] = new CacheFrame(null, 0); // 0 not used, so this is arbitrary

		this.insertIndex = 1;
	}

	// Please do not remove or modify this method! Used to test your entire Heap.
	@Override
	public CacheFrame[] getHeap() {
		return this.array;
	}

	@Override
	public void insert(CacheFrame elt) {
		// TODO Auto-generated method stub
		if(insertIndex > arraySize - 1) {
			return;
		}
		this.array[insertIndex] = elt;
		elt.setSlot(insertIndex);

		insertIndex++;
		size++;

		CacheFrame temp = elt;

		while (temp.getSlot() != 1) {
			CacheFrame tempParent = this.array[temp.getSlot() / 2];
			if (temp.getPriority() >= tempParent.getPriority()) {
				break;
			} else {
				this.array[temp.getSlot()] = tempParent;

				tempParent.setSlot(temp.getSlot());
				temp.setSlot(temp.getSlot() / 2);
			}
		}

		this.array[temp.getSlot()] = elt;
	}

	@Override
	public void delMin() {
		// TODO Auto-generated method stub
		if (size == 0) {
			return;
		}

		if (size() == 1) {
			this.array[1] = null;
			size--;
			insertIndex = 1;
			return;
		}
		this.array[1] = this.array[insertIndex - 1];

		CacheFrame temp = this.array[1];
		this.array[insertIndex - 1] = null;

		insertIndex--;
		size--;

		temp.setSlot(1);

		if (array[temp.getSlot() * 2] == null) {
			return;
		}
		while (array[temp.getSlot() * 2] != null) {
			CacheFrame x;
			CacheFrame tempLChild = this.array[temp.getSlot() * 2];

			x = tempLChild;
			if (temp.getSlot() * 2 + 1 <= arraySize - 1) {
				CacheFrame tempRChild = this.array[temp.getSlot() * 2 + 1];

				if (tempRChild != null) {
					x = (tempLChild.getPriority() <= tempRChild.getPriority()) ? tempLChild : tempRChild;
				} else {
					x = tempLChild;
				}
			}

			if (temp.getPriority() <= x.getPriority()) {
				break;
			} else {
				this.array[temp.getSlot()] = x;

				int childIndex = x.getSlot();
				x.setSlot(temp.getSlot());
				temp.setSlot(childIndex);
			}

			if (temp.getSlot() * 2 > arraySize - 1) {
				break;
			}
		}

		this.array[temp.getSlot()] = temp;

	}

	@Override
	public CacheFrame getMin() {
		// TODO Auto-generated method stub
		return this.array[1];
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.size;
	}

	@Override
	public void incElt(CacheFrame elt) {
		// TODO Auto-generated method stub
		elt.setPriority(elt.getPriority() + 1);
		CacheFrame temp = elt;
		if(temp.getSlot()*2 > arraySize - 1) {
			
			return;
		}
		if (array[temp.getSlot() * 2] == null ) {
		
			return;
		}
		while (array[temp.getSlot() * 2] != null) {
			CacheFrame x;
			CacheFrame tempLChild = this.array[temp.getSlot() * 2];

			x = tempLChild;
			if (temp.getSlot() * 2 + 1 <= arraySize - 1) {
				CacheFrame tempRChild = this.array[temp.getSlot() * 2 + 1];

				if (tempRChild != null) {
					x = (tempLChild.getPriority() <= tempRChild.getPriority()) ? tempLChild : tempRChild;
				} else {
					x = tempLChild;
				}
			}

			if (temp.getPriority() <= x.getPriority()) {
				/*System.out.println("BP");
				System.out.println(arraySize -1);
				System.out.println(temp.getSlot());
				System.out.println(temp.getPriority());
				System.out.println("X" + x.getPriority());
				System.out.println(temp.getValue());
				*/ 
				
				break;
			} else {
				this.array[temp.getSlot()] = x;

				int childIndex = x.getSlot();
				x.setSlot(temp.getSlot());
				temp.setSlot(childIndex);
			}

			if (temp.getSlot() * 2 > arraySize - 1) {
				break;
			}
		}

		this.array[temp.getSlot()] = elt;
	}

	@Override
	public void decElt(CacheFrame elt) {
		// TODO Auto-generated method stub
		if (elt.getPriority() == 1) {
			return;
		}
		elt.setPriority(elt.getPriority() - 1);
		CacheFrame temp = elt;

		while (temp.getSlot() != 1) {
			CacheFrame tempParent = this.array[temp.getSlot() / 2];
			if (temp.getPriority() >= tempParent.getPriority()) {
				break;
			} else {
				this.array[temp.getSlot()] = tempParent;

				tempParent.setSlot(temp.getSlot());
				temp.setSlot(temp.getSlot() / 2);
			}
		}

		this.array[temp.getSlot()] = elt;
	}

	// ===============================================================
	//
	// here down you implement the ops in the interface
	//
	// ===============================================================

}