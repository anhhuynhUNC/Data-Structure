package assignment3_f20;

public class HashMap_Playground {
/*
 * you will test your own HashMap implementation in here
 *
 * we will replace this with our own when grading, and will
 * do what you should do in here... create TreeMap objects,
 * put data into them, take data out, look for values stored
 * in it, checking size, and looking at the HMCells to see if they 
 * are all linked up correctly chains in the hash table
 * 
*/
  
  public static void main(String[] args) {
    // sample manual tests are shown
    // it is up to you to test it thoroughly and make sure
    // the methods behave as requested above in the interface
  
    // do not simple depend on the oracle test we will give
    // use the oracle tests as a way of checking AFTER you have done
    // your own testing
	  int testSize = 21;

    HashMap hm = new HashMap_imp(testSize);
    HashMap empty = new HashMap_imp(10);
    HashMap one = new HashMap_imp(1);
    
    System.out.println(hm.getTable().length); // expect 40
    System.out.println(hm.size()); // expect 0

    Value v1 = new Value_imp(12345, 87.3, 21);
    Value v2 = new Value_imp(23456, 75.54, 25);
    Value v3 = new Value_imp(34567, 99.013, 19);
    Value v4 = new Value_imp(45678, 55.70, 35);
    Value v5 = new Value_imp(56789, 77.91, 32);
    Value v6 = new Value_imp(67890, 83.03, 24);
    
    hm.put("Jenny", v1);  hm.put("Bill",v2); 
    hm.put("Steve",v3);   hm.put("Alan",v4);
    hm.put("Gail",v5);    hm.put("Zed",v6);
    hm.put("Wilma",v6);   hm.put("Lauren",v6);
    hm.put("Xray",v6);	 System.out.println(hm.put("Zed",v5));
    
    hm.put("Lauren",v1);
    hm.put("Lauren",v2);
    hm.put("Lauren",v3);
    hm.put("Lauren",v5);
    hm.put("Lauren",v4);
    
    hm.put("Test", v3);
    
    
    //hm.put("Zzzz",v5);
   // hm.put("z", v1);
    
    hm.remove("DUma");
   hm.remove("Bill");
    hm.remove("Alan");
    
    hm.put("Test1", v3);
    
    hm.put("Test2", v3);
    
    hm.put("Test3", v3);
    hm.put("Test4", v3);
    hm.put("Test5", v3);
    hm.put("Test6", v3);
    hm.put("Test7", v3);
    hm.put("Test8", v3);
    hm.put("Test9", v3);
    hm.put("Test10", v3);
    hm.put("Test11", v3);
   hm.put("Test12", v3);
   hm.put("Test13", v3);
    
    
    //hm.extend();
    //hm.extend();

    printTable(hm,hm.getTable().length);
    
    
    
    System.out.println("NUMBER OF ELEMTENTS " + hm.lambda());
    System.out.println(hm.size());
    
    System.out.println(hm.hash("z", testSize));
    
   System.out.println(hm.get("Zed"));
   System.out.println(hm.get("Steve"));
   System.out.println(hm.get("Lauren"));
   System.out.println(hm.get("Ze"));
   System.out.println(hm.get("Zedd"));
    
   System.out.println(hm.hasKey("Alan"));
   System.out.println(hm.hasKey("Steve"));
   System.out.println(hm.hasKey("Xray"));
   System.out.println(hm.hasKey("Zed"));
   System.out.println(hm.hasKey("Jenny"));
   
   System.out.println("MAX: " + hm.maxKey());
   System.out.println("MIN: " + hm.minKey());
   String a = "Zed";
   String b = "ZZzz";
   
   System.out.println(a.compareTo(b));
   String keys = "";
   
   for(int i = 0; i < hm.lambda()*hm.getTable().length; i ++) {
	   keys += " " +  hm.getKeys()[i];
   }
   System.out.println(keys);
    
    System.out.println(hm.getTable().length); // expect 9
    System.out.println(hm.hasKey("Bill")); // expect true
    System.out.println(hm.hasKey("Zorro")); // expect false
    hm.extend();
    System.out.println(hm.getTable().length); // expect 9
    System.out.println(hm.hasKey("Bill")); // expect true
    System.out.println(hm.hasKey("Zorro")); // expect false
    
    System.out.println("ONE TEST----------------");
    one.put("random", v2);
    one.put("random", v2);
    one.put("random", v2);
    
    one.put("random", v2);
    one.put("random", v2);
   // one.put("random1", v3);
 
    printTable(one,one.getTable().length);
    
    
    System.out.println("NUMBER OF ELEMTENTS " + one.lambda());
    System.out.println(one.size());
    
    System.out.println(one.hash("z", testSize));
    
   System.out.println(one.get("Zed"));
   System.out.println(one.get("Steve"));
   System.out.println(one.get("random"));
    
   System.out.println(one.hasKey("Alan"));
   System.out.println(one.hasKey("Steve"));
   
   System.out.println("MAX: " + one.maxKey());
   System.out.println("MIN: " + one.minKey());
   System.out.println(one.hasKey("random")); // expect true
   System.out.println(one.hasKey("Zorro")); // expect false
   
   String keys2 = "";
   for(int i = 0; i < one.lambda()*one.getTable().length; i ++) {
	   keys2 += " " +  one.getKeys()[i];
   }
   System.out.println(keys2);
   System.out.println("BLANK TEST----------------");
   
   empty.remove("Du");
   
   printTable(empty,empty.getTable().length);
   
   
   System.out.println("NUMBER OF ELEMTENTS " + empty.getTable().length);
   System.out.println(empty.size());
   
   System.out.println(empty.hash("z", testSize));
   
  System.out.println(empty.get("Zed"));
  System.out.println(empty.get("Steve"));
  System.out.println(empty.get("random"));
   
  System.out.println(empty.hasKey("Alan"));
  System.out.println(empty.hasKey("Steve"));
  
  System.out.println("MAX: " + empty.maxKey());
  System.out.println("MIN: " + empty.minKey());
  System.out.println(empty.hasKey("random")); // expect true
  System.out.println(empty.hasKey("Zorro")); // expect false
  
  String keys3 = "";
  for(int i = 0; i < empty.lambda()*empty.getTable().length; i ++) {
	   keys3 += " " +  empty.getKeys()[i];
  }
  System.out.println(keys3);
   
    
    

    // etc...

  }
  
  public static void printTable(HashMap x, int size) {
	  for(int i = 0; i < size; i++) {
	    	String k = "" + i;
	    	HMCell val = null;
	    	val = x.getTable()[i];
	    	while(val != null) {
	    		k += "  " +  val.getKey();
	    		val = val.getNext();
	    	}
	    	System.out.println(k);
	    }
  }

}