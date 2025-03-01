00010  /**
00020  * A list that contains objects that can be inserted
00030  * or removed from either end of the list
00040  * as desired (but not the middle).
00050  */
00060  
00070  public class LinkedTwoEndedList implements TwoEndedList {
00080  
00090      private ListNode front;
00100  
00110      private int number = 0;
00120  
00130      // Instance variables representing ADT
00140      //
00150      // - temp0 is the new node to be added to the front
00160      // - temp1 is the new node to be added to the back
00170      // - temp2 is a temporary node
00180      // - temp3 finds the last node
00190      // - temp4 is the node to be deleted from the front
00200      // - temp5 finds the last node
00210      // - temp6 is the second-to-last node
00220  
00230  
00240      public void addFront (Object o) {
00250  
00260      ListNode temp0;
00270      if (size() < 1) {
00280          front = new ListNode(o);
00290          number++;
00300  
00310      }
00320  
00330      else {
00340  
00350          // hook it up
00360          temp0 = front;
00370          front = new ListNode(o);
00380          front.next = temp0;
00390          temp0.previous = front;
00400          number++; }
00410  
00420      }
00430  
00440  
00450      public void addBack (Object o) {
00460      ListNode temp1 = new ListNode (o);
00470      ListNode temp2 = front;
00480      if (front != null) {
00490      while (temp2.next != null) {
00500          temp2 = temp2.next;
00510      }
00520          temp2.next = temp1;
00530          temp1.previous = temp2;
00540      } else {
00550          front = temp1;
00560      }
00570      // increase the size
00580      number++;
00590      }
00600  
00610      public Object getFirst () {
00620      return front.contents;
00630      }
00640  
00650      public Object getLast () {
00660  
00670      // Initialize temp3 to a new node.
00680      ListNode temp3 = new ListNode(null);
00690  
00700      // Set temp3 to the front.
00710      temp3 = front;
00720  
00730      // As long as temp3's next isn't null...
00740      while (temp3.next != null) {
00750          // move to the next node.
00760          temp3 = temp3.next;
00770      }
00780  
00790      // Finally, return temp3's contents.
00800      return temp3.contents;
00810      }
00820  
00830      public Object removeFirst () {
00840      ListNode temp4 = new ListNode(null);
00850      if (front!=null && front.next!=null) {
00860          // the list has something in it
00870          temp4 = front;
00880          front = front.next;
00890          front.next.previous = null;
00900          temp4.next = null;
00910      }
00920      else if (front!=null && front.next==null) {
00930          // the list has something in it
00940          temp4 = front;
00950          front = null;
00960      }
00970      else {
00980          // the list has nothing in it
00990          temp4 = null;
01000      }
01010      return temp4;
01020      }
01030  
01040      public Object removeLast () {
01050      // start at the front
01060      ListNode temp5 = front;
01070      ListNode temp6 = front;
01080      if (front != null) {
01090          // find the end
01100          while (temp5.next != null) {
01110          temp6 = temp5;
01120          temp5 = temp5.next;
01130          }
01140          temp6.next = null;
01150      }
01160      // decrease it
01170      number--;
01180      return temp5.contents;
01190      }
01200  
01210      public int size () {
01220      return number;
01230      }
01240  }
