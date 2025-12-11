public class CustomList {
    
    private Node head;

    public CustomList() {
        this.head = null;
    }

    public CustomList(Node newHead) {
        this.head = newHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {
        if (isEmpty())
            this.head = newNode;
        else 
            append(head, newNode);

    }

    private void append(Node node, Node nuovo){
        if (node.getNext() == null){
            node.setNext(nuovo);
        } else {
            append(node.getNext(), nuovo);
        }
    }

    /**
     * Outputs every list item on the console
     */
    public void print() {
        System.out.print("List: [");
        printNext(head);

    }

    private void printNext(Node node){
        if(node == null){
            System.out.println("]");
            return;
        } else if (node.getNext() == null){
            System.out.print(node.getValue());
        } else {
            System.out.print(node.getValue() + ", ");
        }

        printNext(node.getNext());
    }


}
