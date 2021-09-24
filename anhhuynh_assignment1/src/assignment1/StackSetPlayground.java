package assignment1;

public class StackSetPlayground {

  public static void main(String[] args) { 
    /*
     here you can instantiate your StackSet and play around with it to check correctness. 
     We've graciously also provided you a bit of extra test data for debugging.
     It doesn't matter what you have in here. We will not grade it. 
     This is for your use in testing your implementation.
    */
	  
	  //SETTING THE STACK
    StackSet set = new StackSet(10);
    System.out.println(set);
   System.out.println(set.push(10));
   System.out.println(set.push(10));
   System.out.println(set.push(11));
   set.contains(11);
   set.contains(11);
   set.contains(11);
   set.contains(12);
   
   set.contains(13);
   set.contains(10);
   set.contains(11);
   System.out.println(set.push(11));
   System.out.println(set.push(12));
   System.out.println(set.push(13));
   
    /*
    set.push(2);
    System.out.println(set.contains(1));
    set.push(1);
    System.out.println(set.contains(1));
    set.push(3);
    set.push(4);
    set.push(5);
    set.push(6);
    
    set.push(4);
    set.push(1);
    set.push(7);
    
    
    set.push(7);
    */
   //System.out.println( set.pop());
   set.pop();
    set.pop();
    set.pop();
    set.pop();
    set.pop();
    set.pop();
    set.pop();
    set.pop();
    
    
  //  System.out.println(set.getRoot().getValue());
//  System.out.println(set.getRoot().getNext().getValue());
 //  System.out.println(set.getRoot().getNext().getNext().getValue());
   //System.out.println(set.getRoot().getNext().getNext().getNext().getValue());
 // 	System.out.println(set.getRoot().getNext().getNext().getNext().getNext().getValue());
  // System.out.println(set.getRoot().getNext().getNext().getNext().getNext().getNext().getValue());
  //  System.out.println(set.contains(1));
    //set.push(1);
    //System.out.println(set);
    /* System.out.println(set.pop());
    set.push(1);
    set.push(2);
    set.push(3);
    System.out.println(set);
    set.push(4);
    System.out.println(set);*/
    
    //OTHERs
    System.out.println(set.size());
    System.out.println(set.limit());
    System.out.println(set.isEmpty());
    System.out.println(set.isFull());
    System.out.println(set.peek());
  }
  
}