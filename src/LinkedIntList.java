import java.util.NoSuchElementException;

/**
 * Created by Olivi on 08-09-2016.
 */
// Class LinkedIntList can be used to store a list of integers.

public class LinkedIntList {
    private ListNode front;  // first value in the list

    // post: constructs an empty list
    public LinkedIntList() {
        front = null;
    }

    // post: returns the current number of elements in the list
    public int size() {
        int count = 0;
        ListNode current = front;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    // pre : 0 <= index < size()
    // post: returns the integer at the given index in the list
    public int get(int index) {
        return nodeAt(index).data;
    }

    // post: creates a comma-separated, bracketed version of the list
    public String toString() {
        if (front == null) {
            return "[]";
        } else {
            String result = "[" + front.data;
            ListNode current = front.next;
            while (current != null) {
                result += ", " + current.data;
                current = current.next;
            }
            result += "]";
            return result;
        }
    }

    // post : returns the position of the first occurrence of the given
    //        value (-1 if not found)
    public int indexOf(int value) {
        int index = 0;
        ListNode current = front;
        while (current != null) {
            if (current.data == value) {
                return index;
            }
            index++;
            current = current.next;
        }
        return -1;
    }

    // post: appends the given value to the end of the list
    public void add(int value) {
        if (front == null) {
            front = new ListNode(value);
        } else {
            ListNode current = front;
            while (current.next != null) { //n
                current = current.next;
            }
            current.next = new ListNode(value);
        }
    }

    // pre: 0 <= index <= size()
    // post: inserts the given value at the given index
    public void add(int index, int value) {
        if (index == 0) {
            front = new ListNode(value, front);
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = new ListNode(value, current.next);
        }
    }

    // pre : 0 <= index < size()
    // post: removes value at the given index
    public void remove(int index) {
        if (index == 0) {
            front = front.next;
        } else {
            ListNode current = nodeAt(index - 1);
            current.next = current.next.next;
        }
    }

    // pre : 0 <= i < size()
    // post: returns a reference to the node at the given index
    private ListNode nodeAt(int index) {
        ListNode current = front;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }


    //BLACK EXERCISES
    //Page 1027
    //Ex1
    public void set(int index, int value) {
        ListNode current = front;
        for (int i = 0; i <= index; i++) {
            if (i == index) {
                current.data = value;
            }
        }
    }

    //Ex2
    public int max() {
        ListNode current = front;
        int max = Integer.MIN_VALUE;
        if (current == null) {
            throw new NoSuchElementException();
        }
        while (current != null) {
            if (max < current.data) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    //Ex3
    public boolean isSorted() {
        ListNode current = front;
        int sorted = 0;
        if (current == null) {
            return true;
        }
        while (current != null) {
            if (current.data < current.next.data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Ex4
    public int lastindexOf(Integer value) {
        ListNode current = front;
        int lastIndexOf = -1;

        Integer index = 0;
        while (current != null) {
            if (current.data == value) {
                lastIndexOf = index;
            }
            index++;
            current = current.next;
        }
        return lastIndexOf;
    }

    //Ex5
    public int countDuplicates() {
        ListNode current = front;
        int countDuplicates = 0;

        while (current.next != null) {
            if (current.data == current.next.data) {
                countDuplicates++;
            }
            current = current.next;
        }
        return countDuplicates;
    }

    //Ex6
    public boolean hasTwoConsecutive() {
        ListNode current = front;
        while (current.next != null) {
            if (current.data == (current.next.data - 1)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Ex7
    public int deleteBack() {
        ListNode current = front;
        int lastValue = 0;
        if (current == null) {
            throw new NoSuchElementException();
        }

        while (current != null) {
            if (current.next.next == null) {
                lastValue = current.next.data;
                current.next = null;
            }
            //null pointer check
            current = current.next;
        }
        return lastValue;
    }

    //Ex8
    public void switchPairs() {
        ListNode current = front;         //first node in pair
        ListNode subsequent = front.next;   //second node in pair

        //while both nodes aren't null
        while(current != null && subsequent != null) {
            int temp = current.data;         //put first value in temp value
            current.data = subsequent.data;   //put second value in first node
            subsequent.data = temp;            //put temp value (first value) in second node

            //null pointer checks
            current = subsequent.next;        //iterate first node
            subsequent = subsequent.next;  //iterate second node
        }
    }

    //VIRKER!
    //Ex9
    public void stutter() {

        int size = size();

        for (int i = 0; i < size; i++) {
            add(get(i));
            add(get(i));
        }

        for (int i = 0; i < size; i++) {
            remove(0);
        }
    }


    //virker!
    //Ex10
    public void stretch(int n) {
        int size = size();

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= n; j++) {
                add(get(i));
            }
        }

        for (int i = 0; i < size; i++) {
            remove(0);
        }
     }

     //Printer ikke det sidste tal ud, hvis der er ulige antal
    //Ex11
    public void compress () {
        LinkedIntList list1 = new LinkedIntList();
        ListNode current = front;
        int sum = 0;

        while (current != null) {
            sum = current.data + current.next.data;
            list1.add(sum);

            current = current.next.next;
        }

        System.out.println(list1);
    }

    //Ex12
    //public split

    //Ex13
    //public void transferFrom (LinkedIntList list) {






}

