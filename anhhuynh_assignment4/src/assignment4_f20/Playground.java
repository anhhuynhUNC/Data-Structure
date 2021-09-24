package assignment4_f20;

import java.util.Arrays;
import java.util.HashMap;

public class Playground {
	public static void main(String[] args) {
		// Add more tests as methods and call them here!!

		Heap heap = new MinBinHeap(10);
		CacheFrame ob1 = new CacheFrame("a", 1);
		CacheFrame ob2 = new CacheFrame("b", 3);
		CacheFrame ob3 = new CacheFrame("c", 2);
		CacheFrame ob4 = new CacheFrame("d", 5);
		CacheFrame ob5 = new CacheFrame("e", 10);
		CacheFrame ob6 = new CacheFrame("f", 12);
		CacheFrame ob7 = new CacheFrame("g", 120);
		CacheFrame ob8 = new CacheFrame("h", 1000);
		CacheFrame ob9 = new CacheFrame("i", 1);
		heap.insert(ob1);
		heap.insert(ob2);
		heap.insert(ob3);
		heap.insert(ob4);
		heap.insert(ob5);
		heap.insert(ob6);

		heap.insert(ob7);
		heap.insert(ob8);

		heap.delMin();
		heap.delMin();
		heap.delMin();
		heap.delMin();
		heap.delMin();
		heap.delMin();
		heap.delMin();
		heap.delMin();
		heap.insert(ob5);
		heap.insert(ob6);

		heap.insert(ob7);
		heap.insert(ob1);
		heap.insert(ob3);
		heap.insert(ob4);
		heap.insert(ob2);
		heap.insert(ob8);

		heap.insert(ob8);
		heap.insert(ob8);
		heap.insert(ob8);
		
		heap.insert(ob8);
		
		heap.insert(ob8);
		/*
		 * heap.decElt(ob4); heap.decElt(ob4); heap.decElt(ob4); heap.incElt(ob1);
		 * heap.incElt(ob1); heap.incElt(ob2); heap.incElt(ob2); heap.incElt(ob2);
		 */
		heap.insert(ob9);

		System.out.println("SIZE: " + heap.size());
		System.out.println("MIN: " + heap.getMin());
		printHeap(heap.getHeap(), 10);
		System.out.println(9 / 10);

		System.out.println("CACHE TEST -----------------");
		RunMyTests();
		// etc.
	}

	public static void RunMyTests() {
		Cache_LFU lfc = new Cache_LFU(1);
		lfc.refer("AA8C");
		lfc.refer("AA8C");
		lfc.refer("1234");
		lfc.refer("234A");
		lfc.refer("AA8C");
		System.out.println(lfc.refer("1234"));
		lfc.refer("ABCD");
		lfc.refer("ABCD");
		System.out.println(lfc.refer("ABCD1"));
		
		
		System.out.println("IS FULL?" + lfc.isFull());
		System.out.println(lfc.size());
		System.out.println(lfc.numElts());
		for (Object key : lfc.getHashMap().keySet()) {
			System.out.println(key.hashCode() + " "+ key.toString() + "  " + ((CacheFrame) lfc.getHashMap().get(key)).getSlot());
		}
		printHeap(lfc.getHeap().getHeap(), lfc.getHeap().size());

		// etc.
		//System.out.println(lfc.getHeap().getHeap()[1]);
		System.out.println(Arrays.toString(lfc.getHeap().getHeap()));
	}

	public static void printHeap(CacheFrame[] e, int len) {
		// this method skips over unused 0th index....
		System.out.println("Printing Heap");
		for (int i = 1; i < len + 1; i++) {
			if (e[i] != null) {
				System.out.print("(p." + e[i].value + ",f" + e[i].priority + ",s" + e[i].getSlot() + ")\t");
			} else {
				System.out.print("Nothing  ");
			}
		}
		System.out.print("\n");
	}

}