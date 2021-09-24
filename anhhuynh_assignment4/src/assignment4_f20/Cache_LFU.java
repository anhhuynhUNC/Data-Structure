package assignment4_f20;

import java.util.HashMap;

public class Cache_LFU implements Cache {
  
  HashMap<String, CacheFrame> map; 
    // allocate from java collections lib
    // do it this way so we all start with default size and 
    // default lambda and default hash function for string keys
  MinBinHeap heap; // your own heap code above
  int limit;       // max num elts the cache can hold
  int size;        // current number elts in the cache
  
  Cache_LFU (int maxElts) {
    this.map = new HashMap<String, CacheFrame>();
    this.heap = new MinBinHeap(maxElts);
    this.limit = maxElts;
    this.size = 0;
  }
  
  // dont change this we need it for grading
  public MinBinHeap getHeap() { return this.heap; }
  public HashMap getHashMap() { return this.map; }

@Override
public int size() {
	// TODO Auto-generated method stub
	return this.limit;
}

@Override
public int numElts() {
	// TODO Auto-generated method stub
	return this.size;
}

@Override
public boolean isFull() {
	// TODO Auto-generated method stub
	if (numElts() >= size()) {
		return true;
	}
	return false;
}

@Override
public boolean refer(String address) {
	// TODO Auto-generated method stub
	if(!this.map.containsKey(address) && !isFull()) {
		CacheFrame newFrame = new CacheFrame(address,1);
		this.heap.insert(newFrame);
		this.map.put(address,newFrame);
		
		size++;
		return false;
	} 
	if(this.map.containsKey(address)) {
		CacheFrame temp = this.map.get(address);
		this.heap.incElt(temp);
		return true;
	} 
	if (!this.map.containsKey(address) && isFull()){
		this.map.remove(this.heap.getHeap()[1].getValue());
		this.heap.delMin();
		size --;
		
		this.refer(address);
	}
	
	return false;
}
  
  // =========================================================
  //
  // you fill in code for the other ops in the interface
  //
  //==========================================================
  
}