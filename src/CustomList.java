public class CustomList {
    
    private Node head;

    public CustomList() {
        this.head = null;
    }

    public CustomList(Node newHead) {
        this.head = newHead;
    }

    /**
     * Adds a new node at the end of the list
     * @param newNode new node to be added
     */
    public void append(Node newNode) {
        if (head == null)
            head = newNode;
        else 
            appendNext(head, newNode);

    }

    private void appendNext(Node node, Node nuovo){
        if (node.getNext() == null){
            node.setNext(nuovo);
        } else {
            appendNext(node.getNext(), nuovo);
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
