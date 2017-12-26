
/** *******************************************************************
 * Purpose/Description: <This program will add and remove elements and check if an
 * element is inside the list using the Node class. It will also sort the list in
 * order.>
 * Certification: I hereby certify that this work is my own and none of it is
 * the work of any other person.
 * ******************************************************************
 */
public class MySortedSingleList {

    private Node<Comparable> head;
    final int COMPARE = 0;

    /**
     * Constructs the MySortedSingleList for any object in the main class.
     */
    public MySortedSingleList() {
        this.head = null;
    }

    private class Node<Comparable> {

        Node() {
            this(null, null);
        }

        Node(Comparable d) {
            this(d, null);
        }

        Node(Comparable d, Node n) {
            data = d;
            next = n;
        }
        Comparable data;
        Node next;
    }

    void print() {
        Node<Comparable> currentNode = head;
        String output = "";
        while (currentNode != null) {
            output += "[" + currentNode.data + "]";
            currentNode = currentNode.next;
        }
        System.out.println(output);
    }

    /**
     * Will compare if the input is equal to any element on the list.
     *
     * @param element is the input value you wish to search for.
     * @return true if the element is on the list, false if it is not.
     */
    public boolean contains(Comparable element) {
        Node currentNode = head;
        while (currentNode != null) {
            if (element.compareTo(currentNode.data) == COMPARE) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    /**
     * Will add an element to the list if it is not already on it, and it will
     * sort the element in order.
     *
     * @param element value the user uses.
     * @return true if the element can be added, false if the element is already
     * on the list.
     */
    public boolean add(Comparable element) {
        if(contains(element)){
            return false;
        }
        if(head == null || element.compareTo(head.data) < COMPARE){
            head = new Node(element,head);
        }
        else{
            Node currentNode = head;
            while(currentNode.next != null && element.compareTo(currentNode.next.data) > COMPARE){
                currentNode = currentNode.next;
            }
            currentNode.next = new Node(element, currentNode.next);
        }
        return true;
    }

    /**
     * Will remove an element off of the list if it is found on the list.
     *
     * @param element value the user uses.
     * @return true if the element was eliminated, false if it was not found on
     * the list.
     */
    public boolean remove(Comparable element) {
        if (head == null || !contains(element)) {
            return false;
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            if (element.compareTo(currentNode.next.data) == COMPARE) {
                currentNode.next = currentNode.next.next;
            } else {
                currentNode = currentNode.next;
            }
        }
        if (element.compareTo(head.data) == COMPARE) {
            head = head.next;
        }
        return true;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySortedSingleList list = new MySortedSingleList();
        final int FIRST_TEST = 1;
        final int SECOND_TEST = 2;
        final int THIRD_TEST = 3;
        final int FOURTH_TEST = 2;
        System.out.println("Order in which the elements are being added: " + FIRST_TEST + ","
                + THIRD_TEST + "," + SECOND_TEST + "," + FOURTH_TEST);
        list.add(FIRST_TEST);
        list.add(THIRD_TEST);
        list.add(SECOND_TEST);
        list.add(FOURTH_TEST);
        list.print();
        if (list.remove(SECOND_TEST)) {
            System.out.println(SECOND_TEST + " was removed from the list.");
        } else {
            System.out.println(SECOND_TEST + " was not found on the list.");
        }
        list.print();
        if (list.contains(THIRD_TEST)) {
            System.out.println(THIRD_TEST + " is on the list.");
        } else {
            System.out.println(THIRD_TEST + " is not on the list.");
        }
        list.print();
    }

}
