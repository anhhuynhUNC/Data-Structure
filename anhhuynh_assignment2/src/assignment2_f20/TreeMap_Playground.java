package assignment2_f20;

public class TreeMap_Playground {
static /*
 * you will test your own TreeMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the TMCells to see if they 
 * are all linked up correctly as a BST
 * 
*/
  int test = 0;
  public static void main(String[] args) {
    // you should test your TreeMap implementation in here
    // sample tests are shown

    // it is up to you to test it thoroughly and make sure
    // the methods behave as requested above in the interface
  
    // do not simple depend on the oracle test we will give
    // use the oracle tests as a way of checking AFTER you have done
    // your own testing

    // one thing you might find useful for debugging is a print tree method
    // feel free to use the one we have here ... basic and quick, or write one 
    // you like better, one that shows you the tree structure more clearly
    // the one we have here only shows keys, you may wish to add 
    // value fields to the printing

    TreeMap tm = new TreeMap_imp();
    Value v1 = new Value_imp(12345, 87.3, 21);
    Value v2 = new Value_imp(23456, 75.54, 25);
    Value v3 = new Value_imp(34567, 99.013, 19);
    Value v4 = new Value_imp(45678, 55.70, 35);
    
  
    TreeMap empty = new TreeMap_imp();
    TreeMap one = new TreeMap_imp();
    
    one.put("ONEBIG", v1);
    
    /*
    tm.put("kappa", v1);
    tm.put("beta",v2); 
    tm.put("sigma",v3);
    tm.put("alpha",v4); */
    
    System.out.println(tm.put("e", v1));
    tm.put("c",v2); 
    tm.put("w",v3);
    tm.put("b",v4);
    tm.put("bd",v3);
    tm.put("ab", v1);
    tm.put("ac", v1);
    tm.put("ad", v1);
    tm.put("a", v1);
    tm.put("d",v2); 
    tm.put("h",v3);
    
    tm.put("y",v4); 
    tm.put("z",v2);
    tm.put("zaaaa",v4);
    tm.put("x",v3);
    tm.put("zz",v3);
    tm.put("za",v3);
    System.out.println(tm.getRoot().getValue().getAge());
    System.out.println(tm.get("a").getAge());
    System.out.println(tm.get("dasdas"));
    
    tm.put("a",v3);
    System.out.println(tm.put("a",v2));
    
    String[] keys = tm.getKeys();
    String[] emptyS = empty.getKeys();
    String[] oneA = one.getKeys();
    
    System.out.println(tm.get("a").getAge());
 
    System.out.println(tm.size());
    
    System.out.println(tm.maxKey());
    System.out.println(tm.minKey());
    
    System.out.println(tm.hasKey("a"));
    System.out.println(tm.hasKey("zaaaa"));
    System.out.println(tm.hasKey("zaaa"));
    inOrder(tm.getRoot());
    
    for(int i = 0; i < tm.size(); i++) {
    	System.out.println(keys[i]);
    }
    
    System.out.println(tm.height());
    //EMPTY
    System.out.println("____EMPTY TESTS ____");
    System.out.println(empty.getRoot());
    System.out.println(empty.get("a"));
    System.out.println(empty.size());
    System.out.println(empty.maxKey());
    System.out.println(empty.minKey());
    System.out.println(empty.hasKey("a"));
    System.out.println(empty.height());
    System.out.println(emptyS);
    
    System.out.println("ONE TEST");
    //ONE
    System.out.println(one.getRoot());
    System.out.println(one.get("a"));
    System.out.println(one.size());
    System.out.println(one.maxKey());
    System.out.println(one.minKey());
    System.out.println(one.hasKey("a"));
    System.out.println(one.height());
    System.out.println(oneA[0]);
    
    //System.out.println(tm.get("sigma")); // assumes a toString for a Value onject
    System.out.println(tm.hasKey("gamma"));
    
  //  tm.remove("c");
  // tm.remove("a");
  // tm.remove("w");
  // tm.remove("h");
   //tm.remove("bd");
    one.put("ZZG", v2);
   one.put("ZIZ", v2);
  tm.remove("es");
    prTree(tm.getRoot(),0); 

    // etc...

  }

  public static void prTree (TMCell c, int off) {
    if (c==null) return;
        
    prTree(c.getRight(), off+2);
    
    for (int i=0; i<off; i++) System.out.print(" ");
    System.out.println(c.getKey());
    
    prTree(c.getLeft(), off+2);
  }

  
  public static void inOrder(TMCell c) {
	  if(c.getLeft()!= null) {
		  inOrder(c.getLeft());
	  }
	   
	  System.out.println(c.getKey());
	
	
	  
	  if(c.getRight()!= null) {
		  inOrder(c.getRight());
	  }
	  
  }
}