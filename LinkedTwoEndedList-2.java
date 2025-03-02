/**
 * A list that contains objects that can be inserted
 * or removed from either end of the list
 * as desired (but not the middle).
 */

 public class LinkedTwoEndedList implements TwoEndedList {

    private ListNode front; //Points to the first node in the list

    private int number = 0; // Tracks the total number of elements in the list

    // Instance variables representing ADT
    //
    // - temp0 is the new node to be added to the front
    // - temp1 is the new node to be added to the back
    // - temp2 is a temporary node
    // - temp3 finds the last node
    // - temp4 is the node to be deleted from the front
    // - temp5 finds the last node
    // - temp6 is the second-to-last node


    public void addFront (Object o) {

    ListNode temp0;
    if (size() < 1) {
        front = new ListNode(o);
        number++;

    }

    else {

        // hook it up
        temp0 = front;
        front = new ListNode(o);
        front.next = temp0;
        temp0.previous = front;
        number++; }

    }


    public void addBack (Object o) {
    ListNode temp1 = new ListNode (o);
    ListNode temp2 = front;
    if (front != null) {
    while (temp2.next != null) {
        temp2 = temp2.next;
    }
        temp2.next = temp1;
        temp1.previous = temp2;
    } else {
        front = temp1;
    }
    // increase the size
    number++;
    }

    public Object getFirst () {
    return front.contents;
    }

    public Object getLast () {

    // Initialize temp3 to a new node.
    ListNode temp3 = new ListNode(null);

    // Set temp3 to the front.
    temp3 = front;

    // As long as temp3's next isn't null...
    while (temp3.next != null) {
        // move to the next node.
        temp3 = temp3.next;
    }

    // Finally, return temp3's contents.
    return temp3.contents;
    }

    public Object removeFirst () {
    ListNode temp4 = new ListNode(null);
    if (front!=null && front.next!=null) {
        // the list has something in it
        temp4 = front;
        front = front.next;
        front.next.previous = null;
        temp4.next = null;
    }
    else if (front!=null && front.next==null) {
        // the list has something in it
        temp4 = front;
        front = null;
    }
    else {
        // the list has nothing in it
        temp4 = null;
    }
    return temp4;
    }

    public Object removeLast () {
    // start at the front
    ListNode temp5 = front;
    ListNode temp6 = front;
    if (front != null) {
        // find the end
        while (temp5.next != null) {
        temp6 = temp5;
        temp5 = temp5.next;
        }
        temp6.next = null;
    }
    // decrease it
    number--;
    return temp5.contents;
    }

    public int size () {
    return number;
    }
}
