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

    public void add (int index, Node newNode) {
        if (index == 0){
            newNode.setNext(head);
            this.head = newNode;
        } else if (index > 0 && index <= size()){
            Node prev = get(index -1);
            newNode.setNext(prev.getNext());
            prev.setNext(newNode);
        } else {
            throw new IndexOutOfBoundsException("Invalid Position");
        }

    }

    private Node getRec(Node cursor, int index) throws IndexOutOfBoundsException{
        if (index == 0)
            return head;

        return getRec(cursor.getNext(), index-1);

    }

    public Node get(int index) throws IndexOutOfBoundsException{
        //check if index is invalid
        if (index <0 || index >= size())
            throw new IndexOutOfBoundsException("Invalid index");
        return getRec(head, index);
    }

    private int sizeRec(Node cursor){
        if (cursor == null)
            return 0;
        return sizeRec(cursor.getNext()) +1;
    }

    public int size(){
        return sizeRec(head);
    }


}
